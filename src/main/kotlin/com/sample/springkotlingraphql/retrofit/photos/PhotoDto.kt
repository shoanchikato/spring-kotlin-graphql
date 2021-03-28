package com.sample.springkotlingraphql.retrofit.photos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoDto(

        @SerializedName("albumId")
        @Expose
        val albumId: Int,

        @SerializedName("title")
        @Expose
        val title: String,

        @SerializedName("url")
        @Expose
        val url: String,

        @SerializedName("thumbnailUrl")
        @Expose
        val thumbnailUrl: String,

        )