package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.AlbumDto
import com.sample.springkotlingraphql.model.Album
import com.sample.springkotlingraphql.requests.AlbumsRequestService
import org.springframework.stereotype.Component

@Component
class AlbumsMutationService(
        private val albumsRequestService: AlbumsRequestService,
) : Mutation {

    suspend fun createAlbum(
        album: AlbumDto,
    ) = albumsRequestService.create(album = album)

    suspend fun updateAlbum(
            album: Album
    ) = albumsRequestService.update(album = album)

}