package nl.endran.skeleton.kotlin.fragments

import nl.endran.skeleton.kotlin.example.ExampleObject1
import nl.endran.skeleton.kotlin.example.ExampleObject2

class SkeletonFragmentPresenter : BaseFragmentPresenter<SkeletonFragmentPresenter.SkeletonFragmentViewModel>() {

    interface SkeletonFragmentViewModel {
        fun coolCallBack1(exampleObject1: ExampleObject1)
        fun coolCallBack2(exampleObject2: ExampleObject2)
    }
}
