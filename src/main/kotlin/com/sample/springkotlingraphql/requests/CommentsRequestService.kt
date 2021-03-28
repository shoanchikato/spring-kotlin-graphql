package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.Comment
import com.sample.springkotlingraphql.retrofit.comments.CommentDto
import com.sample.springkotlingraphql.retrofit.comments.RetrofitCommentService
import org.springframework.stereotype.Component


@Component
class CommentsRequestService(
        private val retrofitCommentService: RetrofitCommentService
) {

    suspend fun getById(
            id: Int
    ) = retrofitCommentService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<Comment> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitCommentService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            comment: CommentDto,
    ) = retrofitCommentService.retrofit.create(comment = comment)

    suspend fun update(comment: Comment) = retrofitCommentService.retrofit.update(
            id = comment.id,
            comment = comment
    )
}