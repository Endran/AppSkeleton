package nl.endran.skeleton

import com.facebook.stetho.Stetho
import timber.log.Timber

class DebugApp : App() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        Timber.plant(Timber.DebugTree())
        // Timber.plant(StethoTree())
    }
}
