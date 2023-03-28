package com.kostya.crud.services

import com.kostya.crud.db.PostRepository
import com.kostya.crud.db.TagRepository
import com.kostya.crud.db.enttites.dtoFromEntity
import com.kostya.crud.db.enttites.intoEntity
import com.kostya.crud.db.specs.BodyLike
import com.kostya.crud.db.specs.TitleLike
import com.kostya.crud.dto.PostDto
import org.springframework.data.jpa.domain.Specification.where
import org.springframework.stereotype.Service

@Service
class PostService(val postsRepo: PostRepository, val tagsRepo: TagRepository) {

    fun readAll(): List<PostDto> = postsRepo.fetchAll().map { it.dtoFromEntity() }

    fun save(dto: PostDto) {
        val tagsIds = dto.tagsIds.map { tagsRepo.getReferenceById(it) }
        postsRepo.save(dto.intoEntity(tagsIds))
    }

    fun findByContent(content: String) = postsRepo.findAll(
        where(
            TitleLike("%${content}%")
        ).or(
            BodyLike("%${content}%")
        )
    ).map { it.dtoFromEntity() }
}