package com.bordadora.animals.midterm.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bordadora.animals.midterm.AnimalDetailActivity
import com.bordadora.animals.midterm.constants.Constants
import com.bordadora.animals.midterm.databinding.ItemsLayoutAnimalListBinding
import com.bordadora.animals.midterm.model.AnimalData

class AnimalListAdapter(private val activity: Activity, private val animalList: ArrayList<AnimalData>) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemsLayoutAnimalListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsLayoutAnimalListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.animalName.text = animalList[position].name
        holder.binding.animalListLayout.setOnClickListener {
            val intent = Intent(activity, AnimalDetailActivity::class.java)
            intent.putExtra(Constants.PARAM_NAME, animalList[position].name)
            intent.putExtra(Constants.PARAM_DETAIL, animalList[position].details)
            activity.startActivity(intent)
        }
    }

}