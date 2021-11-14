package com.example.geegbrainsprofessional.data.datasource

import com.example.geegbrainsprofessional.domain.entity.DataModel

interface DictionaryRemoteDataSource {

    suspend fun getData(word: String): List<DataModel>

}