package com.example.kalabok.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kalabok.R
import com.example.kalabok.model.mealModel.MealListModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meals_item.view.*

class MealsAdapter(private val models: MealListModel) :
    RecyclerView.Adapter<MealsAdapter.mealsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mealsViewHolder {
        return mealsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.meals_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return models.meals.size
    }

    override fun onBindViewHolder(holder: mealsViewHolder, position: Int) {
        val picasso = Picasso.get()
        val imageURL = models.meals[position].strMealThumb

        picasso.load(imageURL).into(holder.image)
        holder.name.text = models.meals[position].strMeal

    }


    class mealsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_meal_item
        val image = itemView.iv_meal_item
    }


}