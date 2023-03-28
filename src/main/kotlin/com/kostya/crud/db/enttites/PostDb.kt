package com.kostya.crud.db.enttites

import com.kostya.crud.dto.PostDto
import jakarta.persistence.*

@Entity
@Table(name = "posts")
class PostDb (
    @Id val id: Long,
    val title: String,
    val body: String,

    @ManyToMany(cascade = [
        CascadeType.PERSIST,
        CascadeType.MERGE
    ])
    @JoinTable(
        name = "post_tag",
        joinColumns = [JoinColumn(name = "post_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    val tags: List<TagDb>,
)

fun PostDto.intoEntity(tags: List<TagDb>) = PostDb(this.id, this.title, this.body, tags)
fun PostDb.dtoFromEntity() = PostDto(this.id, this.title, this.body, tags.map { it.id })