package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Photo
import com.sample.springkotlingraphql.retrofit.photos.PhotoDto
import com.sample.springkotlingraphql.retrofit.photos.RetrofitPhotoService
import org.springframework.stereotype.Component

@Component
class PhotosRequestService(
        private val retrofitPhotoService: RetrofitPhotoService
) {

    suspend fun getById(
            id: Int
    ) = retrofitPhotoService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<Photo> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitPhotoService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            photo: PhotoDto,
    ) = retrofitPhotoService.retrofit.create(photo = photo)

    suspend fun update(photo: Photo) = retrofitPhotoService.retrofit.update(
            id = photo.id,
            photo = photo
    )
}