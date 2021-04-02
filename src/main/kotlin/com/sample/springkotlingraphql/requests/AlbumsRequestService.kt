package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.ktorClient.KtorClientService
import com.sample.springkotlingraphql.ktorClient.dto.AlbumDto
import com.sample.springkotlingraphql.model.Album
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component

@Component
class AlbumsRequestService(val ktorClientService : KtorClientService) {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "albums"
    }

    suspend fun getById(id: Int): Album {

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = ktorClientService.httpClient.get<Album>(url)

        return response
    }

    suspend fun getAll(page: Int?, limit: Int?): List<Album> {

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = ktorClientService.httpClient.get<List<Album>>(url)

        return response
    }

    suspend fun create(
        album: AlbumDto,
    ): Album {

        val url = "${BASE_URL}/${PATH_URL}"

        val response = ktorClientService.httpClient.post<Album>(
            body = album
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }

    suspend fun update(
        album: Album,
    ): Album {

        val url = "${BASE_URL}/${PATH_URL}/${album.id}"

        val response = ktorClientService.httpClient.put<Album>(
            body = album,
        ) {
            url(url)
            contentType(ContentType.Application.Json)
        }

        return response
    }
}