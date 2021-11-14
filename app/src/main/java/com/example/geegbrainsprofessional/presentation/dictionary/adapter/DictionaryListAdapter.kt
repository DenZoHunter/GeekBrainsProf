package com.example.geegbrainsprofessional.presentation.dictionary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.geegbrainsprofessional.R
import com.example.geegbrainsprofessional.domain.entity.DataModel
import com.example.geegbrainsprofessional.presentation.history.adapter.HistoryListDiffUtil
import com.example.geegbrainsprofessional.presentation.history.adapter.HistoryListViewHolder


class DictionaryListAdapter :
    RecyclerView.Adapter<HistoryListViewHolder>() {
    private val list: MutableList<DataModel> = mutableListOf()

    fun submitList(newList: List<DataModel>) {
        val callback =
            HistoryListDiffUtil(
                list,
                newList
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryListViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list,
            parent,
            false
        )
        return HistoryListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: HistoryListViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}