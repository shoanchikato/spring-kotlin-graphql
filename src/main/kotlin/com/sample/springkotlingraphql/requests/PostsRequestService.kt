package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.springframework.stereotype.Component


@Component
class PostsRequestService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "posts"
    }

    suspend fun requestById(id: Int): Post {

        val httpClient = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
//                disableHtmlEscaping()
                }
            }
        }

        val url = "$BASE_URL/$PATH_URL/$id"
        val response = httpClient.get<Post>(url)

        httpClient.close()

        return response
    }

    suspend fun requestAll(page: Int?, limit: Int?): List<Post> {

        val httpClient = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
//                disableHtmlEscaping()
                }
            }
        }

        val qPage = page ?: 1
        val qLimit = limit ?: 20
        val url = "$BASE_URL/$PATH_URL?_page=$qPage&_limit=$qLimit"

        val response = httpClient.get<List<Post>>(url)

        httpClient.close()

        return response
    }

    suspend fun create(
            title: String,
            body: String,
            userId: Int,
    ): Post {

        val httpClient = HttpClient {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = GsonSerializer {
                    setPrettyPrinting()
                    disableHtmlEscaping()
                }
            }
        }

        val url = "$BASE_URL/$PATH_URL"

//        val json = io.ktor.client.features.json.defaultSerializer()
        val response = httpClient.post<Post>(
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