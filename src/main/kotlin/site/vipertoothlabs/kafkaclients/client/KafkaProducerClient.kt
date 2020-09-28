package site.vipertoothlabs.kafkaclients.client

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import site.vipertoothlabs.kafkaclients.config.KotlinProducerConfig
import java.util.*

class KafkaProducerClient {

    private fun kotlinKafkaProducer(): Producer<String, String> {
        val properties = Properties()

        // Connection
        properties["client.id"] = KotlinProducerConfig.clientId
        properties["bootstrap.servers"] = KotlinProducerConfig.bootstrapServers
        properties["key.serializer"] = KotlinProducerConfig.keySerializer
        properties["value.serializer"] = KotlinProducerConfig.valueSerializer
        properties["acks"] = KotlinProducerConfig.acks
        properties["partitioner.class"] = KotlinProducerConfig.partitionerClass
//        properties["enable.idempotence"] = KotlinProducerConfig.enableIdempotence
//        // properties["transactional.id"] = KotlinProducerConfig.transactionalId
        properties["client.dns.lookup"] = KotlinProducerConfig.clientDnsLookup

//        // Performance
        properties["buffer.memory"] = KotlinProducerConfig.bufferMemory
        properties["compression.type"] = KotlinProducerConfig.compressionType
        properties["retries"] = KotlinProducerConfig.retries
        properties["batch.size"] = KotlinProducerConfig.batchSize
        properties["connection.max.idle.ms"] = KotlinProducerConfig.connectionMaxIdleMs
        properties["delivery.timeout.ms"] = KotlinProducerConfig.deliveryTimeoutMs
        properties["linger.ms"] = KotlinProducerConfig.lingerMs
//        properties["max.block.ms"] = KotlinProducerConfig.maxBlockMs
//        properties["max.request.size"] = KotlinProducerConfig.maxRequestSize
//        properties["receive.buffer.bytes"] = KotlinProducerConfig.receiveBufferBytes
//        properties["request.timeout.ms"] = KotlinProducerConfig.requestTimeoutMs
//        properties["send.buffer.bytes"] = KotlinProducerConfig.sendBufferBytes
//        properties["max.in.flight.requests.per.connection"] = KotlinProducerConfig.maxInFlightRequestsPerConnection
//        properties["metadata.max.age.ms"] = KotlinProducerConfig.metadataMaxAgeMs
//        properties["transaction.timeout.ms"] = KotlinProducerConfig.transactionTimeoutMs

//        // Security
//        properties["security.protocol"] = KotlinProducerConfig.securityProtocol
//        properties["ssl.keystore.location"] = KotlinProducerConfig.sslKeystoreLocation
//        properties["sslTruststoreLocation"] = KotlinProducerConfig.sslTruststoreLocation
//        properties["ssl.keystore.password"] = KotlinProducerConfig.sslKeystorePassword
//        properties["ssl.key.password"] = KotlinProducerConfig.sslKeyPassword
//        properties["ssl.truststore.password"] = KotlinProducerConfig.sslTruststorePassword
        return KafkaProducer(properties)
    }

    private val producer: Producer<String, String> = kotlinKafkaProducer()
    private val topic = KotlinProducerConfig.topic
    fun produce() {
        val producerRecord: ProducerRecord<String, String> = ProducerRecord(topic, 0, "key", "value")
        try {
            producer.send(producerRecord)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            producer.flush()
            producer.close()
        }
    }
}

fun main() {
    val kotlinKafkaProducer = KafkaProducerClient()
    kotlinKafkaProducer.produce()
}

