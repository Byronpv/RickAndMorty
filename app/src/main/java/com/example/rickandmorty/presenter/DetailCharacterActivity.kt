package com.example.rickandmorty.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.databinding.ActivityDetailCharacterBinding
import com.example.rickandmorty.data.model.CharacterModel
import com.squareup.picasso.Picasso

class DetailCharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var character: CharacterModel? = null

        character = intent.getSerializableExtra("Character") as CharacterModel

        with(binding) {
            txtName.text = character.name
            Picasso.get().load(character.image).into(imgCharacterDetail)
            txtStatusDescription.text = character.status
            txtSpeciesDescription.text = character.species
            txtGenderDescription.text = character.gender
        }

    }
}