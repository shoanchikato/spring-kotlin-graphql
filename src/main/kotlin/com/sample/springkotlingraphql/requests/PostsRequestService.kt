package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Post
import com.sample.springkotlingraphql.retrofit.posts.PostDto
import com.sample.springkotlingraphql.retrofit.posts.RetrofitPostService
import org.springframework.stereotype.Component


@Component
class PostsRequestService(
        private val retrofitPostService: RetrofitPostService
) {

    suspend fun getById(
            id: Int
    ) = retrofitPostService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<Post> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitPostService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            post: PostDto,
    ) = retrofitPostService.retrofit.create(post = post)

    suspend fun update(
            post: Post,
    ) = retrofitPostService.retrofit.update(
            id = post.id,
            post = post,
    )
}