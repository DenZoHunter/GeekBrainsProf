package com.example.geegbrainsprofessional.domain.repository

import com.example.geegbrainsprofessional.domain.entity.DataModel

interface DictionaryRepository {

    suspend fun getData(word: String): List<DataModel>

}