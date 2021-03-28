package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Album
import com.sample.springkotlingraphql.retrofit.albums.AlbumDto
import com.sample.springkotlingraphql.retrofit.albums.RetrofitAlbumService
import org.springframework.stereotype.Component

@Component
class AlbumsRequestService(
        private val retrofitAlbumService: RetrofitAlbumService
) {

    suspend fun getById(
            id: Int
    ) = retrofitAlbumService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<Album> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitAlbumService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            album: AlbumDto,
    ) = retrofitAlbumService.retrofit.create(album = album)

    suspend fun update(album: Album) = retrofitAlbumService.retrofit.update(
            id = album.id,
            album = album
    )
}