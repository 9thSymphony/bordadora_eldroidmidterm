package com.bordadora.animals.midterm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bordadora.animals.midterm.adapter.AnimalListAdapter
import com.bordadora.animals.midterm.databinding.ActivityAnimalNamesBinding
import com.bordadora.animals.midterm.model.AnimalData

class AnimalNamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalNamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Middleman.sharedPreferences = getSharedPreferences("animalList", Context.MODE_PRIVATE)
        binding.animalRecyclerView.layoutManager = LinearLayoutManager(this)
        val animalList = ArrayList<AnimalData>()

        if (Middleman.sharedPreferences!!.getString("Aardvark", "") == "") {
            Middleman.saveToLocal(Middleman.animalDataList)
        } else {
            Middleman.validate()
        }

        for(name in Middleman.animalNames) {
            if(Middleman.isBlocked(name) != "true") {
                animalList.add(AnimalData(name, Middleman.sharedPreferences!!.getString(name, "").toString()))
            }
        }

        binding.animalRecyclerView.adapter = AnimalListAdapter(this, animalList)

        binding.manageButton.setOnClickListener {
            startActivity(Intent(this, ManageBlockActivity::class.java))
            finish()
        }
    }
}