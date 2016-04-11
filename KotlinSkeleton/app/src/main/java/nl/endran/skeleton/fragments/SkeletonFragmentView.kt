/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton.fragments

import android.view.View
import kotlinx.android.synthetic.main.fragment_skeleton.view.*
import nl.endran.skeleton.R
import nl.endran.skeleton.mvp.BaseFragmentView
import nl.endran.skeleton.showSnackBar
import nl.endran.skeleton.showToast
import javax.inject.Inject

class SkeletonFragmentView @Inject constructor() : BaseFragmentView<SkeletonFragmentPresenter.ViewModel, SkeletonFragmentPresenter>() {

    override fun getViewId() = R.layout.fragment_skeleton

    override fun prepare(rootView: View) {
        rootView.buttonToast.setOnClickListener {
            presenter?.buttonToastClicked(rootView.editTextMessage.text.toString())
        }

        rootView.buttonSnackbar.setOnClickListener {
            presenter?.buttonSnackbarClicked(rootView.editTextMessage.text.toString())
        }
    }

    override fun getViewModel() = object : SkeletonFragmentPresenter.ViewModel {

        override fun showToast(message: String) {
            rootView?.showToast(message)
        }

        override fun showSnackbar(message: String) {
            rootView?.showSnackBar(message)
        }
    }
}
