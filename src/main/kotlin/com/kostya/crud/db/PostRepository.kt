package com.kostya.crud.db

import com.kostya.crud.db.enttites.Post
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Long>, JpaSpecificationExecutor<Post>