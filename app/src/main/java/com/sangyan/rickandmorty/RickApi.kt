package com.sangyan.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface RickApi  {

    @GET("character")
    fun getDetails() : Call<RickMorty>
}