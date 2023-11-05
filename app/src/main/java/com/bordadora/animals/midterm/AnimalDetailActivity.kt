package com.bordadora.animals.midterm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bordadora.animals.midterm.constants.Constants
import com.bordadora.animals.midterm.databinding.ActivityAnimalDetailBinding

class AnimalDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            finish()
            startActivity(Intent(this@AnimalDetailActivity, AnimalNamesActivity::class.java))}

        binding.animalName.text = intent.getStringExtra(Constants.PARAM_NAME)
        binding.nameDetail.text  = intent.getStringExtra(Constants.PARAM_DETAIL)

        binding.block.setOnClickListener {
            Middleman.blockedAnimal(intent.getStringExtra(Constants.PARAM_NAME).toString())
            finish()
            startActivity(Intent(this@AnimalDetailActivity, AnimalNamesActivity::class.java))
        }
    }
}