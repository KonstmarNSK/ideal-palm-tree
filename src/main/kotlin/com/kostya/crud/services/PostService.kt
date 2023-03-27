package com.kostya.crud.services

import com.kostya.crud.db.PostRepository
import com.kostya.crud.db.enttites.dtoFromEntity
import com.kostya.crud.db.enttites.intoEntity
import com.kostya.crud.db.specs.BodyLike
import com.kostya.crud.db.specs.TitleLike
import com.kostya.crud.dto.PostDto
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.domain.Specification.where
import org.springframework.stereotype.Service

@Service
class PostService(val repo: PostRepository) {
    fun readAll(): List<PostDto> = repo.findAll().map { it.dtoFromEntity() }
    fun save(dto: PostDto) = repo.save(dto.intoEntity())

    fun findByContent(content: String) = repo.findAll(
        where(
            TitleLike("%${content}%")
        ).or(
            BodyLike("%${content}%")
        )
    ).map { it.dtoFromEntity() }
}