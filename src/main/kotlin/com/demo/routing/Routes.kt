package com.demo.routing

import com.demo.routing.types.MyLocation
import com.demo.routing.types.Type
import com.demo.service.EmployeeService
import com.papsign.ktor.openapigen.openAPIGen
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject

fun Application.routes() {
        val employeeService: EmployeeService by inject()
        routing {

            get<MyLocation> {
                call.respondText("Location: name=${it.name}, arg1=${it.arg1}, arg2=${it.arg2}")
            }
            // Register nested routes
            get<Type.Edit> {
                call.respondText("Inside $it")
            }
            get<Type.List> {
                call.respondText("Inside $it")
            }
        }
    }