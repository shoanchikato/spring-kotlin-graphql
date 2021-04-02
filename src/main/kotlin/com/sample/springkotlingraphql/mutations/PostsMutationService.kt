package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.PostDto
import com.sample.springkotlingraphql.model.Post
import com.sample.springkotlingraphql.requests.PostsRequestService
import org.springframework.stereotype.Component

@Component
class PostsMutationService(
        private val postsRequestService: PostsRequestService,
) : Mutation {

    suspend fun createPost(
        post: PostDto,
    ) = postsRequestService.create(post = post)

    suspend fun updatePost(
            post: Post
    ) = postsRequestService.update(post = post)

}