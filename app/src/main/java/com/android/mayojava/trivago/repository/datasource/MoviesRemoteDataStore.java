package com.android.mayojava.trivago.repository.datasource;

import com.android.mayojava.trivago.repository.MoviesRepository;
import com.android.mayojava.trivago.repository.api.MoviesService;
import com.android.mayojava.trivago.repository.models.PopularMovie;

import java.util.List;

import rx.Observable;

/**
 * Remote repository for the movies api
 */
public class MoviesRemoteDataStore implements MoviesRepository {
    private final MoviesService.MoviesApi mMoviesApi;

    public MoviesRemoteDataStore(MoviesService.MoviesApi moviesApi) {
        this.mMoviesApi = moviesApi;
    }

    @Override
    public Observable<List<PopularMovie>> popularMovies(String limit, String page,
                                                        String extended) {
        return mMoviesApi.getPopularMovies(limit, page, extended);
    }

    @Override
    public Observable<List<PopularMovie>> searchMovies(String query, String extended) {
        return mMoviesApi.getMovieSearchResult(query, extended);
    }
}
