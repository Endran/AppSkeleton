package nl.endran.skeleton.kotlin.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nl.endran.skeleton.kotlin.injections.AppComponent
import nl.endran.skeleton.kotlin.injections.getAppComponent

abstract class BaseFragment<VM, P : BaseFragmentPresenter<VM>, V : BaseFragmentView<VM, P>> : Fragment() {

    var view: V? = null
    var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View? {
        val appComponent = inflater.context.getAppComponent()
        view = createView(appComponent)
        return view!!.inflate(inflater, container, savedInstanceState)
    }

    override fun onDestroyView() {
        view?.deflate()
        view = null
    }

    override fun onResume() {
        super.onResume()
        presenter = createPresenter(activity.getAppComponent())
        view?.start(presenter!!)
    }

    abstract fun createView(appComponent: AppComponent): V
    abstract fun createPresenter(appComponent: AppComponent): P
}
