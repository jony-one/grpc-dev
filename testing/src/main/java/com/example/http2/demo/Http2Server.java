package com.example.http2.demo;


import com.example.http2.handler.HttpServerHandler;
import com.example.http2.handler.server.Http2ServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class Http2Server {


    public static void main(String[] args) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap =
                new ServerBootstrap()
                .group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
                .option(ChannelOption.ALLOCATOR, ByteBufAllocator.DEFAULT)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childOption(ChannelOption.TCP_NODELAY,true)
                .childOption(ChannelOption.SO_RCVBUF, 8192 * 128)
                .childOption(ChannelOption.SO_SNDBUF, 8192 * 128)
                .childOption(ChannelOption.ALLOCATOR, ByteBufAllocator.DEFAULT)
                .childHandler(new Http2ServerChannelInitializer(workGroup,new HttpServerHandler(),8*1024*1024))
                ;

        ChannelFuture future = serverBootstrap.bind(new InetSocketAddress("127.0.0.1",8080));
        ChannelFuture channelFuture = future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                System.out.println("服务结束");
            }
        });
        try {
            channelFuture.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
