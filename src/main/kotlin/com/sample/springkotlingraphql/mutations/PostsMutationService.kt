package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.requests.PostsRequestService
import org.springframework.stereotype.Component

@Component
class PostsMutationService(
        private val postsRequestService: PostsRequestService,
) : Mutation {

    suspend fun createPost(
            title: String,
            body: String,
            userId: Int,
    ) = postsRequestService.create(title, body, userId)

}