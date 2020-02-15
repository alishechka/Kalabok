package com.example.kalabok.network

import com.example.kalabok.END_POINT_CATEGORIES
import com.example.kalabok.END_POINT_MEALS
import com.example.kalabok.model.categoryModel.CategoryListModel
import com.example.kalabok.model.mealModel.MealListModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MealClient {

    @GET(END_POINT_CATEGORIES)
    fun getCategoriesRepo(): Observable<CategoryListModel>

    //query comes from Categories variable "strCategory" which is a String
    //..."c = lamb"
    @GET(END_POINT_MEALS)
    fun getMealsRepo(@Query("c") category: String): Observable<MealListModel>
}