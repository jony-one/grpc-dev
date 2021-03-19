package com.example.http2.handler;

import io.netty.channel.AbstractChannel;

public interface ServerHandler {

    /**
     * Register channel.
     *
     * @param nettyChannel the netty channel
     */
    void registerChannel(AbstractChannel nettyChannel);

    /**
     * Un register channel.
     *
     * @param nettyChannel the netty channel
     */
    void unRegisterChannel(AbstractChannel nettyChannel);
}
