package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreeterClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1",50051).usePlaintext().build();
        HelloServiceGrpc.HelloServiceBlockingStub stub  = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse response = stub.sayFuchGrp(HelloRequest.newBuilder().setName("123456 up shan play triger").build());
        System.out.println(response.toString());
        channel.shutdown();
    }
}
