package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.PostRequestService
import org.springframework.stereotype.Component

@Component
class PostQueryService(
        private val postRequestService: PostRequestService,
): Query {

    suspend fun posts(
            page: Int?,
            limit: Int?,
    ) = postRequestService.requestAll(page, limit)

    suspend fun post(
            id: Int,
    ) = postRequestService.requestById(id)

}