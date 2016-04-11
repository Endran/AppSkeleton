/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.core

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InstanceReporter @Inject constructor() {

    fun log() {
        Timber.i("I am instance $this")
    }
}