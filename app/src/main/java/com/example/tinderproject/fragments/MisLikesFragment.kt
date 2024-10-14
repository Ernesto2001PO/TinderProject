package com.example.tinderproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinderproject.PeopleViewModel.People
import com.example.tinderproject.PeopleViewModel.PeopleViewModel
import com.example.tinderproject.adapter.MisLikesAdapter
import com.example.tinderproject.databinding.FragmentLikesBinding

class MisLikesFragment : DialogFragment() {

    private lateinit var binding: FragmentLikesBinding

    // Usa el ViewModel compartido
    private val mainViewModel: PeopleViewModel by activityViewModels()
    private lateinit var mislikesadapter: MisLikesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLikesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        // Inicializa el adaptador con una lista vacía
        mislikesadapter = MisLikesAdapter(emptyList())
        binding.recyclerViewLikes.apply {
            adapter = mislikesadapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeData() {
        // Observa los cambios en la lista de personas del ViewModel
        mainViewModel.likesList.observe(viewLifecycleOwner) { likesList ->
            if (likesList.isNotEmpty()) {
                showLikedPeople(likesList)
            }
        }
    }

    private fun showLikedPeople(likesList: MutableList<People>?) {
        val likedlist = likesList ?: return
        mislikesadapter.updateData(likedlist)

    }

    // Sobrescribimos el método onStart para ajustar el tamaño del DialogFragment
    override fun onStart() {
        super.onStart()

        // Ocupa el ancho y alto completos de la pantalla
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }


}
