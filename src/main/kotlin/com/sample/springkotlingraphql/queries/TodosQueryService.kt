package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.TodosRequestService
import org.springframework.stereotype.Component

@Component
class TodosQueryService(
        private val todosRequestService: TodosRequestService,
): Query {

    suspend fun todos(
            page: Int?,
            limit: Int?,
    ) = todosRequestService.getAll(page, limit)

    suspend fun todo(
            id: Int,
    ) = todosRequestService.getById(id)

}