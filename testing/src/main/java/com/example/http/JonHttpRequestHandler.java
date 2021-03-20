package com.example.http;

import com.google.api.HttpBody;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpUtil.is100ContinueExpected;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@ChannelHandler.Sharable
public class JonHttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        System.out.println("channelRead0");
        System.out.println(req.content());
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.copiedBuffer("f;ldsakf;lsak;",CharsetUtil.UTF_8));
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
