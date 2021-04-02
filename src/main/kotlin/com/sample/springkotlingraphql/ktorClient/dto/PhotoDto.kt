package com.sample.springkotlingraphql.ktorClient.dto

data class PhotoDto(
val albumId: Int,
val id: Int,
val title: String,
val url: String,
val thumbnailUrl: String,
)