package com.kostya.crud.db

import com.kostya.crud.db.enttites.PostDb
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<PostDb, Long>, JpaSpecificationExecutor<PostDb> {
    @Query("SELECT post FROM PostDb post " +
            "LEFT JOIN FETCH post.tags tags")
    fun fetchAll() : List<PostDb>
}