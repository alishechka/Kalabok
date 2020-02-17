package com.example.kalabok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kalabok.adapters.CategoriesAdapter
import com.example.kalabok.model.categoryModel.CategoryListModel
import com.example.kalabok.presenters.CategoriesPresenter
import kotlinx.android.synthetic.main.activity_main.*

class ActivityCategory : AppCompatActivity(), Contract.View<CategoryListModel>, OnItemClick {


    private lateinit var presenter: CategoriesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CategoriesPresenter(this)
        presenter.getRepo()
    }

    override fun showRepo(model: CategoryListModel) {
        rv_display_category.adapter = CategoriesAdapter(model, this)
        rv_display_category.layoutManager = LinearLayoutManager(parent)
    }

    override fun showError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        presenter.onDestroyCalled()
        super.onDestroy()
    }

    override fun onClick(strCategory: String) {
        val intent = Intent(this, ActivityMeal::class.java)
        intent.putExtra(CAT_KEY_MEW, strCategory)
        startActivity(intent)

    }
}
