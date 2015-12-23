package nanodegree.premiere.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nanodegree.premiere.R;

public class MovieLauncher extends AppCompatActivity {

    private static String m_name;
    private static String release_date;
    private static String poster_link;
    private static double vote_avg;
    private static String synopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_launcher);

        Bundle extras = getIntent().getExtras();
        m_name = extras.getString("MOVIE_TITLE");
        release_date =extras.getString("RELEASE_DATE");
        poster_link = extras.getString("POSTER");
        vote_avg = extras.getDouble("VOTE_AVG");
        synopsis = extras.getString("SYNOPSIS");

        ImageView posterImg = (ImageView)findViewById(R.id.MoviePoster);
        posterImg.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.with(this)
                .load("http://image.tmdb.org/t/p/original" + poster_link)
                .into(posterImg);

        TextView movie_name = (TextView)findViewById(R.id.titleTextMovie);
        movie_name.setText(m_name);

        TextView release = (TextView)findViewById(R.id.release_date_text);
        release.setText(release_date);

        String temp = Double.toString(vote_avg);
        TextView vote_text = (TextView)findViewById(R.id.vote_text);
        vote_text.setText(temp);



        TextView synopsis_text = (TextView)findViewById(R.id.synopsis_text);
        synopsis_text.setText(synopsis);

    }

    public void goBack(View view)
    {
        finish();
    }
}
