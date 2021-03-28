package com.sample.springkotlingraphql.queries

import com.expediagroup.graphql.spring.operations.Query
import com.sample.springkotlingraphql.requests.AlbumsRequestService
import org.springframework.stereotype.Component

@Component
class AlbumsQueryService(
        private val albumsRequestService: AlbumsRequestService,
): Query {

    suspend fun albums(
            page: Int?,
            limit: Int?,
    ) = albumsRequestService.requestAll(page, limit)

    suspend fun album(
            id: Int,
    ) = albumsRequestService.requestById(id)

}