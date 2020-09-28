package site.vipertoothlabs.kafkaclients.client

import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.KafkaConsumer
import site.vipertoothlabs.kafkaclients.config.KotlinConsumerConfig
import java.time.Duration
import java.util.*


class KafkaConsumerClient {

    private fun kotlinKafkaConsumer(): Consumer<String, String> {
        val properties = Properties()

        // Connection
        properties["bootstrap.servers"] = KotlinConsumerConfig.bootstrapServers
        properties["auto.offset.reset"] = KotlinConsumerConfig.autoOffsetReset
        properties["key.deserializer"] = KotlinConsumerConfig.keyDeserializer
        properties["value.deserializer"] = KotlinConsumerConfig.valueDeserializer
        properties["group.id"] = KotlinConsumerConfig.groupId
        properties["group.instance.id"] = KotlinConsumerConfig.groupInstanceId
        properties["client.id"] = KotlinConsumerConfig.clientId
        properties["allow.auto.create.topics"] = KotlinConsumerConfig.allowAutoCreateTopics
        properties["client.dns.lookup"] = KotlinConsumerConfig.clientDnsLookup
        properties["enable.auto.commit"] = KotlinConsumerConfig.enableAutoCommit
        properties["exclude.internal.topics"] = KotlinConsumerConfig.excludeInternalTopics

        // Performance
        properties["fetch.min.bytes"] = KotlinConsumerConfig.fetchMaxBytes
        properties["fetch.min.bytes"] = KotlinConsumerConfig.fetchMinBytes
        properties["heartbeat.interval.ms"] = KotlinConsumerConfig.heartbeatIntervalMs
        properties["max.partition.fetch.bytes"] = KotlinConsumerConfig.maxPartitionFetchBytes
        properties["session.timeout.ms"] = KotlinConsumerConfig.sessionTimeoutMs
        properties["auto.commit.interval.ms"] = KotlinConsumerConfig.autoCommitIntervalMs
        properties["request.timeout.ms"] = KotlinConsumerConfig.requestTimeoutMs
        properties["max.poll.records"] = KotlinConsumerConfig.maxPollRecords
        properties["max.poll.interval.ms"] = KotlinConsumerConfig.maxPollIntervalMs
        properties["default.api.timeout.ms"] = KotlinConsumerConfig.defaultApiTimeoutMs
        properties["connections.max.idle.ms"] = KotlinConsumerConfig.connectionsMaxIdleMs
        properties["send.buffer.bytes"] = KotlinConsumerConfig.sendBufferBytes
        properties["receive.buffer.bytes"] = KotlinConsumerConfig.receiveBufferBytes
        properties["isolation.level"] = KotlinConsumerConfig.isolationLevel

        // Security
        properties["security.protocol"] = KotlinConsumerConfig.securityProtocol
        properties["ssl.keystore.location"] = KotlinConsumerConfig.sslKeystoreLocation
        properties["ssl.truststore.location"] = KotlinConsumerConfig.sslTrustStoreLocation
        properties["ssl.keystore.password"] = KotlinConsumerConfig.sslKeystorePassword
        properties["ssl.truststore.password"] = KotlinConsumerConfig.sslTruststorePassword
        properties["ssl.key.password"] = KotlinConsumerConfig.sslKeyPassword

        return KafkaConsumer<String, String>(properties)
    }

    private val consumer: Consumer<String, String> = kotlinKafkaConsumer()

    fun consume() {
        val topic = KotlinConsumerConfig.topicList
        consumer.subscribe(listOf(topic))
        val subscription = consumer.subscription()
        println("Subscribed to: $subscription")

        try {
            while (true) {
                val records = consumer.poll(Duration.ofMillis(15000))
                val it = records.iterator()
                it.forEach {
                    val key = it.key()
                    val value = it.value()
                    val offset = it.offset()
                    val timestamp = it.timestamp()
                    println("Key: $key, Value: $value, Offset: $offset, Timestamp: $timestamp")
                    consumer.commitSync(Duration.ofMillis(500))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            consumer.close()
        }
    }
}

fun main() {
    val kotlinKafkaConsumer = KafkaConsumerClient()
    kotlinKafkaConsumer.consume()
}
