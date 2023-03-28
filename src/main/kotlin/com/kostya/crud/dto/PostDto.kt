package com.kostya.crud.dto

data class PostDto (
    val id: Long,
    val title: String,
    val body: String,
    val tagsIds: List<Long>,
)