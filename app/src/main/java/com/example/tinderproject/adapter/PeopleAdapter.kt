// PeopleAdapter.kt
package com.example.tinderproject.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinderproject.PeopleViewModel.People
import com.example.tinderproject.databinding.ItemPersonBinding

class PeopleAdapter(private var peopleList: List<People>) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(peopleList[position])
    }

    class PeopleViewHolder(private val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(people: People) {
            binding.textViewName.text = people.name
            // Configura el ViewPager con el adaptador de imágenes
            val imagePagerAdapter = ImagePagerAdapter(people.images)
            binding.viewPagerImage.adapter = imagePagerAdapter
        }
    }

    fun updateData(newPeopleList: List<People>) {
        peopleList = newPeopleList
        notifyDataSetChanged() // Notifica que los datos han cambiado
    }
}
