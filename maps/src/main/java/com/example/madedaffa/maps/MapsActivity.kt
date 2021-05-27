package com.example.madedaffa.maps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madedaffa.core.data.Resource
import com.example.madedaffa.core.ui.MovieAdapter
import com.example.madedaffa.databinding.FragmentFavoriteBinding
import com.example.madedaffa.detail.DetailMovieActivity
import com.example.madedaffa.maps.databinding.ActivityMapsBinding
import com.example.madedaffa.maps.di.mapsModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: ActivityMapsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(mapsModule)



        getFavoriteData()

    }

    private fun getFavoriteData() {

        val movieAdapter = MovieAdapter()

        favoriteViewModel.favoriteMovie.observe(this, { dataTourism ->
            movieAdapter.setData(dataTourism)
            binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        movieAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }
    }

}