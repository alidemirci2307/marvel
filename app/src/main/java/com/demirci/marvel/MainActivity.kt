package com.demirci.marvel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.demirci.marvel.databinding.ActivityMainBinding
import com.demirci.marvel.domain.model.CharacterModel
import com.demirci.marvel.ui.character_list.CharacterAdapter
import com.demirci.marvel.ui.character_list.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<CharactersViewModel>()

    var list = arrayListOf<CharacterModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        binding.apply {
            viewmodel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }

        setContentView(binding.root)

        binding.adapter = CharacterAdapter(listOf(), viewModel)
    }
}