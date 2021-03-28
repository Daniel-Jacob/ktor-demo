package com.demo.features

import com.demo.ioc.employeeModule
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.core.Koin
fun Application.dependencyResolver() =
    install(org.koin.ktor.ext.Koin) {
        modules(employeeModule)
    }
