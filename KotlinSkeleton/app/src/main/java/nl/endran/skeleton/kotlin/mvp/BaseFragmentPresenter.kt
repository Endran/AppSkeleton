package nl.endran.skeleton.kotlin.mvp

abstract class BaseFragmentPresenter<VM> {

    protected var viewModel: VM? = null

    fun start(viewModel: VM) {
        this.viewModel = viewModel;
        onStart();
    }

    fun stop() {
        onStop()
        viewModel = null
    }

    abstract fun onStart();
    abstract fun onStop();

}
