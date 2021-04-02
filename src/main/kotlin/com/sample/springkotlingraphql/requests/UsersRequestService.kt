package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.model.User
import io.ktor.client.request.get
import org.springframework.stereotype.Component

@Component
class UsersRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "users"
    }

    suspend fun requestById(id: Int): User {
        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<User>(url)

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<User> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<User>>(url)

        return response
    }
}