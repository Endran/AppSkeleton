package nl.endran.skeleton.fragments

import nl.endran.skeleton.injections.AppComponent
import nl.endran.skeleton.mvp.BaseFragment

class SkeletonFragment : BaseFragment<SkeletonFragmentPresenter.ViewModel, SkeletonFragmentPresenter, SkeletonFragmentView>() {

    companion object {
        fun createInstance() = SkeletonFragment()
    }

    override fun createView(appComponent: AppComponent): SkeletonFragmentView {
        return appComponent.skeletonFragmentView
    }

    override fun createPresenter(appComponent: AppComponent): SkeletonFragmentPresenter {
        return appComponent.skeletonFragmentPresenter
    }
}
