package nl.endran.skeleton.kotlin.fragments

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragmentView<VM, P : BaseFragmentPresenter<VM>> {

    var rootView: View? = null
    var presenter: P? = null

    fun inflate(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        rootView = inflater.inflate(getViewId(), container, false)
        return rootView!!
    }

    fun androidViewReady() {
        if (rootView != null) {
            prepare(rootView!!)
        }
    }

    fun deflate() {
        rootView = null
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

    abstract fun prepare(rootView: View);
}
