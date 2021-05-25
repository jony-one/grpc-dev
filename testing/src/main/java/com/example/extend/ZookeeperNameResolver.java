package com.example.extend;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import io.grpc.InternalServiceProviders;
import io.grpc.NameResolver;
import io.grpc.internal.DnsNameResolver;
import io.grpc.internal.GrpcUtil;

import java.net.URI;

public class ZookeeperNameResolver extends io.grpc.NameResolverProvider {


    @Override
    protected boolean isAvailable() {
        return true;
    }

    @Override
    protected int priority() {
        return 99;
    }

    @Override
    public String getDefaultScheme() {
        return "neo";
    }
    private static final String SCHEME = "dns";
    @Override
    public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        System.out.println(targetUri);
        System.out.println(args);

        String name = targetUri.toString();
        return new DnsNameResolver(
                null,
                name,
                args,
                GrpcUtil.SHARED_CHANNEL_EXECUTOR,
                Stopwatch.createUnstarted(),
                InternalServiceProviders.isAndroid(getClass().getClassLoader()));
    }

}
