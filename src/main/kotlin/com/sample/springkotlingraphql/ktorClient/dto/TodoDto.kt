package com.sample.springkotlingraphql.ktorClient.dto

data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
)