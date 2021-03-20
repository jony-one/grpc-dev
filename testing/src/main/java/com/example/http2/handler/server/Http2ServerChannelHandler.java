package com.example.http2.handler.server;

import com.example.http2.handler.HttpServerHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http2.*;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Http2ServerChannelHandler extends Http2ConnectionHandler implements Http2FrameListener {


    private final Http2Connection.PropertyKey headerKey        = encoder().connection().newKey();
    private final Http2Connection.PropertyKey messageKey       = encoder().connection().newKey();

    private final HttpServerHandler           serverHandler;

    private boolean                           isUpgradeH2cMode = false;

    Http2ServerChannelHandler(HttpServerHandler serverHandler, Http2ConnectionDecoder decoder,
                              Http2ConnectionEncoder encoder,
                              Http2Settings initialSettings) {
        super(decoder, encoder, initialSettings);
        this.serverHandler = serverHandler;
    }

    private static Http2Headers http1HeadersToHttp2Headers(FullHttpRequest request) {
        CharSequence host = request.headers().get(HttpHeaderNames.HOST);
        Http2Headers http2Headers = new DefaultHttp2Headers()
                .method(HttpMethod.GET.asciiName())
                .path(request.uri())
                .scheme(HttpScheme.HTTP.name());
        if (host != null) {
            http2Headers.authority(host);
        }
        return http2Headers;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        /*
         * Handles the cleartext HTTP upgrade event. If an upgrade occurred, sends a simple response via HTTP/2
         * on stream 1 (the stream specifically reserved for cleartext HTTP upgrade).
         */
        if (evt instanceof HttpServerUpgradeHandler.UpgradeEvent) {
            HttpServerUpgradeHandler.UpgradeEvent upgradeEvent =
                    (HttpServerUpgradeHandler.UpgradeEvent) evt;
            this.isUpgradeH2cMode = true;
            onHeadersRead(ctx, 1, http1HeadersToHttp2Headers(upgradeEvent.upgradeRequest()), 0, true);
        }
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        System.out.println(this.getClass() + " exceptionCaught =============>");
        ctx.close();
    }

    @Override
    public int onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, int padding, boolean endOfStream) {
        int processed = data.readableBytes() + padding;

        Http2Stream http2Stream = connection().stream(streamId);
        ByteBuf msg = http2Stream.getProperty(messageKey);
        if (msg == null) {
            msg = ctx.alloc().buffer();
            http2Stream.setProperty(messageKey, msg);
        }
        final int dataReadableBytes = data.readableBytes();
        msg.writeBytes(data, data.readerIndex(), dataReadableBytes);

        if (endOfStream) {
            // read cached http2 header from stream
            Http2Headers headers = http2Stream.getProperty(headerKey);
            handleRequest(ctx, streamId, headers, msg);
        }
        return processed;
    }

    @Override
    public void onHeadersRead(ChannelHandlerContext ctx, int streamId,
                              Http2Headers headers, int padding, boolean endOfStream) {
        /**
         * https://http2.github.io/http2-spec/#rfc.section.5.1.1 second paragraph
         * only when in upgrade h2c mode, 0x01 cannot be selected as a new stream identifier.
         * some gateway or proxy product, use 0x01 as first normal request's stream id  when
         * in prior knowleadge mode.
         */
        if (this.isUpgradeH2cMode && streamId > 1 || !this.isUpgradeH2cMode && streamId > 0) {
            // 正常的请求（streamId==1 的是settings请求）
            if (endOfStream) {
                // 没有DATA帧的请求，可能是DATA
                handleRequest(ctx, streamId, headers, null);
            } else {
                // 缓存起来
                connection().stream(streamId).setProperty(headerKey, headers);
            }
        }
    }

    protected void handleRequest(ChannelHandlerContext ctx, int streamId, Http2Headers http2Headers, ByteBuf data) {
        String uri = http2Headers.path() == null?"":http2Headers.path().toString();
        // ignore uris
        if ("/favicon.ico".equals(uri)) {
            sendHttp2Response(ctx, streamId, HttpResponseStatus.OK, Unpooled.EMPTY_BUFFER.toString());
            return;
        }

        CharSequence reqMethod = http2Headers.method()==null?"":http2Headers.method();
        // HEAD for check method exists
        if (reqMethod.equals(HttpMethod.HEAD.name())) {
//            String[] iam = HttpTransportUtils.getInterfaceIdAndMethod(uri);
            // 检查是否符合服务方式
            sendHttp2Response(ctx, streamId, HttpResponseStatus.OK , null);
            return;
        }
        // POST(primary) / GET for invoke
        else if (!reqMethod.equals(HttpMethod.POST.name())) {
            // 不支持 POST 以外请求
            sendHttp2Response(ctx, streamId, HttpResponseStatus.BAD_REQUEST, "Only support POST/HEAD");
            return;
        }

        /**
         * https://http2.github.io/http2-spec/#rfc.section.5.1.1 second paragraph
         * only when in upgrade h2c mode, 0x01 cannot be selected as a new stream identifier.
         * some gateway or proxy product, use 0x01 as first normal request's stream id  when
         * in prior knowleadge mode.
         */
        if (this.isUpgradeH2cMode && streamId > 1 || !this.isUpgradeH2cMode && streamId > 0) {
            // 本来这里可以提前检查接口方法是否存在，但是为了日志统一，全部放到serverHandler里去
            FullHttpRequest sofaRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,HttpMethod.GET,"");

            try {
                // 处理信息
                serverHandler.handleHttp2Request(streamId, sofaRequest, ctx, encoder());
            } catch (Exception e) {
                System.out.println("抛出异常");
                sendHttp2Response(ctx, streamId, HttpResponseStatus.INTERNAL_SERVER_ERROR, e.getMessage());
            }
        }
    }


    /**
     * 用作与异常响应
     * @param ctx
     * @param streamId
     * @param status
     * @param result
     */
    protected void sendHttp2Response(ChannelHandlerContext ctx, int streamId, HttpResponseStatus status, String result) {
        // Send a frame for the response status
        Http2Headers headers = new DefaultHttp2Headers().status(status.codeAsText());
        if (!HttpResponseStatus.OK.equals(status)) {
            headers.set("neo_head_response_error", "true");
        }
        if (StringUtil.isNullOrEmpty(result)) {
            ByteBuf data = ctx.alloc().buffer();
            data.writeBytes(result.getBytes(CharsetUtil.UTF_8));
            encoder().writeHeaders(ctx, streamId, headers, 0, false, ctx.newPromise());
            encoder().writeData(ctx, streamId, data, 0, true, ctx.newPromise());
        } else {
            encoder().writeHeaders(ctx, streamId, headers, 0, true, ctx.newPromise());
        }
    }

    @Override
    public void onHeadersRead(ChannelHandlerContext ctx, int streamId, Http2Headers headers, int streamDependency,
                              short weight, boolean exclusive, int padding, boolean endOfStream) {
        onHeadersRead(ctx, streamId, headers, padding, endOfStream);
    }



    @Override
    public void onPriorityRead(ChannelHandlerContext ctx, int streamId, int streamDependency,
                               short weight, boolean exclusive) {
    }

    @Override
    public void onRstStreamRead(ChannelHandlerContext ctx, int streamId, long errorCode) {
    }

    @Override
    public void onSettingsAckRead(ChannelHandlerContext ctx) {
    }

    @Override
    public void onSettingsRead(ChannelHandlerContext ctx, Http2Settings settings) {
    }

    @Override
    public void onPingRead(ChannelHandlerContext ctx, long data) {
    }

    @Override
    public void onPingAckRead(ChannelHandlerContext ctx, long data) {
    }

    @Override
    public void onPushPromiseRead(ChannelHandlerContext ctx, int streamId, int promisedStreamId,
                                  Http2Headers headers, int padding) {
    }

    @Override
    public void onGoAwayRead(ChannelHandlerContext ctx, int lastStreamId, long errorCode, ByteBuf debugData) {
    }

    @Override
    public void onWindowUpdateRead(ChannelHandlerContext ctx, int streamId, int windowSizeIncrement) {
    }

    @Override
    public void onUnknownFrame(ChannelHandlerContext ctx, byte frameType, int streamId,
                               Http2Flags flags, ByteBuf payload) {
    }
}
