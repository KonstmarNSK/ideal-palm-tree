package com.kostya.crud.services

import com.kostya.crud.db.PostRepository
import com.kostya.crud.db.enttites.dtoFromEntity
import com.kostya.crud.db.enttites.intoEntity
import com.kostya.crud.dto.PostDto
import org.springframework.stereotype.Service

@Service
class PostService(val repo: PostRepository){
    fun readAll() : List<PostDto> = repo.findAll().map { it.dtoFromEntity() }
    fun save(dto: PostDto) = repo.save(dto.intoEntity())
}