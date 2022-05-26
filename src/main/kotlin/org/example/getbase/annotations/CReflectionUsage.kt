package org.example.getbase.annotations

import org.springframework.web.bind.annotation.GetMapping
import kotlin.reflect.full.findAnnotation

open class CReflectionUsage {
    fun printByReflection(): String {
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
}