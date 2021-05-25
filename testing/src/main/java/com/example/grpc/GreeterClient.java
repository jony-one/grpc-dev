package com.example.grpc;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.*;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Arrays;

public class GreeterClient {

    public static void main(String[] args) {
        block();
//        serverStream();
//        requestStream();
//        try {
//            HelloResponse.parseFrom(new byte[0]);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }
//        byte[] bytes = new byte[]{10, 26, 49, 50, 51, 52, 53, 54, 32, 117, 112, 32, 115, 104, 97, 110, 32, 112, 108, 97, 121, 32, 116, 114, 105, 103, 101, 114};
//        try {
//            HelloResponse response = HelloResponse.parseFrom(bytes);
//            System.out.println(response);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        }
    }

    public static void block(){
        // 创建 ManagedChannelImpl
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("my.domain.com",15001)
                .usePlaintext()
                .build();
        NameResolverRegistry.getDefaultRegistry();
        // 创建客户端 Stub
        HelloServiceGrpc.HelloServiceBlockingStub stub  = HelloServiceGrpc.newBlockingStub(channel);
        HelloRequest request = HelloRequest.newBuilder().setName("fadsfasfsafsafsafdsf").build();
        System.out.println(Arrays.toString(request.toByteArray()));
        // 发起 RPC 调用，获取响应
        HelloResponse response = stub.sayFuchGrp(HelloRequest.newBuilder().setName("123456 up shan play triger").build());

        System.out.println("返回结果 ==========>" +response.toString());
        channel.shutdown();
    }

    public static void serverStream(){
        // 创建 ManagedChannelImpl
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1",15001).usePlaintext().build();
        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(channel);

        stub.sayFuchGrpcSStream(HelloRequest.newBuilder().setName("123456 up shan play triger").build(), new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse value) {
                System.out.println("服务端连续响应：" + value);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("服务端连续响应出错");
            }

            @Override
            public void onCompleted() {
                System.out.println("服务端连续响应结束");
            }
        });

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void requestStream(){
        // 创建 ManagedChannelImpl
        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1",15001).usePlaintext().build();
        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(channel);

        io.grpc.stub.StreamObserver<HelloRequest>  result = stub.sayFuchGrpcRStream(new StreamObserver<HelloResponse>() {
            @Override
            public void onNext(HelloResponse value) {
                System.out.println("请求响应" + value);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("请求响应错误");
            }

            @Override
            public void onCompleted() {
                System.out.println("请求响应完成");
            }
        });
        result.onNext(HelloRequest.newBuilder().setName("123456 up shan play triger1").build());
        result.onNext(HelloRequest.newBuilder().setName("123456 up shan play triger2").build());
        result.onNext(HelloRequest.newBuilder().setName("123456 up shan play triger3").build());
        result.onCompleted();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
