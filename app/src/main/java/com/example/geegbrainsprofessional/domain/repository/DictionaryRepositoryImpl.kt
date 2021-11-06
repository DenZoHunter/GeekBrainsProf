package com.example.geegbrainsprofessional.domain.repository

import com.example.geegbrainsprofessional.data.datasource.DictionaryDataSource
import com.example.geegbrainsprofessional.domain.entity.DataModel

class DictionaryRepositoryImpl(
    private val dictionaryDataSource: DictionaryDataSource
) : DictionaryRepository {

    override suspend fun getData(word: String): List<DataModel> =
        dictionaryDataSource.getData(word)

}