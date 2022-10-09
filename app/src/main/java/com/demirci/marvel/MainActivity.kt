package com.demirci.marvel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.demirci.marvel.common.FooterAdapter
import com.demirci.marvel.databinding.ActivityMainBinding

import com.demirci.marvel.ui.character_list.CharacterAdapter
import com.demirci.marvel.ui.character_list.CharacterItemUiState
import com.demirci.marvel.ui.character_list.CharactersUiState
import com.demirci.marvel.ui.character_list.CharactersViewModel

import com.demirci.marvel.util.ext.collect
import com.demirci.marvel.util.ext.collectLast
import com.demirci.marvel.util.ext.executeWithAction
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: CharactersViewModel by viewModels()

    @Inject
    lateinit var characterListAdapter: CharacterAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setBinding()

        setListener()

        setAdapter()

        collectLast(viewModel.characterItemsUiStates, ::setUsers)

    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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