package com.kostya.crud.db.enttites

import com.kostya.crud.dto.PostDto
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
class Post (
    @Id val id: Long,
    val title: String,
    val body: String,
)


fun PostDto.intoEntity() = Post(this.id, this.title, this.body)
fun Post.dtoFromEntity() = PostDto(this.id, this.title, this.body)