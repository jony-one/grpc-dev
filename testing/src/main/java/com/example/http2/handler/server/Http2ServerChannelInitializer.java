package com.example.http2.handler.server;

import com.example.http2.handler.HttpServerHandler;
import com.sun.net.httpserver.HttpServer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2ServerUpgradeCodec;
import io.netty.handler.ssl.SslContext;
import io.netty.util.AsciiString;

public class Http2ServerChannelInitializer extends ChannelInitializer<SocketChannel> {



    private final EventLoopGroup    bizGroup;
    private final HttpServerHandler serverHandler;
    private final int               maxHttpContentLength;

    public Http2ServerChannelInitializer(EventLoopGroup bizGroup, HttpServerHandler serverHandler, int maxHttpContentLength) {
        if (maxHttpContentLength < 0) {
            throw new IllegalArgumentException("maxHttpContentLength (expected >= 0): " + maxHttpContentLength);
        }
        this.bizGroup = bizGroup;
        this.maxHttpContentLength = maxHttpContentLength;
        this.serverHandler = serverHandler;
    }


    /**
     * 商量升级 h2c
     * @param ch
     * @throws Exception
     */
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        final ChannelPipeline p = ch.pipeline();
        final HttpServerCodec sourceCodec = new HttpServerCodec();
        final HttpServerUpgradeHandler upgradeHandler = new HttpServerUpgradeHandler(sourceCodec, new HttpServerUpgradeHandler.UpgradeCodecFactory() {
            @Override
            public HttpServerUpgradeHandler.UpgradeCodec newUpgradeCodec(CharSequence protocol) {
                if (AsciiString.contentEquals(Http2CodecUtil.HTTP_UPGRADE_PROTOCOL_NAME,protocol)){
                    return new Http2ServerUpgradeCodec(new Http2ChannelHandlerBuilder(serverHandler).build());
                }
                return null;
            }
        });



        final Http2ServerUpgradeHandler cleartextHttp2ServerUpgradeHandler =
                new Http2ServerUpgradeHandler(bizGroup, sourceCodec, upgradeHandler,
                        new Http2ChannelHandlerBuilder(serverHandler).build());

        p.addLast("Http2ServerUpgradeHandler", cleartextHttp2ServerUpgradeHandler);
    }
}
