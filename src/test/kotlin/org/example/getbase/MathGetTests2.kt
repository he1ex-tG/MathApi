package org.example.getbase

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MathGetTests2(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun rootTest() {
        val entity = restTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("ello")
    }

    @Test
    fun addTest() {
        val entity = restTemplate.getForEntity<Int>("/api/math/20add10")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isEqualTo(30)
    }

    @Test
    fun subTest() {
        val entity = restTemplate.getForEntity<Int>("/api/math/20sub10")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isEqualTo(10)
    }

    @Test
    fun multTest() {
        val entity = restTemplate.getForEntity<Int>("/api/math/20mult10")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isEqualTo(200)
    }

    @Test
    fun divTest() {
        val entity = restTemplate.getForEntity<Int>("/api/math/20div10")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).isEqualTo(2)
    }
}