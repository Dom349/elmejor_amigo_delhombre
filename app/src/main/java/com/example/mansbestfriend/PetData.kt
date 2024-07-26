package com.example.mansbestfriend


import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("Status")var Status:String,
    @SerializedName("message") var img: String
)
data class Breed(
    val name: String,
    val _id: Int,
    @SerializedName("imageUrl")val img: String) : List<Breed>

data class DetailsResponse(
    @SerializedName("message") val Details: Breed
)

data class SearchResponse(
    @SerializedName("message") val pets: List<Breed>
)