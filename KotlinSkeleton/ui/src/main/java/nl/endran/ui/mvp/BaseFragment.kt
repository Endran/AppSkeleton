/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.ui.mvp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nl.endran.skeleton.injections.getUiComponent
import nl.endran.ui.UiApplication
import nl.endran.ui.injections.UiComponent

abstract class BaseFragment<VM, P : BaseFragmentPresenter<VM>, V : BaseFragmentView<VM, P>> : Fragment() {

    var view: V? = null
    var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val context = inflater!!.context
        val applicationContext = context.applicationContext
        val uiApplication = applicationContext as UiApplication
        val uiComponent = uiApplication.uiComponent
        view = createView(uiComponent)
        return view!!.inflate(inflater, container!!, savedInstanceState)
    }

    override fun onViewCreated(androidView: View?, savedInstanceState: Bundle?) {
        view?.androidViewReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        view?.deflate()
        view = null
    }

    override fun onResume() {
        super.onResume()
        if (view != null) {
            presenter = createPresenter(context.getUiComponent())
            view?.start(presenter!!)
        }
    }

    override fun onPause() {
        super.onPause()
        view?.stop()
        presenter = null
    }

    abstract fun createView(uiComponent: UiComponent): V
    abstract fun createPresenter(uiComponent: UiComponent): P
}
