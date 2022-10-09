package com.demirci.marvel.common

import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.demirci.marvel.databinding.ItemPagingFooterBinding
import com.demirci.marvel.util.ext.executeWithAction

class FooterViewHolder(
    private val binding: ItemPagingFooterBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnRetry.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        binding.executeWithAction {
            footerUiState = FooterUiState(loadState)
        }
    }
}