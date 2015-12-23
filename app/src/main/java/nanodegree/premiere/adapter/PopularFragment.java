package nanodegree.premiere.adapter;


import android.app.ProgressDialog;
import android.content.Context;
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

public class PopularFragment extends Fragment {

    public static String URL1;
    private RecyclerView mRecyclerViewPop;
    private CustomAdapter mAdapterPop;
    private Key key1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.popular, container, false);

        key1 = new Key();
        URL1 = "http://api.themoviedb.org/3/movie/popular?api_key="+key1.getKey();


        mRecyclerViewPop = (RecyclerView) rootView.findViewById(R.id.rv);
        new SimpleTask1().execute(URL1);

        GridLayoutManager glm_pop = new GridLayoutManager(getActivity(),3, LinearLayoutManager.VERTICAL,false);

        mRecyclerViewPop.setLayoutManager(glm_pop);

        return rootView;
    }

    private class SimpleTask1 extends AsyncTask<String, String, String> {

        ProgressDialog progress1;





        @Override
        protected void onPreExecute() {
            progress1 = new ProgressDialog(getContext());
            progress1.setMessage("Downloading Movies :) ");
            progress1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progress1.setIndeterminate(true);
        }

        protected String doInBackground(String... urls) {
            String result1 = "";
            try {

                HttpGet httpGet1 = new HttpGet(urls[0]);
                HttpClient client1 = new DefaultHttpClient();

                HttpResponse response1 = client1.execute(httpGet1);

                int statusCode = response1.getStatusLine().getStatusCode();

                if (statusCode == 200) {
                    InputStream inputStream1 = response1.getEntity().getContent();
                    BufferedReader reader1 = new BufferedReader
                            (new InputStreamReader(inputStream1));
                    String line1;
                    while ((line1 = reader1.readLine()) != null) {
                        result1 += line1;
                    }
                }

            } catch (ClientProtocolException e) {

            } catch (IOException e) {

            }
            //Log.w("PREMIERE::::",result);
            return result1;
        }

        protected void onPostExecute(String jsonString) {
            // Dismiss ProgressBar
            showData(jsonString);
            progress1.dismiss();
        }
    }
    private void showData(String jsonString) {
         try
        {
            Gson gson = new Gson();
            Movie_Skeleton movie1 = gson.fromJson(jsonString, Movie_Skeleton.class);
            List<Post> posts_popular = movie1.getPosts();

            mAdapterPop = new CustomAdapter(posts_popular);
            mAdapterPop.notifyDataSetChanged();




            mRecyclerViewPop.setAdapter(mAdapterPop);

        }
        catch (Exception e)
        {
            Snackbar.make(getActivity().findViewById(android.R.id.content), "Check data connection", Snackbar.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
