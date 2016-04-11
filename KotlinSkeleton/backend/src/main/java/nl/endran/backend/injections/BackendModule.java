/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.backend.injections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nl.endran.core.InstanceReporter;
import nl.endran.core.collaborators.Backend;
import timber.log.Timber;

@Module
public class BackendModule {

    @Provides
    @Singleton
    Backend provideBackend(final InstanceReporter instanceReporter) {
        return new Backend() {
            @Override
            public void start() {
                // TODO
                Timber.i("Start Backend");
                instanceReporter.log();
            }

            @Override
            public void stop() {
                // TODO
                Timber.i("Stop Backend");
            }
        };
    }
}
