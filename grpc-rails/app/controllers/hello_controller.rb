require './lib/test_services_pb'

class HelloController < ApplicationController

  def index

    # client = Helloworld::Greeter::Stub.new(hostname, :this_channel_is_insecure)

    begin
      request = ::Grpc::Sample::SampleRequest.new(userId: '1', message: "test")

      client = ::Grpc::Sample::SampleService::Stub.new('127.0.0.1:3030', :this_channel_is_insecure)
      message = client.sample_call(request)
      p "Greeting: #{message.message}"
    rescue => e
      abort "ERROR: #{e.message}"
    end


  end
end