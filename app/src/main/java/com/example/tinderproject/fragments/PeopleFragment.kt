// MainFragment.kt
package com.example.tinderproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinderproject.PeopleViewModel.People
import com.example.tinderproject.PeopleViewModel.PeopleViewModel
import com.example.tinderproject.adapter.PeopleAdapter
import com.example.tinderproject.databinding.PeopleFragmentBinding

class PeopleFragment : Fragment() {

    private lateinit var binding: PeopleFragmentBinding

    // Usa el ViewModel compartido
    private val mainViewModel: PeopleViewModel by activityViewModels()
    private lateinit var peopleAdapter: PeopleAdapter


    private var currentPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PeopleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeData()

    }

    private fun setupRecyclerView() {
        // Inicializa el adaptador con una lista vacía
        peopleAdapter = PeopleAdapter(emptyList())
        binding.recyclerViewPersonas.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

     private fun observeData() {
        // Observa los cambios en la lista de personas del ViewModel
        mainViewModel.peopleList.observe(viewLifecycleOwner) { peopleList ->
            if (peopleList.isNotEmpty()) {
                // Muestra la primera persona
                showCurrentPerson(peopleList)
            }
        }
    }

    private fun showCurrentPerson(peopleList: List<People>) {
        if (currentPosition < peopleList.size) {
            // Actualiza el adaptador para mostrar solo la persona en la posición actual
            peopleAdapter.updateData(listOf(peopleList[currentPosition]))
        } else {
            // Si no hay más personas, muestra un mensaje
            binding.recyclerViewPersonas.visibility = View.GONE
            binding.textViewNoMorePeople.visibility = View.VISIBLE
        }
    }


    fun MisLike(isLike: Boolean) {
        val peopleList = mainViewModel.peopleList.value ?: return
        if (currentPosition < peopleList.size) {
            val currentPerson = peopleList[currentPosition]
            if (isLike) {
                mainViewModel.addToLikes(currentPerson)
            }
            currentPosition++
            if (currentPosition < peopleList.size) {
                // Actualiza el adaptador para mostrar la siguiente persona
                peopleAdapter.updateData(listOf(peopleList[currentPosition]))
            } else {
                binding.recyclerViewPersonas.visibility = View.GONE
                binding.textViewNoMorePeople.visibility = View.VISIBLE

            }
        }
    }


}
