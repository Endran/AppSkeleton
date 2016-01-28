package nl.endran.skeleton.kotlin;

import android.app.Application;
import android.os.Handler;

import nl.endran.skeleton.kotlin.injections.AppComponent;
import nl.endran.skeleton.kotlin.injections.AppModule;
import nl.endran.skeleton.kotlin.injections.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this, new Handler())).build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
