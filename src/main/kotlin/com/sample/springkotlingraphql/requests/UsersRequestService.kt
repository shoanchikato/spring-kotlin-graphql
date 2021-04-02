package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.ktorClient.dto.UserDto
import com.sample.springkotlingraphql.model.User
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component

@Component
class UsersRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "users"
    }

    suspend fun getById(id: Int): User {
        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<User>(url)

        return response
    }

    suspend fun getAll(page: Int?, limit: Int?): List<User> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<User>>(url)

        return response
    }

    suspend fun create(
        user: UserDto,
    ): User {

        val url = "${BASE_URL}/${PATH_URL}"

        val response = ktorClientService.httpClient.post<User>(
            body = user
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }

    suspend fun update(
        user: User,
    ): User {

        val url = "${BASE_URL}/${PATH_URL}/${user.id}"

        val response = ktorClientService.httpClient.put<User>(
            body = user,
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }
}