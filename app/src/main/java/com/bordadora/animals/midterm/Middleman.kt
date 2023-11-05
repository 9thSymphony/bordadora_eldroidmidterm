package com.bordadora.animals.midterm

import android.content.SharedPreferences
import com.bordadora.animals.midterm.model.AnimalData

class Middleman {
    companion object {
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
                putString(animalSelected, "false")
                apply()
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