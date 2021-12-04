package me.hongbin.grpcjavaclient.client;

import org.springframework.stereotype.Component;

import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import me.hongbin.simplerpc.SampleRequest;
import me.hongbin.simplerpc.SampleResponse;
import me.hongbin.simplerpc.SampleServiceGrpc;

@Slf4j
@Component
public class GrpcClient {

    private static final int PORT = 3030;
    public static final String HOST = "127.0.0.1";
    private final SampleServiceGrpc.SampleServiceStub asyncStub = SampleServiceGrpc.newStub(
        ManagedChannelBuilder.forAddress(HOST, PORT)
            .usePlaintext()
            .build()
    );

    public String sampleCall() {
        SampleRequest sampleRequest = SampleRequest.newBuilder()
            .setUserId("hongbin.kim")
            .setMessage("grpc request")
            .build();

        asyncStub.sampleCall(sampleRequest, new StreamObserver<>() {
            @Override
            public void onNext(SampleResponse value) {
                log.info("GrpcClient#sampleCall - {}", value);
            }

            @Override
            public void onError(Throwable t) {
                log.error("GrpcClient#sampleCall - onError");
            }

            @Override
            public void onCompleted() {
                log.info("GrpcClient#sampleCall - onCompleted");
            }
        });
        return "string";
    }
}
