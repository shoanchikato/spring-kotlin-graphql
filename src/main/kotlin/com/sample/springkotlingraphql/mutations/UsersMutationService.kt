package com.sample.springkotlingraphql.mutations

import com.expediagroup.graphql.spring.operations.Mutation
import com.sample.springkotlingraphql.ktorClient.dto.UserDto
import com.sample.springkotlingraphql.model.User
import com.sample.springkotlingraphql.requests.UsersRequestService
import org.springframework.stereotype.Component

@Component
class UsersMutationService(
        private val usersRequestService: UsersRequestService,
) : Mutation {

    suspend fun createUser(
        user: UserDto,
    ) = usersRequestService.create(user = user)

    suspend fun updateUser(
            user: User
    ) = usersRequestService.update(user = user)

}