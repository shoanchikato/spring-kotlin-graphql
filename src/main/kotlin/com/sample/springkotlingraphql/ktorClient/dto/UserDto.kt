package com.sample.springkotlingraphql.ktorClient.dto

import com.sample.springkotlingraphql.model.Address

data class UserDto(
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
)