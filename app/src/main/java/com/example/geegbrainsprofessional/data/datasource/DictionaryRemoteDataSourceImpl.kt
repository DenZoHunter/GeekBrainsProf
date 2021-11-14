package com.example.geegbrainsprofessional.data.datasource

import com.example.geegbrainsprofessional.data.api.DictionaryApi
import com.example.geegbrainsprofessional.domain.entity.DataModel

class DictionaryRemoteDataSourceImpl(
    private val dictionaryApi: DictionaryApi
) : DictionaryRemoteDataSource {

    override suspend fun getData(word: String): List<DataModel> =
        dictionaryApi.search(word)

}