package nl.endran.skeleton.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nl.endran.skeleton.kotlin.fragments.SkeletonFragment
import nl.endran.skeleton.kotlin.injections.getAppComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        getAppComponent().inject(this)

        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.contentView, SkeletonFragment.createInstance())
        transition.commit()
    }
}
