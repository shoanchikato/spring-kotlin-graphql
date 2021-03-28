package com.sample.springkotlingraphql.retrofit.albums

import com.sample.springkotlingraphql.model.Album
import org.springframework.stereotype.Component
import retrofit2.http.*

@Component
interface AlbumAPI {
    companion object {
        const val PATH_URL = "albums"
    }

    @GET("/$PATH_URL")
    suspend fun getAll(
            @Query("_page") page: Int = 1,
            @Query("_limit") limit: Int = 20
    ): List<Album>

    @GET("/$PATH_URL/{id}")
    suspend fun getById(
            @Path("id") id: Int,
    ): Album

    @POST("/$PATH_URL")
    suspend fun create(
            @Body album: AlbumDto,
    ): Album

    @PUT("/$PATH_URL/{id}")
    suspend fun update(
            @Path("id") id: Int,
            @Body album: Album,
    ): Album

}