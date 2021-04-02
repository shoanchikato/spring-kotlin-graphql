package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.model.Comment
import io.ktor.client.request.get
import org.springframework.stereotype.Component


@Component
class CommentsRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "comments"
    }

    suspend fun requestById(id: Int): Comment {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Comment>(url)

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<Comment> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Comment>>(url)

        return response
    }
}