package com.example.rickandmorty.presenter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.model.CharacterModel
import com.example.rickandmorty.model.Resource
import com.example.rickandmorty.presenter.recyclerView.CharacterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels(
        factoryProducer = { MainViewModelFacotry() }
    )

    lateinit var adapterCharacter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()
        setObserves()


    }

    private fun setObserves() {
        viewModel.getCharacterApiVM.observe(this, Observer { resultList ->
            when (resultList) {
                is Resource.Success -> {
                    resultList.data?.let { list -> adapterCharacter.setCharacterList(list) }
                }
                is Resource.Failure -> {
                    Toast.makeText(this, "Fallo", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Log.d("Activity", "Failed")
                }
            }
        })
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


    private fun onClickListener(characterDetail: CharacterModel) {
        val intentDetail =
            Intent(this, DetailCharacterActivity::class.java)
                .putExtra("Character", characterDetail)
        startActivity(intentDetail)

    }
}