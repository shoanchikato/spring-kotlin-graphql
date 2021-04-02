package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.ktorClient.dto.CommentDto
import com.sample.springkotlingraphql.model.Comment
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component


@Component
class CommentsRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "comments"
    }

    suspend fun getById(id: Int): Comment {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Comment>(url)

        return response
    }

    suspend fun getAll(page: Int?, limit: Int?): List<Comment> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Comment>>(url)

        return response
    }

    suspend fun create(
        comment: CommentDto,
    ): Comment {

        val url = "${BASE_URL}/${PATH_URL}"

        val response = ktorClientService.httpClient.post<Comment>(
            body = comment
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }

    suspend fun update(
        comment: Comment,
    ): Comment {

        val url = "${BASE_URL}/${PATH_URL}/${comment.id}"

        val response = ktorClientService.httpClient.put<Comment>(
            body = comment,
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }
}