package org.example.getbase.controllers

import org.example.getbase.annotations.ApiDescription
import org.example.getbase.annotations.CReflectionUsage
import org.example.getbase.components.CKafka
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpMathController(
    val cKafka: CKafka
) : CReflectionUsage() {

    @GetMapping("/math")
    @ApiDescription("Root Math URI. No actions, just print this message.")
    fun getRoot() = printByReflection()

    @GetMapping("/api/math/{val1}add{val2}")
    @ApiDescription("Sum two values.")
    fun getAdd(@PathVariable val1: Int, @PathVariable val2: Int): Int {
        val res = val1 + val2
        cKafka.sendMessage("The \"add\" method has been performed. Params: $val1, $val2. Result: $res")
        return res
    }

    @GetMapping("/api/math/{val1}sub{val2}")
    @ApiDescription("Subtract second value from first.")
    fun getSubtract(@PathVariable val1: Int, @PathVariable val2: Int): Int {
        val res = val1 - val2
        cKafka.sendMessage("The \"sub\" method has been performed. Params: $val1, $val2. Result: $res")
        return res
    }

    @GetMapping("/api/math/{val1}mult{val2}")
    @ApiDescription("Multiply two values.")
    fun getMultiply(@PathVariable val1: Int, @PathVariable val2: Int): Int {
        val res = val1 * val2
        cKafka.sendMessage("The \"mult\" method has been performed. Params: $val1, $val2. Result: $res")
        return res
    }

    @GetMapping("/api/math/{val1}div{val2}")
    @ApiDescription("Divide first value by second.")
    fun getDivide(@PathVariable val1: Int, @PathVariable val2: Int): Float {
        val res = (val1 / val2).toFloat()
        cKafka.sendMessage("The \"div\" method has been performed. Params: $val1, $val2. Result: $res")
        return res
    }
}