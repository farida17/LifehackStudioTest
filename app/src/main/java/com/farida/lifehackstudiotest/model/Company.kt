package com.farida.lifehackstudiotest.model

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val image: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("www")
    val www: String?,
    @SerializedName("phone")
    val phone: String?
)
