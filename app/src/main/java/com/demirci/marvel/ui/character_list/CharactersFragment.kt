package com.demirci.marvel.ui.character_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.demirci.marvel.R
import com.demirci.marvel.common.FooterAdapter
import com.demirci.marvel.databinding.FragmentCharactersBinding
import com.demirci.marvel.util.ext.collect
import com.demirci.marvel.util.ext.collectLast
import com.demirci.marvel.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {


    lateinit var binding: FragmentCharactersBinding

    private val viewModel: CharactersViewModel by viewModels()

    @Inject
    lateinit var characterListAdapter: CharacterAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharactersBinding.bind(view)
        setListener()
        setAdapter()
        collectLast(viewModel.characterItemsUiStates, ::setUsers)
    }


    private fun setListener() {
        binding.btnRetry.setOnClickListener { characterListAdapter.retry() }
    }

    private fun setAdapter() {
        collect(flow = characterListAdapter.loadStateFlow
            .distinctUntilChangedBy { it.source.refresh }
            .map { it.refresh },
            action = ::setCharactersUiState
        )
        binding.rvUsers.adapter = characterListAdapter.withLoadStateFooter(FooterAdapter(characterListAdapter::retry))
    }

    private fun setCharactersUiState(loadState: LoadState) {
        binding.executeWithAction {
            charactersUiState = CharactersUiState(loadState)
        }
    }

    private suspend fun setUsers(userItemsPagingData: PagingData<CharacterItemUiState>) {
        characterListAdapter.submitData(userItemsPagingData)
    }


}