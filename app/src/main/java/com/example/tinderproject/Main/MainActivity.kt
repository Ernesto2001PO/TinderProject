package com.example.tinderproject.Main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tinderproject.databinding.ActivityMainBinding
import com.example.tinderproject.fragments.MisLikesFragment
import com.example.tinderproject.fragments.PeopleFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLike.setOnClickListener {
            handleLike(true)
        }
        binding.btnDislike.setOnClickListener {
            handleLike(false)
        }


        // Configurar el botón para navegar a LikesFragment
        binding.btnMisLikes.setOnClickListener {
            val likesFragment = MisLikesFragment()
            likesFragment.show(supportFragmentManager, "LikesDialogFragment")
        }

    }

    private fun handleLike(like: Boolean) {
        val fragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as PeopleFragment // Agrega el fragmento a la actividad
        fragment.MisLike(like)
    }


}