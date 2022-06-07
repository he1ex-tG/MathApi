package org.example.getbase.controllers

import org.example.getbase.annotations.ApiDescription
import org.example.getbase.annotations.CReflectionUsage
import org.example.getbase.components.CUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpUtilController(
    private val util: CUtil,
) : CReflectionUsage() {

    @GetMapping("/util")
    @ApiDescription("Root Utils URI. No actions, just print this message.")
    fun getRoot() = printByReflection()

    @GetMapping("/util/read-application-yml")
    @ApiDescription("Type application.yml \"Utils\" section.")
    fun getApplicationYml() = StringBuilder().apply {
        append("about:\n")
        append(util.about.map { "${it.key} = ${it.value}" }.joinToString(separator = "\n"))
        append("randomInt:\n")
        append("${util.randomInt}\n")
        append("randomUUID:\n")
        append("${util.randomUUID}")
        append("test:\n")
        append("${util.test}")
    }.toString()
}