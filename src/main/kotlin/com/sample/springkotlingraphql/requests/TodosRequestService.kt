package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.ktorClient.dto.TodoDto
import com.sample.springkotlingraphql.model.Todo
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component

@Component
class TodosRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "todos"
    }

    suspend fun getById(id: Int): Todo {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Todo>(url)

        return response
    }

    suspend fun getAll(page: Int?, limit: Int?): List<Todo> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Todo>>(url)

        return response
    }

    suspend fun create(
        todo: TodoDto,
    ): Todo {

        val url = "${BASE_URL}/${PATH_URL}"

        val response = ktorClientService.httpClient.post<Todo>(
            body = todo
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }

    suspend fun update(
        todo: Todo,
    ): Todo {

        val url = "${BASE_URL}/${PATH_URL}/${todo.id}"

        val response = ktorClientService.httpClient.put<Todo>(
            body = todo,
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }
}