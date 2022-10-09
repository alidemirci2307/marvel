package com.demirci.marvel.ui.character_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.demirci.marvel.R
import com.demirci.marvel.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    lateinit var binding: FragmentCharacterDetailsBinding

    private val viewModel: CharacterDetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterDetailsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.characterDetailsViewModel = viewModel

    }



}