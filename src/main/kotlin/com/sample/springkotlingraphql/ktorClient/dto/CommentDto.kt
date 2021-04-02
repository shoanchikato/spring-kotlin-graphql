package com.sample.springkotlingraphql.ktorClient.dto

data class CommentDto(
    val postId: Int,
    val name: String,
    val email: String,
    val body: String,
)