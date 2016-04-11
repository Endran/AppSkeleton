/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.database.injections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nl.endran.core.InstanceReporter;
import nl.endran.core.collaborators.Database;
import timber.log.Timber;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    Database provideDatabase(final InstanceReporter instanceReporter) {
        return new Database() {
            @Override
            public void start() {
                // TODO
                Timber.i("Start Database");
                instanceReporter.log();
            }

            @Override
            public void stop() {
                // TODO
                Timber.i("Stop Database");
            }
        };
    }
}
