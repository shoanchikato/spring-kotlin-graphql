package com.sample.springkotlingraphql.requests

import com.sample.springkotlingraphql.model.User
import com.sample.springkotlingraphql.retrofit.users.RetrofitUserService
import com.sample.springkotlingraphql.retrofit.users.UserDto
import org.springframework.stereotype.Component

@Component
class UsersRequestService(
        private val retrofitUserService: RetrofitUserService
) {

    suspend fun getById(
            id: Int
    ) = retrofitUserService.retrofit.getById(id = id)

    suspend fun getAll(page: Int?, limit: Int?): List<User> {
        val qPage = page ?: 1
        val qLimit = limit ?: 20

        return retrofitUserService.retrofit.getAll(page = qPage, limit = qLimit)
    }

    suspend fun create(
            user: UserDto,
    ) = retrofitUserService.retrofit.create(user = user)

    suspend fun update(user: User) = retrofitUserService.retrofit.update(
            id = user.id,
            user = user
    )
}