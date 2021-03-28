package com.sample.springkotlingraphql.retrofit.photos

import com.sample.springkotlingraphql.model.Photo
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface PhotoAPI {
    companion object {
        const val PATH_URL = "photos"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<Photo>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): Photo

    @POST("/$PATH_URL")
    suspend fun create(
            @Body photo: PhotoDto,
    ): Photo

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body photo: Photo,
    ): Photo

}