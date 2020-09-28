package site.vipertoothlabs.kafkaclients.config

import java.lang.System.getenv

// This class defines and sets defaults for all the consumer config properties for the Kafka consumer.

object KotlinConsumerConfig {
    val topicList: String = getenv("TOPIC_LIST")
    val keyDeserializer: String = getenv("KEY_DESERIALIZER") ?: "org.apache.kafka.common.serialization.ByteArrayDeserializer"
    val valueDeserializer: String = getenv("VALUE_DESERIALIZER") ?: "org.apache.kafka.common.serialization.ByteArrayDeserializer"
    val bootstrapServers: String = getenv("BOOTSTRAP_SERVERS") ?: "localhost:9092"
    val fetchMinBytes: Int = (getenv("FETCH_MIN_BYTES") ?: "1").toInt()
    val groupId: String = getenv("GROUP_ID") ?: "kafkaClient"
    val heartbeatIntervalMs: Int = (getenv("HEARTBEAT_INTERVAL_MS") ?: "3000").toInt()
    val maxPartitionFetchBytes: Int = (getenv("MAX_PARTITION_FETCH_BYTES") ?: "1048576").toInt()
    val sessionTimeoutMs: Int = (getenv("SESSION_TIMEOUT_MS") ?: "10000").toInt()
    val sslKeyPassword: String = getenv("SSL_KEY_PASSWORD") ?: "changeMe"
    val sslKeystoreLocation: String = getenv("SSL_KEYSTORE_LOCATION") ?: "/var/private/ssl/keystore.jks"
    val sslKeystorePassword: String = getenv("SSL_KEYSTORE_PASSWORD") ?: "changeMe"
    val sslTrustStoreLocation: String = getenv("SSL_TRUSTSTORE_LOCATION") ?: "/var/private/ssl/truststore.jks"
    val sslTruststorePassword: String = getenv("SSL_TRUSTSTORE_PASSWORD") ?: "changeMe"
    val allowAutoCreateTopics: String = getenv("ALLOW_AUTO_CREATE_TOPICS") ?: "false"
    val autoOffsetReset: String = getenv("AUTO_OFFSET_RESET") ?: "earliest"
    val clientDnsLookup: String = getenv("CLIENT_DNS_LOOKUP") ?: "default"
    val connectionsMaxIdleMs: Long = (getenv("CONNECTIONS_MAX_IDLE_MS") ?: "540000").toLong()
    val defaultApiTimeoutMs: Int = (getenv("DEFAULT_API_TIMEOUT_MS") ?: "60000").toInt()
    val enableAutoCommit: String = getenv("ENABLE_AUTO_COMMIT") ?: "false"
    val excludeInternalTopics: String = getenv("EXCLUDE_INTERNAL_TOPICS") ?: "true"
    val fetchMaxBytes: Int = (getenv("FETCH_MAX_BYTES") ?: "52428800").toInt()
    val groupInstanceId: String = getenv("GROUP_INSTANCE_ID") ?: "kafkaGroupInstance"
    val isolationLevel: String = getenv("ISOLATION_LEVEL") ?: "read_committed"
    val maxPollIntervalMs: Int = (getenv("MAX_POLL_INTERVAL_MS") ?: "300000").toInt()
    val maxPollRecords: Int = (getenv("MAX_POLL_RECORDS") ?: "500").toInt()
    val receiveBufferBytes: Int = (getenv("RECEIVE_BUFFER_BYTES") ?: "65536").toInt()
    val requestTimeoutMs: Int = (getenv("REQUEST_TIMEOUT_MS") ?: "30000").toInt()
    val securityProtocol: String = getenv("SECURITY_PROTOCOL") ?: "PLAINTEXT"
    val sendBufferBytes: Int = (getenv("SEND_BUFFER_BYTES") ?: "131072").toInt()
    val autoCommitIntervalMs: Int = (getenv("AUTO_COMMIT_INTERVAL_MS") ?: "5000").toInt()
    val clientId: String = getenv("CLIENT_ID") ?: "kafkaClient"
}