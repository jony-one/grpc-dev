package com.example.service;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayFuchGrp(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        HelloResponse response = HelloResponse.newBuilder().setReply(name + "\t" + "hahahhhaa").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 单向服务端
     * @param request
     * @param responseObserver
     */
    @Override
    public void sayFuchGrpcSStream(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("我被调用了 \t");
//        super.sayFuchGrpcSStream(request, responseObserver);
        String name = request.getName();
        HelloResponse response;
        response = HelloResponse.newBuilder().setReply(name + "\t" + "1").build();
        responseObserver.onNext(response);
        response = HelloResponse.newBuilder().setReply(name + "\t" + "2").build();
        responseObserver.onNext(response);
        response = HelloResponse.newBuilder().setReply(name + "\t" + "3").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 单向 请求 Stream
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<HelloRequest> sayFuchGrpcRStream(StreamObserver<HelloResponse> responseObserver) {
//        HelloResponse response = HelloResponse.newBuilder().setReply("->->->->->->->->->->" + "\t" + "->hahahhhaa").build();
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();

        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest value) {
                System.out.println("服务端连续返回请求 ->->->->" + value);
            }

            @Override
            public void onError(Throwable t) {

                System.out.println("服务端连续返回请求失败 ->->->->");
            }

            @Override
            public void onCompleted() {
                System.out.println("服务端连续返回请求完成 ->->->->");
            }
        };
    }

    /**
     * 双向流
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<HelloRequest> sayFuchGrpcStream(StreamObserver<HelloResponse> responseObserver) {
        return super.sayFuchGrpcStream(responseObserver);
    }
}
