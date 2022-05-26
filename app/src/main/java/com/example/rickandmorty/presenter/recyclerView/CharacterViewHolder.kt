package com.example.rickandmorty.presenter.recyclerView

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemCharacterViewholderBinding
import com.example.rickandmorty.model.CharacterModel
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterViewholderBinding.bind(view)

    fun bind(characterModel: CharacterModel, onClickListener: (CharacterModel) -> Unit) {
        with(binding) {
            Picasso.get().load(characterModel.image).into(imgCharacter)
            txtCharacter.text = characterModel.name
        }

        itemView.setOnClickListener { onClickListener(characterModel) }
    }

}