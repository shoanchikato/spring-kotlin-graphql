package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.TodoDto
import com.sample.springkotlingraphql.model.Todo
import com.sample.springkotlingraphql.requests.TodosRequestService
import org.springframework.stereotype.Component

@Component
class TodosMutationService(
        private val todosRequestService: TodosRequestService,
) : Mutation {

    suspend fun createTodo(
        todo: TodoDto,
    ) = todosRequestService.create(todo = todo)

    suspend fun updateTodo(
            todo: Todo
    ) = todosRequestService.update(todo = todo)

}