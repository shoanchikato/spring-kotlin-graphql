package com.sample.springkotlingraphql.retrofit.albums

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumDto(

        @SerializedName("userId")
        @Expose
        val userId: Int,

        @SerializedName("title")
        @Expose
        val title: String,

        )