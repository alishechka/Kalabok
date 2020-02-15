package com.example.kalabok.presenters

import android.content.Intent
import com.example.kalabok.CAT_KEY_MEW
import com.example.kalabok.Contract
import com.example.kalabok.model.mealModel.MealListModel
import com.example.kalabok.network.MealRetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MealsPresenter(
    var view: Contract.View<MealListModel>?,
    var strCategory: String
) : Contract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private val client = MealRetrofitClient.mealClient
    private val call = client.getMealsRepo(strCategory)
    private val intent = Intent()

    override fun getRepo() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError)
        )

    }

    private fun handleSuccess(mealModel: MealListModel) {
        view?.showRepo(mealModel)
    }

    private fun handleError(t: Throwable) {
        view?.showError(t)
    }

    override fun onDestroyCalled() {
        view = null
    }
}