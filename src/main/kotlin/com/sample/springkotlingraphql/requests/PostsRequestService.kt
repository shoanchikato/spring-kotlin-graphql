package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.model.Post
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component


@Component
class PostsRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "posts"
    }

    suspend fun requestById(id: Int): Post {
        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Post>(url)

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<Post> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Post>>(url)

        return response
    }

    suspend fun create(
            title: String,
            body: String,
            userId: Int,
    ): Post {

        val url = "$BASE_URL/$PATH_URL"

        val response = ktorClientService.httpClient.post<Post>(
                body = Post(userId = userId, body = body, title = title)
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        println("body: ${Post(userId = userId, body = body, title = title, id =3)}")
        println("create: $response")

        return response
    }
}