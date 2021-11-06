package com.example.geegbrainsprofessional.data.datasource

import com.example.geegbrainsprofessional.domain.entity.DataModel
import com.example.geegbrainsprofessional.data.api.DictionaryApi

class DictionaryDataSourceImpl(
    private val dictionaryApi: DictionaryApi
) : DictionaryDataSource {

    override suspend fun getData(word: String): List<DataModel> =
        dictionaryApi.search(word)

}