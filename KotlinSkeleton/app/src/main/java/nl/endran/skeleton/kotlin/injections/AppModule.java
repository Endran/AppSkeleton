package nl.endran.skeleton.kotlin.injections;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nl.endran.skeleton.kotlin.example.ExampleObject2;

@Module
public class AppModule {

    public static final String EXAMPLE_OBJECT_2_A = "EXAMPLE_OBJECT_2_A";
    public static final String EXAMPLE_OBJECT_2_B = "EXAMPLE_OBJECT_2_B";

    @NonNull
    private final Context context;

    @NonNull
    private final Handler handler;

    public AppModule(@NonNull final Context context, @NonNull final Handler handler) {
        this.context = context.getApplicationContext();
        this.handler = handler;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public Handler provideHandler() {
        return handler;
    }

    @Singleton
    @Provides
    public Resources provideResources(@NonNull final Context context) {
        return context.getResources();
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(@NonNull final Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    @Provides
    @Named(EXAMPLE_OBJECT_2_A)
    public ExampleObject2 provideExampleObject2A() {
        return new ExampleObject2("A");
    }

    @Provides
    @Named(EXAMPLE_OBJECT_2_B)
    public ExampleObject2 provideExampleObject2B() {
        return new ExampleObject2("B");
    }
}
