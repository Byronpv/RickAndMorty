package com.example.rickandmorty.presenter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemCharacterViewholderBinding
import com.example.rickandmorty.data.model.CharacterSerie
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterViewholderBinding.bind(view)

    fun bind(characterSerie: CharacterSerie, onClickListener: (CharacterSerie) -> Unit) {
        with(binding) {
            Picasso.get().load(characterSerie.imageUrl).into(imgCharacter)
            txtCharacter.text = characterSerie.name
        }

        itemView.setOnClickListener { onClickListener(characterSerie) }
    }

}