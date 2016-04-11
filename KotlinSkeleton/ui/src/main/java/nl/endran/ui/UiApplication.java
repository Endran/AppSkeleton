/*
 * Copyright (c) 2016 by David Hardy. Licensed under the Apache License, Version 2.0.
 */

package nl.endran.ui;

import android.content.Context;
import android.support.annotation.NonNull;

import nl.endran.ui.injections.UiComponent;

public interface UiApplication {

    @NonNull
    Context getApplicationContext();

    @NonNull
    UiComponent getUiComponent();

}
