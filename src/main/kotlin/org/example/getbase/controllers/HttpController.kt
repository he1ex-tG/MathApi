package org.example.getbase.controllers

import org.example.getbase.models.IMathValues
import org.example.getbase.objects.CMathValues
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpController {

    @GetMapping("/")
    fun getRoot() = "Hello World!"

    @GetMapping("/api/add/{val1}+{val2}")
    fun getAdd(@PathVariable val1: Int, @PathVariable val2: Int) = val1 + val2
    @GetMapping("/api/subtract/{val1}-{val2}")
    fun getSubtract(@PathVariable val1: Int, @PathVariable val2: Int) = val1 - val2
    @GetMapping("/api/multiply/{val1}-{val2}")
    fun getMultiply(@PathVariable val1: Int, @PathVariable val2: Int) = val1 * val2
    @GetMapping("/api/divide/{val1}-{val2}")
    fun getDivide(@PathVariable val1: Int, @PathVariable val2: Int) = val1 / val2
}