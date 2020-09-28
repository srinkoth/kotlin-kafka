#!/usr/bin/env bash

# client ID
export CLIENT_ID=kafkaClient

# Bootstrap servers
export BOOTSTRAP_SERVERS=bfbd6e33817e:9092

# topic name
export TOPIC=backblaze_smart

# Serializers
export KEY_SERIALIZER=org.apache.kafka.common.serialization.StringSerializer
export VALUE_SERIALIZER=org.apache.kafka.common.serialization.StringSerializer

# Performance
export ACKS=all
export PARTITIONER_CLASS=org.apache.kafka.clients.producer.internals.DefaultPartitioner
export BUFFER_MEMORY=33554432
export COMPRESSION_TYPE=none
export RETRIES=2147483647
export BATCH_SIZE=16384
export CLIENT_DNS_LOOKUP=default
export CONNECTION_MAX_IDLE_MS=540000
export DELIVERY_TIMEOUT_MS=120000
export LINGER_MS=0