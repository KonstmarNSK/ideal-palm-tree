package com.kostya.crud.services

import com.kostya.crud.db.TagRepository
import com.kostya.crud.db.enttites.intoDb
import com.kostya.crud.dto.TagDto
import org.springframework.stereotype.Service

@Service
class TagService(val tagRepo: TagRepository) {
    fun saveTag(dto: TagDto) = tagRepo.save(dto.intoDb())
}