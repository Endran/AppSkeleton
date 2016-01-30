package nl.endran.skeleton.kotlin.fragments

import nl.endran.skeleton.kotlin.example.ModelInteractor
import nl.endran.skeleton.kotlin.example.ExampleObject2
import nl.endran.skeleton.kotlin.mvp.BaseFragmentPresenter
import javax.inject.Inject

class SkeletonFragmentPresenter @Inject constructor() : BaseFragmentPresenter<SkeletonFragmentPresenter.SkeletonFragmentViewModel>() {

    interface SkeletonFragmentViewModel {
        fun showToast(message: String)
        fun showSnackbar(message: String)
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    fun buttonToastClicked(message: String) {
        viewModel?.showToast(message)
    }

    fun buttonSnackbarClicked(message: String) {
        viewModel?.showSnackbar(message)
    }
}
