package dev.idee.cicdandroid

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MainActivityViewModel : ViewModel() {

    val movieListLiveData = MutableLiveData<List<MovieModel>>()

    init {
        fetchMovies()
    }


    private fun fetchMovies() {

        APIClient.client.create(ApiInterface::class.java).getPopularMovies(BuildConfig.API_KEY)
            .enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e("MainActivityViewModel", t.toString())
                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                    Log.d("MainActivityViewModel","${response.code()}")

                    response.body()?.let {
                        Log.d("MainActivityViewModel","$it")
                        movieListLiveData.postValue(it.movieModelList)
                    }

                }

            })

    }

}