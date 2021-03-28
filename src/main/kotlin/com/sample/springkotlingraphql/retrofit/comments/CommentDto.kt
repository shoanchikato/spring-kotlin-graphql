package com.sample.springkotlingraphql.retrofit.comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommentDto(
        @SerializedName("postId")
        @Expose
        val postId: Int,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("email")
        @Expose
        val email: String,

        @SerializedName("body")
        @Expose
        val body: String,

)