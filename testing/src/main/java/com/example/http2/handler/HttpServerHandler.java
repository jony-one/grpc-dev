package com.example.http2.handler;

import io.netty.channel.AbstractChannel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;

import java.util.concurrent.RejectedExecutionException;

public class HttpServerHandler implements ServerHandler  {
    @Override
    public void registerChannel(AbstractChannel nettyChannel) {

    }

    @Override
    public void unRegisterChannel(AbstractChannel nettyChannel) {

    }

    /**
     * Handle request from HTTP/2
     *
     * @param streamId stream Id
     * @param request SofaRequest
     * @param ctx ChannelHandlerContext
     * @param encoder Http2ConnectionEncoder
     */
    public void handleHttp2Request(int streamId, FullHttpMessage request, ChannelHandlerContext ctx,
                                   Http2ConnectionEncoder encoder) {
        System.out.println("task  h2c and logic handler response");
        System.out.println("task  h2c and logic handler response");
        System.out.println("task  h2c and logic handler response");
        System.out.println("task  h2c and logic handler response");
//        Http2ServerTask task = new Http2ServerTask(this, request, ctx, streamId, encoder);
//
//        processingCount.incrementAndGet();
//        try {
//            task.run();
//        } catch (RejectedExecutionException e) {
//            processingCount.decrementAndGet();
//            throw e;
//        }
    }
}
