package com.android.mayojava.trivago.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.mayojava.trivago.R;
import com.android.mayojava.trivago.moviedetails.di.MovieDetailsPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Movie details fragment
 */
public class MovieDetailsFragment extends Fragment  implements MovieDetailsContract.View {

    @BindView(R.id.image_view_movie_poster) ImageView mPosterImageView;
    @BindView(R.id.text_view_movie_title) TextView mMovieTitleTextView;
    @BindView(R.id.text_view_tagline_header) TextView mTextViewTaglineHeader;
    @BindView(R.id.text_view_tagline_details) TextView mTextViewTaglineDetails;
    @BindView(R.id.text_view_overview_header) TextView mTextViewOverviewHeader;
    @BindView(R.id.text_view_overview_details) TextView mTextViewOverviewDetails;
    @BindView(R.id.text_view_ratings_header) TextView mTextViewRatingsHeader;
    @BindView(R.id.details_rating_bar) AppCompatRatingBar mRatingBar;
    @BindView(R.id.text_view_trailer_header) TextView mTextViewTrailerHeader;
    @BindView(R.id.text_view_trailer_url) TextView mTextViewTrailerUrl;

    MovieDetailsContract.Presenter mPresenter;

    public static Fragment newInstance(Bundle args) {
        Fragment fragment = new MovieDetailsFragment();

        if (args == null) {
            args = new Bundle();
        }

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews();
    }

    @Override
    public void setPresenter(MovieDetailsContract.Presenter presenter) {
        if (presenter != null) {
            this.mPresenter = presenter;
        }
    }

    private void setupViews() {
        Bundle params = getArguments();

        mPresenter.loadPosterImage(params.getString(MovieDetailsActivity.ARG_MOVIE_POSTER));
        mPresenter.setOverview(MovieDetailsActivity.ARG_OVERVIEW);
        mPresenter.setTagline(MovieDetailsActivity.ARG_TAGLINE);
    }

    @Override
    public void loadMoviePosterImage(String url) {
        Picasso.with(getContext())
                .load(url)
                .into(mPosterImageView);
    }

    @Override
    public void setMovieTitle(String title) {
        mMovieTitleTextView.setVisibility(View.VISIBLE);
        mMovieTitleTextView.setText(title);
    }

    @Override
    public void setMovieOverview(String overview) {
        mTextViewOverviewHeader.setVisibility(View.VISIBLE);
        mTextViewOverviewDetails.setVisibility(View.VISIBLE);
        mTextViewOverviewDetails.setText(overview);

    }

    @Override
    public void setMovieTagline(String tagline) {
        mTextViewTaglineHeader.setVisibility(View.VISIBLE);
        mTextViewTaglineDetails.setVisibility(View.VISIBLE);
        mTextViewTaglineDetails.setText(tagline);
    }

    @Override
    public void showRatings(float ratings) {
        mRatingBar.setVisibility(View.VISIBLE);
        mTextViewRatingsHeader.setVisibility(View.VISIBLE);
        mRatingBar.setRating(ratings);
    }

    @Override
    public void setMovieTrailerUrl(String url) {
        mTextViewTrailerHeader.setVisibility(View.VISIBLE);
        mTextViewTrailerUrl.setVisibility(View.VISIBLE);
        mTextViewTrailerUrl.setText(url);
    }
}
