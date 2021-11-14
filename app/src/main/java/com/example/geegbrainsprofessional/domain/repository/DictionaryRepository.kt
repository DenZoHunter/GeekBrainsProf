package com.example.geegbrainsprofessional.domain.repository


import androidx.lifecycle.LiveData
import com.example.geegbrainsprofessional.domain.entity.DataModel


interface DictionaryRepository {
    suspend fun getData(word: String): List<DataModel>
    fun insertAllInHistory(list: List<DataModel>)
    fun getAllHistory(): LiveData<List<DataModel>>
    fun getHistoryByText(text: String): DataModel
}