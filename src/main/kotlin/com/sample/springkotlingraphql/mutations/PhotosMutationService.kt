package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.PhotoDto
import com.sample.springkotlingraphql.model.Photo
import com.sample.springkotlingraphql.requests.PhotosRequestService
import org.springframework.stereotype.Component

@Component
class PhotosMutationService(
        private val photosRequestService: PhotosRequestService,
) : Mutation {

    suspend fun createPhoto(
        photo: PhotoDto,
    ) = photosRequestService.create(photo = photo)

    suspend fun updatePhoto(
            photo: Photo
    ) = photosRequestService.update(photo = photo)

}