package com.kostya.crud.db

import com.kostya.crud.db.enttites.TagDb
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface TagRepository : JpaRepository<TagDb, Long>