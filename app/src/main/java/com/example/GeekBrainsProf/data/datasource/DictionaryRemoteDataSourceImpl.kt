package com.example.GeekBrainsProf.data.datasource

import com.example.GeekBrainsProf.data.api.DictionaryApi
import com.example.GeekBrainsProf.domain.entity.DataModel

class DictionaryRemoteDataSourceImpl(
    private val dictionaryApi: DictionaryApi
) : DictionaryRemoteDataSource {

    override suspend fun getData(word: String): List<DataModel> =
        dictionaryApi.search(word)

}
