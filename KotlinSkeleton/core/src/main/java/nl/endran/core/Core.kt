/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.core

import nl.endran.core.collaborators.Backend
import nl.endran.core.collaborators.Database
import nl.endran.core.collaborators.Engine
import timber.log.Timber

class Core(val dataBase: Database, val backend: Backend, vararg private val engines: Engine) : Engine {

    override fun start() {
        Timber.i("Start Core")

        dataBase.start()
        backend.start()
        engines.forEach { it.start() }
    }

    override fun stop() {
        Timber.i("Stop Core")

        dataBase.start()
        backend.start()
        engines.forEach { it.start() }
    }
}