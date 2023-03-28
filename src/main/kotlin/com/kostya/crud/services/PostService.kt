package com.kostya.crud.services

import com.kostya.crud.db.PostRepository
import com.kostya.crud.db.TagRepository
import com.kostya.crud.db.enttites.dtoFromEntity
import com.kostya.crud.db.enttites.intoEntity
import com.kostya.crud.db.specs.BodyLike
import com.kostya.crud.db.specs.FetchTags
import com.kostya.crud.db.specs.TitleLike
import com.kostya.crud.dto.PostDto
import jakarta.transaction.Transactional
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification.where
import org.springframework.stereotype.Service

@Service
class PostService(val postsRepo: PostRepository, val tagsRepo: TagRepository) {

    fun readAll(page: Pageable): List<PostDto> = postsRepo.fetchAll(page).map { it.dtoFromEntity() }

    fun findByContent(content: String) = postsRepo.findAll(
        where(
            TitleLike("%${content}%")
        ).or(
            BodyLike("%${content}%")
        ).and(FetchTags())
    ).map { it.dtoFromEntity() }


    @Transactional
    fun save(dto: PostDto) {
        val tagsIds = dto.tagsIds.map { tagsRepo.getReferenceById(it) }
        postsRepo.save(dto.intoEntity(tagsIds))
    }

    @Transactional
    fun delete(id: Long) = postsRepo.deleteById(id)
}