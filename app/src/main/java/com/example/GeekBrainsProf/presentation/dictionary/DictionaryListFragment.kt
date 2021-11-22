package com.example.GeekBrainsProf.presentation.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RestrictTo
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.GeekBrainsProf.R
import com.example.GeekBrainsProf.databinding.FragmentDictionaryListBinding
import com.example.GeekBrainsProf.domain.entity.AppState
import com.example.GeekBrainsProf.domain.entity.DataModel
import com.example.GeekBrainsProf.presentation.dictionary.adapter.DictionaryListAdapter
import com.example.GeekBrainsProf.presentation.utils.viewById
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinScopeComponent

class DictionaryListFragment :
    Fragment(R.layout.fragment_dictionary_list), KoinScopeComponent {

    override val scope: RestrictTo.Scope by fragmentScope()

    private val viewModel: DictionaryListViewModel by viewModel()

    private var _binding: FragmentDictionaryListBinding? = null

    private val binding get() = _binding!!

    private val dictionaryListAdapter = DictionaryListAdapter()

    private var nav: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDictionaryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nav = Navigation.findNavController(view)

        binding.dictionaryList.layoutManager = LinearLayoutManager(requireContext())
        binding.dictionaryList.adapter = dictionaryListAdapter

        viewModel.liveData.observe(viewLifecycleOwner, ::renderData)

        binding.searchBar.setEndIconOnClickListener {
            val text: String? = binding.searchBar.editText?.text?.toString()
            text?.let { word -> viewModel.getData(word) }
        }

        val navToHistory by viewById<Button>(R.id.navToHistory)

        navToHistory.setOnClickListener {
            nav?.navigate(R.id.historyListFragment)
        }

    }

    private fun renderData(appState: AppState<List<DataModel>>) {
        when (appState) {
            is AppState.Success -> {
                dictionaryListAdapter.submitList(appState.data)
            }
            else -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}