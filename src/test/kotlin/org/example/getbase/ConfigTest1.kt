package org.example.getbase

import org.assertj.core.api.Assertions.assertThat
import org.example.getbase.components.CUtil
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.core.env.get

@SpringBootTest(args = ["--util.test=two"])
class ConfigTest1 {

    @Test
    fun testArg(@Autowired args: ApplicationArguments) {
        assertThat(args.optionNames).containsOnly("util.test")
        assertThat(args.getOptionValues("util.test")).containsOnly("two")
    }

    @Test
    fun testArg2(@Autowired args: CUtil) {
        assertThat(args.test).isEqualTo("two")
    }

    @Test
    fun testArg3(@Autowired args: ApplicationContext) {
        assertThat(args.environment["util.test"]).isEqualTo("two")
    }
}