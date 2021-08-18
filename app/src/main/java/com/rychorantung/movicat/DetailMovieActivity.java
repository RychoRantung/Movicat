package com.rychorantung.movicat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rychorantung.movicat.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    String title, overview, image, release;
    double rating;
    ImageView imgDetail;
    TextView movTitle, movDetail, movRelease, movRating;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        movTitle = findViewById(R.id.movDetailTitle);
        movDetail = findViewById(R.id.movDetailDesc);
        movRelease = findViewById(R.id.movReleaseDetail);
        imgDetail = findViewById(R.id.imgDetailMov);
        movRating = findViewById(R.id.movRateDetail);



        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        release = result.getReleaseDate();
        image = result.getPosterPath();
        rating = result.getVoteAverage();

        movTitle.setText(title);
        movDetail.setText(overview);
        movRelease.setText(release);
        movRating.setText(String.valueOf(rating));


        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}