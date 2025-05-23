package com.example.rickandmorty.presentation.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.data.Resource
import com.example.rickandmorty.data.model.CharacterSerie
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.presentation.ui.adapter.CharacterAdapter
import com.example.rickandmorty.presentation.ui.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterViewModel by viewModel()

    private lateinit var adapterCharacter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        setObserves()
    }

    private fun setObserves() {
        viewModel.characterListState.observe(this) { resultList ->
            when (resultList) {
                is Resource.Success -> {
                    resultList.data.let { list -> adapterCharacter.setCharacterList(list) }
                }

                is Resource.Failure -> {
                    Toast.makeText(this, "Fallo", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Log.d("Activity", "Failed")
                }
            }
        }
        viewModel.fetchCharacterList()
    }

    private fun initRecyclerView() {
        binding.rvCharacter.layoutManager = GridLayoutManager(this, 2)
        binding.rvCharacter.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        adapterCharacter = CharacterAdapter(::onClickListener)
        binding.rvCharacter.adapter = adapterCharacter

    }

    private fun onClickListener(characterDetail: CharacterSerie) {
        val intentDetail = Intent(this, DetailCharacterActivity::class.java)
            .putExtra("Character", characterDetail)
        startActivity(intentDetail)

    }
}