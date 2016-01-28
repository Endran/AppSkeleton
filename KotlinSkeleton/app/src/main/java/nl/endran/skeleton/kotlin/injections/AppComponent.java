package nl.endran.skeleton.kotlin.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.skeleton.kotlin.App;
import nl.endran.skeleton.kotlin.MainActivity;
import nl.endran.skeleton.kotlin.fragments.SkeletonFragmentPresenter;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(MainActivity mainActivity);

    SkeletonFragmentPresenter getSkeletonFragmentPresenter();
}
