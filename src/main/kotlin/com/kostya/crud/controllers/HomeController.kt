package com.kostya.crud.controllers

import com.kostya.crud.dto.PostDto
import com.kostya.crud.services.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeController (val posts: PostService) {
    @GetMapping
    fun sayHi() : String =
    """
        Hi from spring!
        Posts are: ${posts.readAll()}    
    """.trimIndent()

    @PostMapping
    fun savePost(@RequestBody dto: PostDto) = posts.save(dto)

    @GetMapping("/search")
    fun search(@RequestParam search: String) = posts.findByContent(search)
}