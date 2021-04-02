package com.sample.springkotlingraphql.ktorClient.dto

class PostDto(
    val userId: Int,
    val id: Int? = null,
    val title: String,
    val body: String,
)