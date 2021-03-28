package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.UsersRequestService
import org.springframework.stereotype.Component

@Component
class UsersQueryService(
        private val usersRequestService: UsersRequestService,
): Query {

    suspend fun users(
            page: Int?,
            limit: Int?,
    ) = usersRequestService.requestAll(page, limit)

    suspend fun user(
            id: Int,
    ) = usersRequestService.requestById(id)

}