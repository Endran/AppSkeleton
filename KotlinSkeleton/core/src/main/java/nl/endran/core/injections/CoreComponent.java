/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.core.injections;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import nl.endran.core.ModelInteractor;

@Singleton
@Component(modules = {AndroidModule.class, ModelModule.class})
public interface CoreComponent {

    Context getContext();

    @Named(ModelModule.MODEL_INTERACTOR_A)
    ModelInteractor getModelInteractorA();
}
