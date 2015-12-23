package nanodegree.premiere.adapter;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import nanodegree.premiere.Keys.Key;
import nanodegree.premiere.json_loaders.Movie_Skeleton;
import nanodegree.premiere.json_loaders.Post;
import nanodegree.premiere.R;


public class TopRatedFragment extends Fragment
{
    public static String URL2;
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private Key key2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.top_rated, container, false);

        key2 = new Key();

        URL2 = "http://api.themoviedb.org/3/movie/top_rated?api_key="+key2.getKey();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvTop);
        new SimpleTask2().execute(URL2);

        GridLayoutManager glm_rated = new GridLayoutManager(getActivity(),3, LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(glm_rated);



        return rootView;
    }
    private class SimpleTask2 extends AsyncTask<String, Void, String> {

        ProgressDialog progress2;

        @Override
        protected void onPreExecute() {
            progress2 = new ProgressDialog(getActivity());
            progress2.setMessage("Downloading Movies :) ");
            progress2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progress2.setIndeterminate(true);
        }

        protected String doInBackground(String... urls) {
            String result2 = "";
            try {

                HttpGet httpGet2 = new HttpGet(urls[0]);
                HttpClient client2 = new DefaultHttpClient();

                HttpResponse response2 = client2.execute(httpGet2);

                int statusCode2 = response2.getStatusLine().getStatusCode();

                if (statusCode2 == 200) {
                    InputStream inputStream = response2.getEntity().getContent();
                    BufferedReader reader = new BufferedReader
                            (new InputStreamReader(inputStream));
                    String line2;
                    while ((line2 = reader.readLine()) != null) {
                        result2 += line2;
                    }
                }

            } catch (ClientProtocolException e) {

            } catch (IOException e) {

            }
            //Log.w("PREMIERE::::",result);
            return result2;
        }

        protected void onPostExecute(String jsonString) {
            // Dismiss ProgressBar
            showData(jsonString);
            progress2.dismiss();
        }
    }
    private void showData(String jsonString) {
        try
        {
            Gson gson = new Gson();
            Movie_Skeleton movie2 = gson.fromJson(jsonString, Movie_Skeleton.class);
            List<Post> posts_rated = movie2.getPosts();

            mAdapter = new CustomAdapter(posts_rated);
            mAdapter.notifyDataSetChanged();




            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e)
        {Snackbar.make(getActivity().findViewById(android.R.id.content), "check data connection", Snackbar.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
