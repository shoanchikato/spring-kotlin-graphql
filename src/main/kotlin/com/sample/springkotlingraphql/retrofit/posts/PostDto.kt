package com.sample.springkotlingraphql.retrofit.posts

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostDto(

        @SerializedName("userId")
        @Expose
        val userId: Int,

        @SerializedName("title")
        @Expose
        val title: String,

        @SerializedName("body")
        @Expose
        val body: String,

        )