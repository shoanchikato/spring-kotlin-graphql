package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.ktorClient.dto.PhotoDto
import com.sample.springkotlingraphql.model.Photo
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component

@Component
class PhotosRequestService(val ktorClientService: KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "photos"
    }

    suspend fun getById(id: Int): Photo {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Photo>(url)

        return response
    }

    suspend fun getAll(page: Int?, limit: Int?): List<Photo> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Photo>>(url)

        return response
    }

    suspend fun create(
        photo: PhotoDto,
    ): Photo {

        val url = "${BASE_URL}/${PATH_URL}"

        val response = ktorClientService.httpClient.post<Photo>(
            body = photo
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }

    suspend fun update(
        photo: Photo,
    ): Photo {

        val url = "${BASE_URL}/${PATH_URL}/${photo.id}"

        val response = ktorClientService.httpClient.put<Photo>(
            body = photo,
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }
}