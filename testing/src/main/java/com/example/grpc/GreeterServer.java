package com.example.grpc;

import com.example.service.GreeterImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreeterServer {

    public static void main(String[] args) {
        int port = 15001;
        Server server = null;
        try {
//            server = NettyServerBuilder.forPort(port)
//                    .addService(new GreeterImpl())
//                    .build()
//                    .start();

            server = ServerBuilder.forPort(port)
                    .addService(new GreeterImpl())
                    .build()
                    .start();

            server.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
            server.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("server shutdown");
        }
    }
}
