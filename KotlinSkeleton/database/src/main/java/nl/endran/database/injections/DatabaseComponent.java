/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.database.injections;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import dagger.Subcomponent;
import nl.endran.core.collaborators.Backend;
import nl.endran.core.collaborators.Database;
import nl.endran.core.injections.AndroidModule;
import nl.endran.core.injections.ModelModule;

@Singleton
@Subcomponent(modules = {DatabaseModule.class})
//@Component(modules = {DatabaseModule.class}, dependencies = {ModelModule.class, AndroidModule.class})
public interface DatabaseComponent {

//    Database getDatabase();
}
