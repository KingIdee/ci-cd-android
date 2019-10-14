package dev.idee.cicdandroid

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movieModelList: List<MovieModel>
)

data class MovieModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String
)