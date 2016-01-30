package nl.endran.skeleton.kotlin

import android.app.Application

import com.facebook.stetho.Stetho

import nl.endran.skeleton.kotlin.injections.AppComponent
import timber.log.Timber

class DebugApp : App() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        Timber.plant(Timber.DebugTree())
        // Timber.plant(StethoTree())
    }
}
