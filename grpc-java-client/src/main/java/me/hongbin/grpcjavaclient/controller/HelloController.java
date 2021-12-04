package me.hongbin.grpcjavaclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.hongbin.grpcjavaclient.client.GrpcClient;

@RestController
public class HelloController {

    private final GrpcClient grpcClient;

    public HelloController(GrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping
    public String test() {
        return grpcClient.sampleCall();
    }
}
