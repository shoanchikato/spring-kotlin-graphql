package com.sample.springkotlingraphql.retrofit.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sample.springkotlingraphql.model.Address

data class UserDto(

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("username")
        @Expose
        val username: String,

        @SerializedName("email")
        @Expose
        val email: String,

        @SerializedName("address")
        @Expose
        val address: Address,

        )