package com.example.kalabok

import com.example.kalabok.model.categoryModel.CategoryListModel

interface Contract {
    interface View<T> {
        fun showRepo(model: T)
        fun showError(t: Throwable)
    }

    interface Presenter {
        fun getRepo()
        fun onDestroyCalled()
    }

}