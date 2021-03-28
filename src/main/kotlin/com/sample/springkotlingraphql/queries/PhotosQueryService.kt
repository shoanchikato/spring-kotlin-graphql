package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.PhotosRequestService
import org.springframework.stereotype.Component

@Component
class PhotosQueryService(
        private val photosRequestService: PhotosRequestService,
): Query {

    suspend fun photos(
            page: Int?,
            limit: Int?,
    ) = photosRequestService.requestAll(page, limit)

    suspend fun photo(
            id: Int,
    ) = photosRequestService.requestById(id)

}