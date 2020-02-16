package com.example.kalabok.adapters

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kalabok.R
import com.example.kalabok.model.categoryModel.CategoryListModel
import com.example.kalabok.OnItemClick
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.categories_item.view.*

class CategoriesAdapter(
    private val models: CategoryListModel,
    private val onClickListener: OnItemClick
) :
    RecyclerView.Adapter<CategoriesAdapter.categoriesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): categoriesViewHolder {
        return categoriesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.categories_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return models.categories.size

    }

    override fun onBindViewHolder(holder: categoriesViewHolder, position: Int) {
        holder.name.text = models.categories[position].strCategory
        holder.description.text = models.categories[position].strCategoryDescription

        val picasso = Picasso.get()
        val thumbURL = models.categories[position].strCategoryThumb
        picasso.load(thumbURL).into(holder.thumb)

        //for scrolling
        holder.description.movementMethod=(ScrollingMovementMethod())

        val strCat = models.categories[position].strCategory
        holder.bind(strCat, onClickListener)

    }

    class categoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tv_cat_name
        val description = itemView.tv_cat_description
        val thumb = itemView.iv_cat_thumb


        fun bind(strCat: String, onClickListener: OnItemClick) {
            itemView.setOnClickListener { onClickListener.onClick(strCat) }
        }
    }
}