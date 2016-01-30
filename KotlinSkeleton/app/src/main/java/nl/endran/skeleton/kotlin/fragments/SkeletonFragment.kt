package nl.endran.skeleton.kotlin.fragments

import android.content.Context
import android.view.View
import android.view.ViewGroup
import nl.endran.skeleton.kotlin.injections.AppComponent
import nl.endran.skeleton.kotlin.mvp.BaseFragment

class SkeletonFragment : BaseFragment<SkeletonFragmentPresenter.SkeletonFragmentViewModel, SkeletonFragmentPresenter, SkeletonFragmentView>() {

    companion object {
        fun createInstance() = SkeletonFragment()
    }

    override fun createView(appComponent: AppComponent) = SkeletonFragmentView()

    override fun createPresenter(appComponent: AppComponent): SkeletonFragmentPresenter {
        return appComponent.skeletonFragmentPresenter
    }
}
