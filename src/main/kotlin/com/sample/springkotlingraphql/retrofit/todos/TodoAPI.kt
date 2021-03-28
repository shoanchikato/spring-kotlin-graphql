package com.sample.springkotlingraphql.retrofit.todos

import com.sample.springkotlingraphql.model.Todo
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface TodoAPI {
    companion object {
        const val PATH_URL = "todos"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<Todo>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): Todo

    @POST("/$PATH_URL")
    suspend fun create(
            @Body todo: TodoDto,
    ): Todo

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body todo: Todo,
    ): Todo

}