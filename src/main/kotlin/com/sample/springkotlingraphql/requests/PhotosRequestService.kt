package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.model.Photo
import io.ktor.client.request.get
import org.springframework.stereotype.Component

@Component
class PhotosRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "photos"
    }

    suspend fun requestById(id: Int): Photo {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Photo>(url)

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<Photo> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Photo>>(url)

        return response
    }
}