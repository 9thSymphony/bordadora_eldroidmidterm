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

        val animalDataList = arrayListOf(
            AnimalData("Aardvark", "Aardvarks are burrowing mammals native to Africa, known for their long snouts."),
            AnimalData("Bison", "Bisons are large, herbivorous mammals native to North America."),
            AnimalData("Cougar", "Cougars are also known as mountain lions and are large wild cats."),
            AnimalData("Duck", "Ducks are waterfowl known for their webbed feet."),
            AnimalData("Eagle", "Eagles are large birds of prey with keen eyesight."),
            AnimalData("Frog", "Frogs are amphibians known for their jumping ability."),
            AnimalData("Gorilla", "Gorillas are large primates known for their strength and intelligence."),
            AnimalData("Hawk", "Hawks are birds of prey with sharp beaks and talons."),
            AnimalData("Ibis", "Ibises are long-legged wading birds."),
            AnimalData("Jellyfish", "Jellyfish are marine animals with gelatinous bodies."),
            AnimalData("Koala", "Koalas are marsupials known for their eucalyptus leaf diet."),
            AnimalData("Lemur", "Lemurs are small, arboreal primates native to Madagascar."),
            AnimalData("Moose", "Moose are large herbivorous mammals with antlers."),
            AnimalData("Narwhal", "Narwhals are whales with long, spiral tusks."),
            AnimalData("Ocelot", "Ocelots are small wild cats with distinctive spotted coats."),
            AnimalData("Puma", "Pumas are also known as cougars and are large wild cats."),
            AnimalData("Quail", "Quails are small birds often hunted for sport."),
            AnimalData("Raccoon", "Raccoons are medium-sized mammals with distinctive facial markings."),
            AnimalData("Seagull", "Seagulls are common coastal birds."),
            AnimalData("Toucan", "Toucans are colorful, beak-wielding birds found in tropical regions."),
            AnimalData("Umbrellabird", "Umbrellabirds are black birds with a distinctive crest."),
            AnimalData("Vulture", "Vultures are scavenging birds known for their bald heads."),
            AnimalData("Wombat", "Wombats are burrowing marsupials found in Australia."),
            AnimalData("X-ray Tetra", "X-ray Tetras are small fish with transparent bodies."),
            AnimalData("Yak", "Yaks are domesticated bovids native to the Himalayas."),
            AnimalData("Zorilla", "Zorillas are small, carnivorous mammals also known as striped polecats.")
        )

        if (Middleman.sharedPreferences!!.getString("Aardvark", "") == "") {
            Middleman.saveToLocal(animalDataList)
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