/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.ui.fragments

import nl.endran.ui.injections.UiComponent
import nl.endran.ui.mvp.BaseFragment

class SkeletonFragment : BaseFragment<SkeletonFragmentPresenter.ViewModel, SkeletonFragmentPresenter, SkeletonFragmentView>() {

    companion object {
        fun createInstance() = SkeletonFragment()
    }

    override fun createView(uiComponent: UiComponent): SkeletonFragmentView {
        return uiComponent.skeletonFragmentView
    }

    override fun createPresenter(uiComponent: UiComponent): SkeletonFragmentPresenter {
        return uiComponent.skeletonFragmentPresenter
    }
}
