package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class GreeterImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayFuchGrp(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();
        HelloResponse response = HelloResponse.newBuilder().setReply(name + ":" + "hahahhhaa").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
