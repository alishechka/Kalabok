package com.example.kalabok.model.mealModel

import com.google.gson.annotations.SerializedName

//List all meals related to chosen category
//https://www.themealdb.com/api/json/v1/1/filter.php?c="place category here from Categories Model"
//List of Object Meals


class MealListModel(
    @SerializedName("meals") val meals: List<Meals>


)