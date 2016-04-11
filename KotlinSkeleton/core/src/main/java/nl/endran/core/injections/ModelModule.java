/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.core.injections;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import nl.endran.core.ModelInteractor;

@Module
public class ModelModule {

    public static final String MODEL_INTERACTOR_A = "MODEL_INTERACTOR_A";
    public static final String MODEL_INTERACTOR_B = "MODEL_INTERACTOR_B";

    @Provides
    @Named(MODEL_INTERACTOR_A)
    public ModelInteractor provideModelInteractorA() {
        return new ModelInteractor("A");
    }

    @Provides
    @Named(MODEL_INTERACTOR_B)
    public ModelInteractor provideModelInteractorB() {
        return new ModelInteractor("B");
    }
}
