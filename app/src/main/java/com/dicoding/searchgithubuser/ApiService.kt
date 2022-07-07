package com.dicoding.searchgithubuser


import com.dicoding.searchgithubuser.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    @GET("search/users")
    fun getUsers(
        @Query("q") username: String
    ): Call<Search>

    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    @GET("users/{username}")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<SearchDetail>

    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String?
    ): Call<List<ItemsItem>>

    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String?
    ): Call<List<ItemsItem>>
}