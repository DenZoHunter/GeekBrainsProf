package com.example.GeekBrainsProf.data.api

import com.example.GeekBrainsProf.domain.entity.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface DictionaryApi {

    @GET("/api/public/v1/words/search")
    suspend fun search(@Query("search") wordToSearch: String): List<DataModel>

}
