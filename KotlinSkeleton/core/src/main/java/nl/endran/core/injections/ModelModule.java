/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.core.injections;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nl.endran.core.Core;
import nl.endran.core.ModelInteractor;
import nl.endran.core.collaborators.Backend;
import nl.endran.core.collaborators.Database;

@Module
public class ModelModule {

    public static final String MODEL_INTERACTOR_A = "MODEL_INTERACTOR_A";
    public static final String MODEL_INTERACTOR_B = "MODEL_INTERACTOR_B";

    @Provides
    @Singleton
    public Core provideCore(Database database, Backend backend) {
        return new Core(database, backend);
    }

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
