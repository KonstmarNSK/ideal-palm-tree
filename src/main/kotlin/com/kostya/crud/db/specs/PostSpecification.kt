package com.kostya.crud.db.specs

import com.kostya.crud.db.enttites.Post
import com.kostya.crud.db.enttites.Post_
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class TitleLike(val pattern: String) : Specification<Post> {
    override fun toPredicate(root: Root<Post>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? =
        criteriaBuilder.like(criteriaBuilder.lower(root.get(Post_.title)), pattern)
}

class BodyLike(val pattern: String) : Specification<Post> {
    override fun toPredicate(root: Root<Post>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? =
        criteriaBuilder.like(criteriaBuilder.lower(root.get(Post_.body)), pattern)
}

