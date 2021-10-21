package com.epam.stock.jooqcontest

import com.epam.jooq.Tables
import com.epam.jooq.tables.Product
import com.epam.stock.jooqcontest.repo.UsefulRepository
import org.jooq.DSLContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class JooqContestApplication

fun main(args: Array<String>) {
    runApplication<JooqContestApplication>(*args)
}
