package nl.endran.skeleton;

import android.app.Application;
import android.os.Handler;

import nl.endran.skeleton.injections.AppComponent;
import nl.endran.skeleton.injections.AppModule;
import nl.endran.skeleton.injections.DaggerAppComponent;


public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this, new Handler())).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
