package com.example.kalabok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kalabok.adapters.MealsAdapter
import com.example.kalabok.model.mealModel.MealListModel
import com.example.kalabok.presenters.MealsPresenter
import kotlinx.android.synthetic.main.activity_meal.*

class ActivityMeal : AppCompatActivity(), Contract.View<MealListModel> {
    private lateinit var presenter: MealsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)
        val ss = intent.getStringExtra(CAT_KEY_MEW)
        presenter = MealsPresenter(this,ss!!)
        presenter.getRepo()
    }

    override fun showRepo(model: MealListModel) {
        rv_display_meal.adapter = MealsAdapter(model)
        rv_display_meal.layoutManager = GridLayoutManager(this, 2)
    }

    override fun showError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()

    }

    override fun onDestroy() {
        presenter.onDestroyCalled()
        super.onDestroy()
    }


}
