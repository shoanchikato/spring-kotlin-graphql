package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.model.Todo
import io.ktor.client.request.get
import org.springframework.stereotype.Component

@Component
class TodosRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "todos"
    }

    suspend fun requestById(id: Int): Todo {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Todo>(url)

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<Todo> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Todo>>(url)

        return response
    }
}