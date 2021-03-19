package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: hello_world.proto")
public final class HelloServiceGrpc {

  private HelloServiceGrpc() {}

  public static final String SERVICE_NAME = "HelloService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayFuchGrp",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getSayFuchGrpMethod;
    if ((getSayFuchGrpMethod = HelloServiceGrpc.getSayFuchGrpMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayFuchGrpMethod = HelloServiceGrpc.getSayFuchGrpMethod) == null) {
          HelloServiceGrpc.getSayFuchGrpMethod = getSayFuchGrpMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayFuchGrp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("sayFuchGrp"))
              .build();
        }
      }
    }
    return getSayFuchGrpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcSStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayFuchGrpcSStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcSStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getSayFuchGrpcSStreamMethod;
    if ((getSayFuchGrpcSStreamMethod = HelloServiceGrpc.getSayFuchGrpcSStreamMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayFuchGrpcSStreamMethod = HelloServiceGrpc.getSayFuchGrpcSStreamMethod) == null) {
          HelloServiceGrpc.getSayFuchGrpcSStreamMethod = getSayFuchGrpcSStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayFuchGrpcSStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("sayFuchGrpcSStream"))
              .build();
        }
      }
    }
    return getSayFuchGrpcSStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcRStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayFuchGrpcRStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcRStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getSayFuchGrpcRStreamMethod;
    if ((getSayFuchGrpcRStreamMethod = HelloServiceGrpc.getSayFuchGrpcRStreamMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayFuchGrpcRStreamMethod = HelloServiceGrpc.getSayFuchGrpcRStreamMethod) == null) {
          HelloServiceGrpc.getSayFuchGrpcRStreamMethod = getSayFuchGrpcRStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayFuchGrpcRStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("sayFuchGrpcRStream"))
              .build();
        }
      }
    }
    return getSayFuchGrpcRStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayFuchGrpcStream",
      requestType = HelloRequest.class,
      responseType = HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<HelloRequest,
      HelloResponse> getSayFuchGrpcStreamMethod() {
    io.grpc.MethodDescriptor<HelloRequest, HelloResponse> getSayFuchGrpcStreamMethod;
    if ((getSayFuchGrpcStreamMethod = HelloServiceGrpc.getSayFuchGrpcStreamMethod) == null) {
      synchronized (HelloServiceGrpc.class) {
        if ((getSayFuchGrpcStreamMethod = HelloServiceGrpc.getSayFuchGrpcStreamMethod) == null) {
          HelloServiceGrpc.getSayFuchGrpcStreamMethod = getSayFuchGrpcStreamMethod =
              io.grpc.MethodDescriptor.<HelloRequest, HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayFuchGrpcStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloServiceMethodDescriptorSupplier("sayFuchGrpcStream"))
              .build();
        }
      }
    }
    return getSayFuchGrpcStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceStub>() {
        @Override
        public HelloServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceStub(channel, callOptions);
        }
      };
    return HelloServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceBlockingStub>() {
        @Override
        public HelloServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloServiceFutureStub>() {
        @Override
        public HelloServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloServiceFutureStub(channel, callOptions);
        }
      };
    return HelloServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HelloServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayFuchGrp(HelloRequest request,
                           io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayFuchGrpMethod(), responseObserver);
    }

    /**
     */
    public void sayFuchGrpcSStream(HelloRequest request,
                                   io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayFuchGrpcSStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayFuchGrpcRStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSayFuchGrpcRStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayFuchGrpcStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSayFuchGrpcStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayFuchGrpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_SAY_FUCH_GRP)))
          .addMethod(
            getSayFuchGrpcSStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_SAY_FUCH_GRPC_SSTREAM)))
          .addMethod(
            getSayFuchGrpcRStreamMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_SAY_FUCH_GRPC_RSTREAM)))
          .addMethod(
            getSayFuchGrpcStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                HelloRequest,
                HelloResponse>(
                  this, METHODID_SAY_FUCH_GRPC_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class HelloServiceStub extends io.grpc.stub.AbstractAsyncStub<HelloServiceStub> {
    private HelloServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayFuchGrp(HelloRequest request,
                           io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayFuchGrpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayFuchGrpcSStream(HelloRequest request,
                                   io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSayFuchGrpcSStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayFuchGrpcRStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSayFuchGrpcRStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<HelloRequest> sayFuchGrpcStream(
        io.grpc.stub.StreamObserver<HelloResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSayFuchGrpcStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HelloServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloServiceBlockingStub> {
    private HelloServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public HelloResponse sayFuchGrp(HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayFuchGrpMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<HelloResponse> sayFuchGrpcSStream(
        HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSayFuchGrpcSStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HelloServiceFutureStub> {
    private HelloServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected HelloServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HelloResponse> sayFuchGrp(
        HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayFuchGrpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_FUCH_GRP = 0;
  private static final int METHODID_SAY_FUCH_GRPC_SSTREAM = 1;
  private static final int METHODID_SAY_FUCH_GRPC_RSTREAM = 2;
  private static final int METHODID_SAY_FUCH_GRPC_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_FUCH_GRP:
          serviceImpl.sayFuchGrp((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
          break;
        case METHODID_SAY_FUCH_GRPC_SSTREAM:
          serviceImpl.sayFuchGrpcSStream((HelloRequest) request,
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_FUCH_GRPC_RSTREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayFuchGrpcRStream(
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
        case METHODID_SAY_FUCH_GRPC_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayFuchGrpcStream(
              (io.grpc.stub.StreamObserver<HelloResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return HelloProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloService");
    }
  }

  private static final class HelloServiceFileDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier {
    HelloServiceFileDescriptorSupplier() {}
  }

  private static final class HelloServiceMethodDescriptorSupplier
      extends HelloServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloServiceFileDescriptorSupplier())
              .addMethod(getSayFuchGrpMethod())
              .addMethod(getSayFuchGrpcSStreamMethod())
              .addMethod(getSayFuchGrpcRStreamMethod())
              .addMethod(getSayFuchGrpcStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
