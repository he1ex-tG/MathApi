package org.example.getbase.controllers

import org.example.getbase.annotations.ApiDescription
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.full.findAnnotation

@RestController
class HttpController {

    @GetMapping("/")
    @ApiDescription("Root URI. No actions, just print this message.")
    fun getRoot(): String {
        val result = mutableListOf<String>()
        val thisClass = this::class
        thisClass.members.filter { it.findAnnotation<ApiDescription>() != null }.forEach { method ->
            result.add("Method = " + method.name)
            method.findAnnotation<GetMapping>()?.let {
                result.add("Path = " + it.value.joinToString(separator = "; "))
            }
            method.findAnnotation<ApiDescription>()?.let {
                result.add("Description = " + it.description)
            }
            result.add("")
        }
        return result.joinToString(separator = '\n'.toString())
    }

    @GetMapping("/api/math/{val1}add{val2}")
    @ApiDescription("Sum two values.")
    fun getAdd(@PathVariable val1: Int, @PathVariable val2: Int) = val1 + val2
    @GetMapping("/api/math/{val1}sub{val2}")
    @ApiDescription("Subtract second value from first.")
    fun getSubtract(@PathVariable val1: Int, @PathVariable val2: Int) = val1 - val2
    @GetMapping("/api/math/{val1}mult{val2}")
    @ApiDescription("Multiply two values.")
    fun getMultiply(@PathVariable val1: Int, @PathVariable val2: Int) = val1 * val2
    @GetMapping("/api/math/{val1}div{val2}")
    @ApiDescription("Divide first value by second.")
    fun getDivide(@PathVariable val1: Int, @PathVariable val2: Int) = val1 / val2
}