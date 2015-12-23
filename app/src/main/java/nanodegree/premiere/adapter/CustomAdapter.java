package nanodegree.premiere.adapter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nanodegree.premiere.Activities.MovieLauncher;
import nanodegree.premiere.json_loaders.Post;
import nanodegree.premiere.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MovieViewHolder>
{



    DataHolder d1 = new DataHolder();


    public  class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
         CardView cv;
        TextView MovieName;
         ImageView MoviePhoto;



        MovieViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            MovieName = (TextView)itemView.findViewById(R.id.movie_name);
            MoviePhoto = (ImageView)itemView.findViewById(R.id.movie_photo);
            MoviePhoto.setScaleType(ImageView.ScaleType.FIT_START);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view)
        {




            Intent intent = new Intent(itemView.getContext(), MovieLauncher.class);
            Bundle extras = new Bundle();
            extras.putString("MOVIE_TITLE",d1.mpost.get(getLayoutPosition()).getOriginal_title());
            extras.putString("RELEASE_DATE",d1.mpost.get(getLayoutPosition()).getRelease_date());
            extras.putString("POSTER",d1.mpost.get(getLayoutPosition()).getPoster_path());
            extras.putDouble("VOTE_AVG",d1.mpost.get(getLayoutPosition()).getVote_average());
            extras.putString("SYNOPSIS",d1.mpost.get(getLayoutPosition()).getOverview());
            intent.putExtras(extras);

            itemView.getContext().startActivity(intent);







        }


    }

private class DataHolder
{
     List<Post> mpost;

}



    CustomAdapter(List<Post> mpost){
        this.d1.mpost = mpost;
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }








    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MovieViewHolder pvh = new MovieViewHolder(v);
        return pvh;
    }



    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int i)
    {

        movieViewHolder.MovieName.setText(d1.mpost.get(i).getTitle());

        if(d1.mpost.get(i).getPoster_path()!=null)
        {


            Picasso.with(movieViewHolder.MovieName.getContext())
                    .load("http://image.tmdb.org/t/p/w500"+d1.mpost.get(i).getPoster_path())
                    .into(movieViewHolder.MoviePhoto);

        }



    }

    @Override
    public int getItemCount()
    {

        if(d1.mpost!=null)
        {
            return d1.mpost.size();
        }
        else
        {
            return 0;
        }
    }

}
