package me.hongbin.grpcserver.service;


import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import me.hongbin.simplerpc.SampleRequest;
import me.hongbin.simplerpc.SampleResponse;
import me.hongbin.simplerpc.SampleServiceGrpc;

@Slf4j
public class SampleServiceImpl extends SampleServiceGrpc.SampleServiceImplBase {

    @Override
    public void sampleCall(SampleRequest request, StreamObserver<SampleResponse> responseObserver) {
        log.info("SampleServiceImpl#sampleCall - {}, {}", request.getUserId(), request.getMessage());

        SampleResponse response = SampleResponse.newBuilder()
            .setMessage("grpc service response")
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
