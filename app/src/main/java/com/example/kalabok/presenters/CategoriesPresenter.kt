package com.example.kalabok.presenters

import com.example.kalabok.Contract
import com.example.kalabok.model.categoryModel.CategoryListModel
import com.example.kalabok.network.MealRetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CategoriesPresenter(var view: Contract.View<CategoryListModel>?) :
    Contract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private val client = MealRetrofitClient.mealClient
    private val call = client.getCategoriesRepo()

    override fun getRepo() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError)
        )
    }

    private fun handleSuccess(categoryModel: CategoryListModel) {
        view?.showRepo(categoryModel)
    }

    private fun handleError(t: Throwable) {
        view?.showError(t)
    }

    override fun onDestroyCalled() {
        view = null
    }
}