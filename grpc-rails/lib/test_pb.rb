# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: test.proto

require 'google/protobuf'

Google::Protobuf::DescriptorPool.generated_pool.build do
  add_file("test.proto", :syntax => :proto3) do
    add_message "grpc.sample.SampleRequest" do
      optional :userId, :string, 1
      optional :message, :string, 2
    end
    add_message "grpc.sample.SampleResponse" do
      optional :message, :string, 1
    end
  end
end

module Grpc
  module Sample
    SampleRequest = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("grpc.sample.SampleRequest").msgclass
    SampleResponse = ::Google::Protobuf::DescriptorPool.generated_pool.lookup("grpc.sample.SampleResponse").msgclass
  end
end
