package com.demirci.marvel.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demirci.marvel.R
import com.demirci.marvel.domain.model.CharacterModel

class CharacterListAdapter(private val context : Context, var itemList : ArrayList<CharacterModel>) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

        inner class CharacterListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val characterName = view.findViewById<TextView>(R.id.tv_character_name)
            val thumbnail = view.findViewById<ImageView>(R.id.iv_character)
            val card = view.findViewById<LinearLayout>(R.id.linear_layout_characters)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val list = itemList[position]
        holder.characterName.text = list.name
        val imageUrl = "${list.thumbnail?.replace("http", "https")}/portrait_xlarge.${list.thumbnailExtension}"
        Glide.with(context).load(imageUrl).into(holder.thumbnail)
        holder.card.setOnClickListener {
            Toast.makeText(context, "Clicked character "+ "${list.thumbnail?.replace("http", "https")}/portrait_xlarge.${list.thumbnailExtension}", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setCharacterData(characterModelList : ArrayList<CharacterModel>) {
        this.itemList.addAll(characterModelList)
        notifyDataSetChanged()
    }


}