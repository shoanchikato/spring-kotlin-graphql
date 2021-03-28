package com.sample.springkotlingraphql.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Album(

        @SerializedName("userId")
        @Expose
        val userId: Int,

        @SerializedName("id")
        @Expose
        val id: Int,

        @SerializedName("title")
        @Expose
        val title: String,

)