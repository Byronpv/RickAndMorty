package com.example.rickandmorty.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.data.model.CharacterSerie

class CharacterAdapter(private val onCLickListener :(CharacterSerie) -> Unit) : RecyclerView.Adapter<CharacterViewHolder>() {

    private var characterList = listOf<CharacterSerie>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character_viewholder, parent, false)
        return CharacterViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position], onCLickListener)
    }

    override fun getItemCount(): Int = characterList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setCharacterList(characterList: List<CharacterSerie>) {
        this.characterList = characterList
        notifyDataSetChanged()

    }


}


