package com.sample.springkotlingraphql.retrofit.posts

import com.sample.springkotlingraphql.model.Post
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface PostAPI {
    companion object {
        const val PATH_URL = "posts"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<Post>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): Post

    @POST("/$PATH_URL")
    suspend fun create(
            @Body post: PostDto,
    ): Post

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body post: Post,
    ): Post

}