package com.demo

import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.auth.jwt.*
import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.demo.features.authentication
import com.demo.features.contentNegotation
import com.demo.features.dependencyResolver
import com.demo.features.locations
import com.demo.features.logging
import com.demo.features.swagger
import com.demo.ioc.employeeModule
import com.demo.routing.routes
import com.papsign.ktor.openapigen.OpenAPIGen
import io.ktor.locations.*
import io.ktor.serialization.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.Koin.Feature

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

/**
 * Please note that you can use any other name instead of *module*.
 * Also note that you can have more then one modules in your application.
 * */
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    swagger()
    dependencyResolver()
    locations()
    routes()
    logging()
    authentication()
    contentNegotation()
}
