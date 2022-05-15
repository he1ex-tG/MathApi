package org.example.getbase

import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class MathGetTests(@Autowired val mockMvc: MockMvc) {

    @Test
    fun rootTest() {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(content().string(Matchers.containsString("Hello Wor")))
    }

    @Test
    fun sumTest() {
        mockMvc.perform(get("/api/math/20add10"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("val1").value(20))
    }

    @Test
    fun subTest() {
        mockMvc.perform(get("/api/math/20sub10"))
            .andExpect(status().isOk)
            .andExpect(content().string("10"))
    }

    @Test
    fun multTest() {
        mockMvc.perform(get("/api/math/20mult10"))
            .andExpect(status().isOk)
            .andExpect(content().string("200"))
    }

    @Test
    fun divTest() {
        mockMvc.perform(get("/api/math/20div10"))
            .andExpect(status().isOk)
            .andExpect(content().string("2"))
    }
}