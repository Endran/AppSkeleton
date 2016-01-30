package nl.endran.skeleton.kotlin.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragmentView<VM, P : BaseFragmentPresenter<VM>> {

    protected var rootView: View? = null
    protected var presenter: P? = null

    open fun inflate(inflater: LayoutInflater, container: ViewGroup, @SuppressWarnings("unused") savedInstanceState: Bundle?): View {
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
    protected abstract fun getViewId(): Int

    protected abstract fun getViewModel(): VM

    protected abstract fun prepare(rootView: View);
}
