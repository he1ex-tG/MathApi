package org.example.getbase.components

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CKafka(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(msg: String) {
        kafkaTemplate.send("Test", msg)
    }
}