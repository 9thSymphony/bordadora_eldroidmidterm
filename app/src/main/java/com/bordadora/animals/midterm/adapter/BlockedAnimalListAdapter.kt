package com.bordadora.animals.midterm.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bordadora.animals.midterm.ManageBlockActivity
import com.bordadora.animals.midterm.Middleman
import com.bordadora.animals.midterm.databinding.ItemLayoutBlockedAnimalListBinding
import com.bordadora.animals.midterm.model.AnimalData

class BlockedAnimalListAdapter(private val activity: Activity, private val blockedAnimalList: ArrayList<AnimalData>) : RecyclerView.Adapter<BlockedAnimalListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLayoutBlockedAnimalListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemLayoutBlockedAnimalListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return blockedAnimalList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.animalName.text = blockedAnimalList[position].name
        holder.binding.unblock.setOnClickListener {
            Middleman.unBlockedAnimal(blockedAnimalList[position].name.toString())
            activity.startActivity(Intent(activity, ManageBlockActivity::class.java))
            activity.finish()
        }
    }

}