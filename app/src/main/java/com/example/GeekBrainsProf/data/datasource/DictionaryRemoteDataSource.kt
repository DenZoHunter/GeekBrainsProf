package com.example.GeekBrainsProf.data.datasource

import com.example.GeekBrainsProf.domain.entity.DataModel

interface DictionaryRemoteDataSource {

    suspend fun getData(word: String): List<DataModel>

}
