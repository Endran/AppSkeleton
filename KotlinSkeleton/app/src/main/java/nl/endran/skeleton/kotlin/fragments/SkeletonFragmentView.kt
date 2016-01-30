package nl.endran.skeleton.kotlin.fragments

import android.view.View
import nl.endran.skeleton.kotlin.R
import nl.endran.skeleton.kotlin.example.ExampleObject1
import nl.endran.skeleton.kotlin.example.ExampleObject2
import nl.endran.skeleton.kotlin.injections.showSnackBar
import nl.endran.skeleton.kotlin.injections.showToast
import nl.endran.skeleton.kotlin.mvp.BaseFragmentView

class SkeletonFragmentView : BaseFragmentView<SkeletonFragmentPresenter.SkeletonFragmentViewModel, SkeletonFragmentPresenter>() {

    override fun prepare(rootView: View) {
        // Set click listeners and textViews etc
    }

    override fun getViewId() = R.layout.fragment_skeleton

    override fun getViewModel() = object : SkeletonFragmentPresenter.SkeletonFragmentViewModel {
        override fun coolCallBack1(exampleObject1: ExampleObject1) {
            rootView?.showToast("coolCallBack1 with $exampleObject1")
        }

        override fun coolCallBack2(exampleObject2: ExampleObject2) {
            rootView?.showSnackBar("coolCallBack2 with $exampleObject2:${exampleObject2.text}")
        }
    }
}
