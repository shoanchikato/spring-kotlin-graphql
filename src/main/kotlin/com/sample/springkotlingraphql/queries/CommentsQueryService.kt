package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.CommentsRequestService
import org.springframework.stereotype.Component

@Component
class CommentsQueryService(
        private val commentsRequestService: CommentsRequestService,
): Query {

    suspend fun comments(
            page: Int?,
            limit: Int?,
    ) = commentsRequestService.getAll(page, limit)

    suspend fun comment(
            id: Int,
    ) = commentsRequestService.getById(id)

}