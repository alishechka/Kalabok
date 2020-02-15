package com.example.kalabok.model.mealModel

import com.google.gson.annotations.SerializedName

//List all meals related to chosen category
//https://www.themealdb.com/api/json/v1/1/filter.php?c="place category here from Categories Model"
//individual members of List MEAL

class Meals (
    @SerializedName("strMeal") val strMeal : String,

    @SerializedName("strMealThumb") val strMealThumb : String,

    @SerializedName("idMeal") val idMeal : Int
    )


