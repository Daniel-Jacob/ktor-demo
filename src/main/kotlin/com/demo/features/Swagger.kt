package com.demo.features

import com.papsign.ktor.openapigen.OpenAPIGen
import com.papsign.ktor.openapigen.openAPIGen
import com.papsign.ktor.openapigen.schema.namer.DefaultSchemaNamer
import com.papsign.ktor.openapigen.schema.namer.SchemaNamer
import io.ktor.application.Application
import io.ktor.application.application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.get
import io.ktor.routing.routing
import java.awt.desktop.OpenFilesEvent
import kotlin.reflect.KType

fun Application.swagger() = install(OpenAPIGen) {
    info {
        version = "0.0.1"
        title = "Test API"
        description = "The Test API"
        contact {
            name = "Conspect"
            email = "daniel.jacob@conspect.nl"
        }
    }

    // describe the server, add as many as you want
    server("http://localhost:8080/") {
        description = "Test server"
    }

    replaceModule(DefaultSchemaNamer, object: SchemaNamer {
        val regex = Regex("[A-Za-z0-9_.]+")
        override fun get(type: KType): String {
            return type.toString().replace(regex) { it.value.split(".").last() }.replace(Regex(">|<|, "), "_")
        }
    })

    routing {
        get("/openapi.json") {
            call.respond(application.openAPIGen.api.serialize())
        }
        get("/") {
            call.respondRedirect("/swagger-ui/index.html?url=/openapi.json", true)
        }
    }

}