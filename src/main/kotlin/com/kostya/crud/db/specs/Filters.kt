package com.kostya.crud.db.specs

class Filter (val fieldName: String, operation: Operation)

sealed interface Operation {
    data class Like(val substring: String)
    data class TagIn(val tags: List<String>)
}