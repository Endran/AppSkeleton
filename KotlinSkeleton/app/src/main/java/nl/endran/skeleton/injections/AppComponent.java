package nl.endran.skeleton.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.skeleton.fragments.SkeletonFragmentPresenter;
import nl.endran.skeleton.fragments.SkeletonFragmentView;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    SkeletonFragmentView getSkeletonFragmentView();

    SkeletonFragmentPresenter getSkeletonFragmentPresenter();
}
