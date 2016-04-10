package nl.endran.skeleton.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nl.endran.skeleton.kotlin.fragments.SkeletonFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.contentView, SkeletonFragment.createInstance())
        transition.commit()
    }
}
