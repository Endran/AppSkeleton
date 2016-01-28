package nl.endran.skeleton.kotlin.fragments

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragmentView<VM, P : BaseFragmentPresenter<VM>> {

    var presenter: P? = null

    fun inflate(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(getViewId(), container, false)
    }

    fun deflate() {
    }

    fun start(presenter: P) {
        this.presenter = presenter

        val viewModel = getViewModel()
        presenter.start(viewModel)
    }

    fun stop() {
        presenter?.stop()
        presenter = null
    }


    @LayoutRes
    abstract fun getViewId(): Int

    abstract fun getViewModel(): VM
}
