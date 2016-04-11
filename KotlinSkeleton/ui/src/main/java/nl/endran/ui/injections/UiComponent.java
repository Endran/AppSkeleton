/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.ui.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.ModelModule;
import nl.endran.ui.fragments.SkeletonFragmentPresenter;
import nl.endran.ui.fragments.SkeletonFragmentView;

@Singleton
@Component(modules = {UiModule.class}, dependencies = {ModelModule.class, AndroidModule.class})
public interface UiComponent {

    SkeletonFragmentView getSkeletonFragmentView();

    SkeletonFragmentPresenter getSkeletonFragmentPresenter();
}
