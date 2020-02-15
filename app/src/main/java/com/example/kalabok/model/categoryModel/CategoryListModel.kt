package com.example.kalabok.model.categoryModel

import com.google.gson.annotations.SerializedName

//List all meal categories
//https://www.themealdb.com/api/json/v1/1/categories.php
//List of Object Categories

class CategoryListModel(

    @SerializedName("categories") val categories: List<Categories>

)