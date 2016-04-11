/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.backend.injections;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import dagger.Subcomponent;
import nl.endran.core.collaborators.Backend;
import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.ModelModule;

@Singleton
@Subcomponent(modules = {BackendModule.class})
//@Component(modules = {BackendModule.class}, dependencies = {ModelModule.class, AndroidModule.class})
public interface BackendComponent {

//    Backend getBackend();

}
