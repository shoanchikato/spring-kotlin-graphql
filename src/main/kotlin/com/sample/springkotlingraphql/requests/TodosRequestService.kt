package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Todo
import com.sample.springkotlingraphql.retrofit.todos.RetrofitTodoService
import com.sample.springkotlingraphql.retrofit.todos.TodoDto
import org.springframework.stereotype.Component

@Component
class TodosRequestService(
        private val retrofitTodoService: RetrofitTodoService
) {

    suspend fun getById(
            id: Int
    ) = retrofitTodoService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<Todo> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitTodoService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            todo: TodoDto,
    ) = retrofitTodoService.retrofit.create(todo = todo)

    suspend fun update(todo: Todo) = retrofitTodoService.retrofit.update(
            id = todo.id,
            todo = todo
    )
}