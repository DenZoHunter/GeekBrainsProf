package com.example.GeekBrainsProf.presentation.dictionary.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.GeekBrainsProf.R
import com.example.GeekBrainsProf.domain.entity.DataModel

class DictionaryListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var word: TextView = itemView.findViewById(R.id.word)
    private var description: TextView = itemView.findViewById(R.id.description)

    fun bind(dataModel: DataModel) {
        word.text = dataModel.text
        description.text = dataModel
            .meanings
            ?.mapNotNull { it.translation?.translation }
            ?.joinToString(", ")
    }
}
