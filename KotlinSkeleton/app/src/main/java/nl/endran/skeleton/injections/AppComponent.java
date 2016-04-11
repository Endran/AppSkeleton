/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.skeleton.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.backend.injections.BackendModule;
import nl.endran.core.Core;
import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.ModelModule;
import nl.endran.database.injections.DatabaseModule;
import nl.endran.skeleton.fragments.SkeletonFragmentPresenter;
import nl.endran.skeleton.fragments.SkeletonFragmentView;

@Singleton
@Component(modules = {ModelModule.class, AndroidModule.class, DatabaseModule.class, BackendModule.class, AppModule.class})
public interface AppComponent {

    Core getCore();

    SkeletonFragmentView getSkeletonFragmentView();

    SkeletonFragmentPresenter getSkeletonFragmentPresenter();
}
