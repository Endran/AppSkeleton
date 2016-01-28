package nl.endran.skeleton.kotlin.fragments

import nl.endran.skeleton.kotlin.injections.AppComponent

class SkeletonFragment : BaseFragment<SkeletonFragmentPresenter.SkeletonFragmentViewModel,SkeletonFragmentPresenter, SkeletonFragmentView>() {

    override fun createView(appComponent: AppComponent) = SkeletonFragmentView()

    override fun createPresenter(appComponent: AppComponent): SkeletonFragmentPresenter {
        return appComponent.skeletonFragmentPresenter
    }
}
