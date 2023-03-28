package com.kostya.crud.services

import com.kostya.crud.db.TagRepository
import com.kostya.crud.db.enttites.intoDb
import com.kostya.crud.dto.TagDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TagService(val tagRepo: TagRepository) {

    @Transactional
    fun saveTag(dto: TagDto) = tagRepo.save(dto.intoDb())
}