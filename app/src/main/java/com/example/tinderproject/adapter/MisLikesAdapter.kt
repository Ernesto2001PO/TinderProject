package com.example.tinderproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinderproject.databinding.ItemLikesBinding
import com.example.tinderproject.PeopleViewModel.People

class MisLikesAdapter(private var likesList: List<People>) :
    RecyclerView.Adapter<MisLikesAdapter.LikesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikesViewHolder {
        val binding = ItemLikesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikesViewHolder, position: Int) {
        val person = likesList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = likesList.size


    class LikesViewHolder(private val binding: ItemLikesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: People) {
            binding.nombreLike.text = person.name
            // Inicializa el adaptador de la galería de imágenes
            val imagePagerAdapter = ImagePagerAdapter(person.images)
            binding.viewPagerImage2.adapter = imagePagerAdapter

        }
    }
    fun updateData(newlikesList: MutableList<People>) {
        likesList = newlikesList
        notifyDataSetChanged()

    }

}
