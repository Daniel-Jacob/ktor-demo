package com.demo.features

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.*

fun Application.contentNegotation() = install(ContentNegotiation) {
    jackson {
        enable(SerializationFeature.INDENT_OUTPUT)
    }
}