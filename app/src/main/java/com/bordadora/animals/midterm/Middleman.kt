package com.bordadora.animals.midterm

import android.content.SharedPreferences
import com.bordadora.animals.midterm.model.AnimalData

class Middleman {
    companion object {
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
            AnimalData("Zorilla", "Zorillas are small, carnivorous mammals also known as striped polecats."))
        val animalNames = arrayListOf("Aardvark", "Bison", "Cougar", "Duck", "Eagle", "Frog", "Gorilla", "Hawk", "Ibis", "Jellyfish", "Koala", "Lemur", "Moose", "Narwhal", "Ocelot", "Puma", "Quail", "Raccoon", "Seagull", "Toucan", "Umbrellabird", "Vulture", "Wombat", "X-ray Tetra", "Yak", "Zorilla")
        var sharedPreferences: SharedPreferences? = null

        fun isBlocked(name: String): String{
            return sharedPreferences!!.getString(name, "false").toString()
        }

        fun blockedAnimal(animalSelected: String) {
            with(sharedPreferences!!.edit()) {
                putString(animalSelected, "true")
                apply()
            }
        }

        fun unBlockedAnimal(animalSelected: String) {
            with(sharedPreferences!!.edit()) {
                for(animal in animalDataList) {
                    if (animal.name == animalSelected) {
                        putString(animal.name, animal.details)
                        apply()
                    }
                }
            }
        }

        fun saveToLocal(animalList: ArrayList<AnimalData>) {
            with(sharedPreferences!!.edit()) {
                for(animal in animalList) {
                    putString(animal.name, animal.details)
                }
                apply()
            }
        }

        fun validate() {
            with(sharedPreferences!!.edit()) {
                putString("hasLocal", "Current system has local")
                apply()
            }
        }
    }
}