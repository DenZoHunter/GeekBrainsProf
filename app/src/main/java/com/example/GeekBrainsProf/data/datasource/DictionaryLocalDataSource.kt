package com.example.GeekBrainsProf.data.datasource

import androidx.lifecycle.LiveData
import com.example.database.table.DefinitionModel

interface DictionaryLocalDataSource {
    fun insertAllDefinitionModel(list: List<DefinitionModel>)
    fun getAll(): LiveData<List<DefinitionModel>>
    fun getByText(text: String): DefinitionModel
}
