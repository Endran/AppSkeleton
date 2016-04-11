/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton;

import android.app.Application;
import android.os.Handler;
import android.support.annotation.NonNull;

import nl.endran.backend.injections.BackendModule;
import nl.endran.core.Core;
import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.ModelModule;
import nl.endran.database.injections.DatabaseModule;
import nl.endran.skeleton.injections.AppComponent;
import nl.endran.skeleton.injections.AppModule;
import nl.endran.skeleton.injections.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        ModelModule modelModule = createModelModule();
        AndroidModule androidModule = createAndroidModule();
        BackendModule backendModule = createBackendModule();
        DatabaseModule databaseModule = createDatabaseModule();
        AppModule appModule = createAppModule();

        appComponent = createAppComponent(androidModule, modelModule, backendModule, databaseModule, appModule);

        Core core = appComponent.getCore();
        core.start();
    }

    AppComponent createAppComponent(
            AndroidModule androidModule,
            ModelModule modelModule,
            BackendModule backendModule,
            DatabaseModule databaseModule,
            AppModule appModule) {

        return DaggerAppComponent.builder()
                .androidModule(androidModule)
                .modelModule(modelModule)
                .backendModule(backendModule)
                .databaseModule(databaseModule)
                .appModule(appModule)
                .build();
    }

    @NonNull
    AppModule createAppModule() {
        return new AppModule();
    }

    @NonNull
    BackendModule createBackendModule() {
        return new BackendModule();
    }

    @NonNull
    DatabaseModule createDatabaseModule() {
        return new DatabaseModule();
    }

    @NonNull
    ModelModule createModelModule() {
        return new ModelModule();
    }

    @NonNull
    AndroidModule createAndroidModule() {
        return new AndroidModule(this, new Handler());
    }

    @NonNull
    public AppComponent getAppComponent() {
        return appComponent;
    }
}
