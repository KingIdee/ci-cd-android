package dev.idee.cicdandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val movieAdapter = MovieListAdapter(DiffUtilCallback())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {

        with(movieRecyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        viewModel.movieListLiveData.observe(this, Observer {
            progressBar.visibility = View.GONE
            movieAdapter.submitList(it)
        })

    }
}
