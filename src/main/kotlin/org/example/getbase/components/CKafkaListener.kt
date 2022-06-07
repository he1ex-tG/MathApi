package org.example.getbase.components

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CKafkaListener {

    @KafkaListener(topics = ["Test"])
    fun processTestMessages(msg: String) {
        println(msg)
    }
}