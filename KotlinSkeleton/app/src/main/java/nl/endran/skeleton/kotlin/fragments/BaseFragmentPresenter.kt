package nl.endran.skeleton.kotlin.fragments

abstract class BaseFragmentPresenter<VM> {

    private var viewModel: VM? = null

    fun start(viewModel: VM) {
        this.viewModel = viewModel;
    }

    fun stop() {
        viewModel = null
    }
}
