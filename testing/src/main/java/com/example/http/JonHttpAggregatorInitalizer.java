package com.example.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class JonHttpAggregatorInitalizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("http-server-codec",new HttpServerCodec());
        ch.pipeline().addLast("aggregator", new HttpObjectAggregator(512*1024));
        ch.pipeline().addLast("handler", new JonHttpRequestHandler());
    }
}
