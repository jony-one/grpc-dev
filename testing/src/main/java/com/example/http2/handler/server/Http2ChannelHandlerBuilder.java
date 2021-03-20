package com.example.http2.handler.server;

import com.example.http2.handler.HttpServerHandler;
import io.netty.handler.codec.http2.*;
import io.netty.handler.logging.LogLevel;

public final class Http2ChannelHandlerBuilder
        extends
        AbstractHttp2ConnectionHandlerBuilder<Http2ServerChannelHandler, Http2ChannelHandlerBuilder> {

    private static final Http2FrameLogger LOGGER = new Http2FrameLogger(LogLevel.DEBUG, HttpServerHandler.class);

    private final HttpServerHandler       serverHandler;

    public Http2ChannelHandlerBuilder(HttpServerHandler serverHandler) {
        frameLogger(LOGGER);
        this.serverHandler = serverHandler;
    }

    @Override
    public Http2ServerChannelHandler build() {
        return super.build();
    }

    @Override
    protected Http2ServerChannelHandler build(Http2ConnectionDecoder decoder, Http2ConnectionEncoder encoder,
                                              Http2Settings initialSettings) {
        Http2ServerChannelHandler handler = new Http2ServerChannelHandler(serverHandler, decoder, encoder,initialSettings);
        frameListener(handler);
        return handler;
    }
}
