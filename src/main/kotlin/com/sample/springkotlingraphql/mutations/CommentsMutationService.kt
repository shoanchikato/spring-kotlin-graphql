package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.CommentDto
import com.sample.springkotlingraphql.model.Comment
import com.sample.springkotlingraphql.requests.CommentsRequestService
import org.springframework.stereotype.Component

@Component
class CommentsMutationService(
        private val commentsRequestService: CommentsRequestService,
) : Mutation {

    suspend fun createComment(
        comment: CommentDto,
    ) = commentsRequestService.create(comment = comment)

    suspend fun updateComment(
            comment: Comment
    ) = commentsRequestService.update(comment = comment)

}