package org.example.getbase.components

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

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
    lateinit var test: String

    constructor(
        about: Map<String, String>,
        randomInt: String,
        randomUUID: String,
        test: String,
    ) : this() {
        this.about = about
        this.randomInt = randomInt
        this.randomUUID = randomUUID
        this.test = test
    }

    /*@PostConstruct
    fun getStoreConfiguration() {
        println(test)
    }*/
}