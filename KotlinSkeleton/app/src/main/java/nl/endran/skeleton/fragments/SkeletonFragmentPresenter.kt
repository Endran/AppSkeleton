/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton.fragments

import nl.endran.core.InstanceReporter
import nl.endran.core.ModelInteractor
import nl.endran.core.injections.ModelModule
import nl.endran.skeleton.mvp.BaseFragmentPresenter
import javax.inject.Inject
import javax.inject.Named

class SkeletonFragmentPresenter @Inject constructor(
        val instanceReporter : InstanceReporter,
        @Named(ModelModule.MODEL_INTERACTOR_A) val toastInteractor: ModelInteractor,
        @Named(ModelModule.MODEL_INTERACTOR_B) val snackbarInteractor: ModelInteractor)
: BaseFragmentPresenter<SkeletonFragmentPresenter.ViewModel>() {

    interface ViewModel {
        fun showToast(message: String)
        fun showSnackbar(message: String)
    }

    override fun onStart() {
        instanceReporter.log()
        // Use this callback to start some operation, like database a query
    }

    override fun onStop() {
        // Stop any running operation that might be busy in the background
    }

    fun buttonToastClicked(message: String) {
        toastInteractor.executeSomeComplexOperation (message) {
            viewModel?.showToast(it)
        }
    }

    fun buttonSnackbarClicked(message: String) {
        snackbarInteractor.executeSomeComplexOperation (message) {
            viewModel?.showSnackbar(it)
        }
    }
}
