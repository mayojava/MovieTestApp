package com.android.mayojava.trivago.popularmovies.di;

import com.android.mayojava.trivago.popularmovies.PopularMoviesContract;

import dagger.Module;
import dagger.Provides;

/**
 * module that provides the dependencies for popular movies activity
 */
@Module
public class ActivityPresenterModule {
    private final PopularMoviesContract.View mView;

    public ActivityPresenterModule(PopularMoviesContract.View view) {
        this.mView = view;
    }

    @Provides
    @FragmentScoped
    PopularMoviesContract.View providesPopularMoviesContractView() {
        return mView;
    }

}
