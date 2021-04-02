package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.PostsRequestService
import org.springframework.stereotype.Component

@Component
class PostQueryService(
        private val postsRequestService: PostsRequestService,
) : Query {

    suspend fun posts(
            page: Int?,
            limit: Int?,
    ) = postsRequestService.getAll(page, limit)

    suspend fun post(
            id: Int,
    ) = postsRequestService.getById(id)

}