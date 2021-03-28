package com.sample.springkotlingraphql.retrofit.users

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Component
class RetrofitUserService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    val retrofit: UserAPI = retrofit()

    private fun gsonBuilder(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    private fun retrofitBuilder(gson:  Gson): Retrofit.Builder {
        val format = DateTimeFormatter.ISO_ZONED_DATE_TIME
        val date = ZonedDateTime.now().format(format)

        val logger = HttpLoggingInterceptor { println("$date Retrofit API: $it") }
        logger.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
    }

    private fun retrofitPostAPIBuilder(retrofit: Retrofit.Builder): UserAPI {
        return retrofit
                .build()
                .create(UserAPI::class.java)
    }

    private fun retrofit(): UserAPI {
        val gson = gsonBuilder()
        val retrofitBuilder = retrofitBuilder(gson = gson)
        return retrofitPostAPIBuilder(retrofit = retrofitBuilder)
    }

}


