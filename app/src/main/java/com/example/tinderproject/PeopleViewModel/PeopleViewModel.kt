package com.example.tinderproject.PeopleViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tinderproject.R

class PeopleViewModel : ViewModel() {


    private val _peopleList = MutableLiveData<List<People>>() // mutable live data
    val peopleList: LiveData<List<People>> get() = _peopleList // live data

    private val _likesList = MutableLiveData<MutableList<People>>(mutableListOf())
    val likesList: LiveData<MutableList<People>> get() = _likesList


    init {
        val people = mutableListOf<People>()

        val shakiraImages = listOf (R.drawable.shakira1, R.drawable.shakira2, R.drawable.shakira3)
        people.add(People("Shakira", shakiraImages))


        val rihannaImages = listOf(R.drawable.rihanna1, R.drawable.rihanna2, R.drawable.rihanna3)
        people.add(People("Rihanna", rihannaImages))


        val beyonceImages = listOf(R.drawable.beyonce1, R.drawable.beyonce2, R.drawable.beyonce3)
        people.add(People("Beyonce", beyonceImages))


        val arianaImages = listOf(R.drawable.ariana1, R.drawable.ariana2, R.drawable.ariana3)
        people.add(People("Ariana", arianaImages))

        val taylorImages = listOf(R.drawable.taylor1, R.drawable.taylor2, R.drawable.taylor3)
        people.add(People("Taylor", taylorImages))

        val selenaImages = listOf(R.drawable.selena1, R.drawable.selena2, R.drawable.selena3)
        people.add(People("Selena", selenaImages))


        val duaImages = listOf(R.drawable.dua1, R.drawable.dua2, R.drawable.dua3)
        people.add(People("Dua", duaImages))

        val karolImages = listOf(R.drawable.karol1, R.drawable.karol2, R.drawable.karol3)
        people.add(People("Karol", karolImages))


        val  nicoleImages = listOf(R.drawable.nicole1, R.drawable.nicole2, R.drawable.nicole3)
        people.add(People("Nicole", nicoleImages))

        _peopleList.value = people


    }
    // Agrega una persona a la lista de likes
    fun addToLikes(person: People) {
        _likesList.value?.add(person)
    }


}