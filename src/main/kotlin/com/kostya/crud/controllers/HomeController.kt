package com.kostya.crud.controllers

import com.kostya.crud.dto.PostDto
import com.kostya.crud.dto.TagDto
import com.kostya.crud.services.PostService
import com.kostya.crud.services.TagService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeController (val posts: PostService, val tags: TagService) {
    @GetMapping
    fun sayHi(page: Pageable) : String =
    """
        Hi from spring!
        Posts are: ${posts.readAll(page)}    
    """.trimIndent()

    @PostMapping
    fun savePost(@RequestBody dto: PostDto) = posts.save(dto)

    @DeleteMapping
    fun deletePost(@RequestParam postId: Long) = posts.delete(postId)

    @PostMapping("/tag")
    fun saveTag(@RequestBody tag: TagDto) = tags.saveTag(tag)

    @GetMapping("/search")
    fun search(@RequestParam search: String) = posts.findByContent(search)
}