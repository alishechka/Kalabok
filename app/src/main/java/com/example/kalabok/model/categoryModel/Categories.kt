package com.example.kalabok.model.categoryModel

import com.google.gson.annotations.SerializedName

//List all meal categories
//https://www.themealdb.com/api/json/v1/1/categories.php
//individual Categories from Category List

data class Categories (
    @SerializedName("idCategory") val idCategory : Int,
    @SerializedName("strCategory") val strCategory : String,
    @SerializedName("strCategoryThumb") val strCategoryThumb : String,
    @SerializedName("strCategoryDescription") val strCategoryDescription: String
)