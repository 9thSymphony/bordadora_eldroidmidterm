package com.bordadora.animals.midterm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bordadora.animals.midterm.adapter.BlockedAnimalListAdapter
import com.bordadora.animals.midterm.databinding.ActivityManageBlockBinding
import com.bordadora.animals.midterm.model.AnimalData

class ManageBlockActivity : AppCompatActivity() {

    private lateinit var binding: ActivityManageBlockBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Middleman.sharedPreferences = getSharedPreferences("animalList", Context.MODE_PRIVATE)
        binding.blockedAnimalRecyclerView.layoutManager = LinearLayoutManager(this)
        val animalList = ArrayList<AnimalData>()

        for(name in Middleman.animalNames) {
            if(Middleman.isBlocked(name) == "true") {
                animalList.add(AnimalData(name, Middleman.sharedPreferences!!.getString(name, "").toString()))
            }
        }

        binding.blockedAnimalRecyclerView.adapter = BlockedAnimalListAdapter(this, animalList)

        binding.backButton.setOnClickListener {
            startActivity(Intent(this, AnimalNamesActivity::class.java))
            finish()
        }

    }
}