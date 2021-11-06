package com.example.geegbrainsprofessional.data.datasource

import com.example.geegbrainsprofessional.domain.entity.DataModel

interface DictionaryDataSource {

    suspend fun getData(word: String): List<DataModel>

}