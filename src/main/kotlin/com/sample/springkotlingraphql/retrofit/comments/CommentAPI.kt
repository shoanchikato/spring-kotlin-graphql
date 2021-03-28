package com.sample.springkotlingraphql.retrofit.comments

import com.sample.springkotlingraphql.model.Comment
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface CommentAPI {
    companion object {
        const val PATH_URL = "comments"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<Comment>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): Comment

    @POST("/$PATH_URL")
    suspend fun create(
            @Body comment: CommentDto,
    ): Comment

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body comment: Comment,
    ): Comment

}