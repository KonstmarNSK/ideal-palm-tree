package com.kostya.crud.db.enttites

import com.kostya.crud.dto.TagDto
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tags")
class TagDb(@Id val id: Long, val name: String)

fun TagDb.intoDto() = TagDto(this.id, this.name)
fun TagDto.intoDb() = TagDb(this.id, this.name)