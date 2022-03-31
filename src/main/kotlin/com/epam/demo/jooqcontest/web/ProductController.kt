package com.epam.demo.jooqcontest.web

import com.epam.demo.jooqcontest.dto.ProductDto
import com.epam.demo.jooqcontest.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
@RequestMapping("/v1/product")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAll() = productService.findAll().toResponse()

    @GetMapping("/{name}")
    fun findOne(@PathVariable name: String) = productService.findOne(name).toResponse()

    @GetMapping("/{name}/description")
    fun findDescription(@PathVariable name: String) = productService.findDescription(name).toResponse()

    @PostMapping
    fun save(@RequestBody productDto: ProductDto) = productService.save(productDto)

    private fun Any?.toResponse() = this?.let { ResponseEntity.ok(this) } ?: ResponseEntity.notFound()

}
