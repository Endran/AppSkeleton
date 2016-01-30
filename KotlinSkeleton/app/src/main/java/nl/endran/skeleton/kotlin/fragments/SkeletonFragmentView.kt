package nl.endran.skeleton.kotlin.fragments

import android.view.View
import kotlinx.android.synthetic.main.fragment_skeleton.view.*
import nl.endran.skeleton.kotlin.R
import nl.endran.skeleton.kotlin.injections.showSnackBar
import nl.endran.skeleton.kotlin.injections.showToast
import nl.endran.skeleton.kotlin.mvp.BaseFragmentView

class SkeletonFragmentView : BaseFragmentView<SkeletonFragmentPresenter.SkeletonFragmentViewModel, SkeletonFragmentPresenter>() {

    override fun getViewId() = R.layout.fragment_skeleton

    override fun prepare(rootView: View) {
        rootView.buttonToast.setOnClickListener {
            presenter?.buttonToastClicked(rootView.editTextMessage.text.toString())
        }

        rootView.buttonSnackbar.setOnClickListener {
            presenter?.buttonSnackbarClicked(rootView.editTextMessage.text.toString())
        }
    }

    override fun getViewModel() = object : SkeletonFragmentPresenter.SkeletonFragmentViewModel {

        override fun showToast(message: String) {
            rootView?.showToast("showToast called with message $message")
        }

        override fun showSnackbar(message: String) {
            rootView?.showSnackBar("showSnackbar called with message $message")
        }
    }
}
