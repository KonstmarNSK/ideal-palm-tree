package com.kostya.crud.db.specs

import com.kostya.crud.db.enttites.PostDb
import com.kostya.crud.db.enttites.PostDb_
import jakarta.persistence.criteria.*
import org.springframework.data.jpa.domain.Specification

class TitleLike(val pattern: String) : Specification<PostDb> {
    override fun toPredicate(root: Root<PostDb>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? =
        criteriaBuilder.like(criteriaBuilder.lower(root.get(PostDb_.title)), pattern)
}

class BodyLike(val pattern: String) : Specification<PostDb> {
    override fun toPredicate(root: Root<PostDb>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? =
        criteriaBuilder.like(criteriaBuilder.lower(root.get(PostDb_.body)), pattern)
}

class FetchTags : Specification<PostDb> {
    override fun toPredicate(
        root: Root<PostDb>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {
        root.fetch(PostDb_.tags, JoinType.LEFT)

        return null
    }
}
