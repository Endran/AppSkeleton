/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton;

import android.app.Application;
import android.os.Handler;
import android.support.annotation.NonNull;

import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.CoreComponent;
import nl.endran.core.injections.DaggerCoreComponent;
import nl.endran.core.injections.ModelModule;
import nl.endran.ui.UiApplication;
import nl.endran.ui.injections.DaggerUiComponent;
import nl.endran.ui.injections.UiComponent;
import nl.endran.ui.injections.UiModule;


public class App extends Application implements UiApplication {

    CoreComponent coreComponent;
    UiComponent uiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidModule androidModule = getAndroidModule();
        ModelModule modelModule = getModelModule();
        UiModule uiModule = getUiModule();

        coreComponent = createCoreComponent(androidModule, modelModule);
        uiComponent = createUiComponent(androidModule, modelModule, uiModule);
    }

    UiComponent createUiComponent(
            @NonNull final AndroidModule androidModule,
            @NonNull final ModelModule modelModule,
            @NonNull final UiModule uiModule) {
        return DaggerUiComponent.builder()
                .androidModule(androidModule)
                .modelModule(modelModule)
                .uiModule(uiModule)
                .build();
    }

    CoreComponent createCoreComponent(
            @NonNull final AndroidModule androidModule,
            @NonNull final ModelModule modelModule) {
        return DaggerCoreComponent.builder()
                .androidModule(androidModule)
                .modelModule(modelModule)
                .build();
    }

    @NonNull
    UiModule getUiModule() {
        return new UiModule();
    }

    @NonNull
    ModelModule getModelModule() {
        return new ModelModule();
    }

    @NonNull
    AndroidModule getAndroidModule() {
        return new AndroidModule(this, new Handler());
    }

    @NonNull
    public CoreComponent getCoreComponent() {
        return coreComponent;
    }

    @Override
    @NonNull
    public UiComponent getUiComponent() {
        return uiComponent;
    }
}
