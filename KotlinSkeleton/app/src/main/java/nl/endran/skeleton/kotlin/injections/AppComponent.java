package nl.endran.skeleton.kotlin.injections;

import javax.inject.Singleton;

import dagger.Component;
import nl.endran.skeleton.kotlin.fragments.SkeletonFragmentPresenter;
import nl.endran.skeleton.kotlin.fragments.SkeletonFragmentView;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    SkeletonFragmentView getSkeletonFragmentView();

    SkeletonFragmentPresenter getSkeletonFragmentPresenter();
}
