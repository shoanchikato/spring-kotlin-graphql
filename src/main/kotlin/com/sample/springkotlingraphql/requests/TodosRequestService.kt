package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import org.springframework.stereotype.Component

@Component
class TodosRequestService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PATH_URL = "todos"
    }

    suspend fun requestById(id: Int): Post {

        val httpClient = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer() {
                    setPrettyPrinting()
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
}