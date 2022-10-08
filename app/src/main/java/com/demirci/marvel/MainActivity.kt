package com.demirci.marvel

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demirci.marvel.databinding.ActivityMainBinding
import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.ui.character_list.CharactersViewModel
import com.demirci.marvel.util.CharacterListAdapter
import com.demirci.marvel.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel: CharactersViewModel by viewModels()

    var repeatValue = 3

    var paginatedValue = 0


    private lateinit var adapter: CharacterListAdapter

    private lateinit var layoutManager: GridLayoutManager

    var list = arrayListOf<CharacterModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        layoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.apply {

            getRecyclerViewCharacters()
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.itemCount - 1) {
                        paginatedValue += Constants.limit.toInt()
                        viewModel.getAllCharacters(paginatedValue)
                        callApi()
                    }
                }
            })

        }

    }

    private fun callApi() {
        CoroutineScope(Dispatchers.Main).launch {
            repeat(repeatValue) {
                viewModel._marvelValue.collect {
                    when {
                        it.isLoading -> {
                            binding.progressAction.visibility = View.VISIBLE
                        }

                        it.error.isNotBlank() -> {
                            binding.progressAction.visibility = View.GONE
                            repeatValue = 0
                            Toast.makeText(this@MainActivity, it.error, Toast.LENGTH_LONG)
                        }

                        it.characterModelList.isNotEmpty() -> {
                            binding.progressAction.visibility = View.GONE
                            repeatValue = 0
                            adapter.setCharacterData(it.characterModelList as ArrayList<CharacterModel>)
                        }
                    }
                    delay(1000)
                }

            }
        }
    }

    private fun getRecyclerViewCharacters() {
        adapter = CharacterListAdapter(this@MainActivity, ArrayList())
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllCharacters(paginatedValue)
        callApi()
    }
}