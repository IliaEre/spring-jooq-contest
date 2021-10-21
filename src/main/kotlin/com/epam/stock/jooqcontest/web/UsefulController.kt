package com.epam.stock.jooqcontest.web

import com.epam.stock.jooqcontest.dto.Product
import com.epam.stock.jooqcontest.service.UsefulService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class UsefulController(
    private val usefulService: UsefulService
) {

    @GetMapping
    fun getAll() = usefulService.findAll()

    @GetMapping("/{name}")
    fun findOne(@PathVariable name: String) = usefulService.findOne(name)

    @GetMapping("/{name}/description")
    fun findDescription(@PathVariable name: String) = usefulService.findOneWithDescr(name)

    @PostMapping
    fun save(@RequestBody product: Product) = usefulService.save(product)
}
