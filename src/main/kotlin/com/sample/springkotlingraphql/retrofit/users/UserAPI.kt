package com.sample.springkotlingraphql.retrofit.users

import com.sample.springkotlingraphql.model.User
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface UserAPI {
    companion object {
        const val PATH_URL = "users"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<User>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): User

    @POST("/$PATH_URL")
    suspend fun create(
            @Body user: UserDto,
    ): User

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body user: User,
    ): User

}