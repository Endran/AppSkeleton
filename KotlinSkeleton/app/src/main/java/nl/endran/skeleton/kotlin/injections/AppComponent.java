package nl.endran.skeleton.kotlin.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.skeleton.kotlin.App;
import nl.endran.skeleton.kotlin.MainActivity;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(MainActivity mainActivity);
}
