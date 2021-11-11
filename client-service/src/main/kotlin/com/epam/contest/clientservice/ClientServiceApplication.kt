package com.epam.contest.clientservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientServiceApplication

fun main(args: Array<String>) {
    runApplication<ClientServiceApplication>(*args)
}
