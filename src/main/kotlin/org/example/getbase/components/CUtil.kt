package org.example.getbase.components

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "util")
class CUtil() {

    /*
    It's possible to use a command-line variant to set this values, as it has higher priority than application.yml.
    E.g.: java -jar <name> --util.random-int=10
     */

    lateinit var about: Map<String, String>
    lateinit var randomInt: String
    lateinit var randomUUID: String

    constructor(
        about: Map<String, String>,
        randomInt: String,
        randomUUID: String,
    ) : this() {
        this.about = about
        this.randomInt = randomInt
        this.randomUUID = randomUUID
    }

     /*@PostConstruct
    fun getStoreConfiguration() {
        symbols.forEach {
            println("${it.key} - ${it.value}")
        }
    }*/
}