package site.vipertoothlabs.kafkaclients.config

import java.lang.System.getenv


object KotlinProducerConfig {
    val clientId: String = getenv("CLIENT_ID") ?: "kafkaClient"
    val topic: String = getenv("TOPIC") ?: "backblaze_smart"
    val keySerializer: String = getenv("KEY_SERIALIZER") ?: "org.apache.kafka.common.serialization.StringSerializer"
    val valueSerializer: String = getenv("≈") ?: "org.apache.kafka.common.serialization.StringSerializer"
    val acks: String = getenv("ACKS") ?: "all"
    val bootstrapServers: String = getenv("BOOTSTRAP_SERVERS") ?: "localhost:9092"
    val partitionerClass: String = getenv("PARTITIONER_CLASS") ?: "org.apache.kafka.clients.producer.internals.DefaultPartitioner"
    val bufferMemory: Long = (getenv("BUFFER_MEMORY") ?: "33554432").toLong()
    val compressionType: String = getenv("COMPRESSION_TYPE") ?: "none"
    val retries: Int = (getenv("RETRIES") ?: "2147483647").toInt()
    val batchSize: Int = (getenv("BATCH_SIZE") ?: "16384").toInt()
    val clientDnsLookup: String = getenv("CLIENT_DNS_LOOKUP") ?: "default"
    val connectionMaxIdleMs: Long = (getenv("CONNECTION_MAX_IDLE_MS") ?: "540000").toLong()
    val deliveryTimeoutMs: Long = (getenv("DELIVERY_TIMEOUT_MS") ?: "120000").toLong()
    val lingerMs: Int = (getenv("LINGER_MS") ?: "0").toInt()
//    val maxBlockMs: Long = (getenv("MAX_BLOCK_MS") ?: "60000").toLong()
//    val maxRequestSize: Int = (getenv("MAX_REQUEST_SIZE") ?: "1048576").toInt()
//    val receiveBufferBytes: Int = (getenv("RECEIVE_BUFFER_BYTES") ?: "32768").toInt()
//    val requestTimeoutMs: Int = (getenv("REQUEST_TIMEOUT_MS") ?: "30000").toInt()
//    val securityProtocol: String = (getenv("SECURITY_PROTOCOL") ?: "PLAINTEXT")
//    val sendBufferBytes: Int = (getenv("SEND_BUFFER_BYTES") ?: "131072").toInt()
//    val enableIdempotence: String = (getenv("ENABLE_IDEMPOTENCE") ?: "false")
//    val maxInFlightRequestsPerConnection: Int = (getenv("MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION") ?: "5").toInt()
//    val metadataMaxAgeMs: Long = (getenv("METADATA_MAX_AGE_MS") ?: "300000").toLong()
//    val sslKeystoreLocation: String = getenv("SSL_KEYSTORE_LOCATION") ?: "/var/private/ssl/keystore.jks"
//    val sslTruststoreLocation: String = getenv("SSL_TRUSTSTORE_LOCATION") ?: "/var/private/ssl/truststore.jks"
//    val sslKeystorePassword: String = getenv("SSL_KEYSTORE_PASSWORD") ?: "changeMe"
//    val sslTruststorePassword: String = getenv("SSL_TRUSTSTORE_PASSWORD") ?: "changeMe"
//    val sslKeyPassword: String = getenv("SSL_KEY_PASSWORD") ?: "changeMe"
//    val transactionTimeoutMs: Int = (getenv("TRANSACTION_TIMEOUT_MS") ?: "60000").toInt()
//    val transactionalId: String = getenv("TRANSACTIONAL_ID") ?: "transactionalId"
}