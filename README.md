# Premiere

This is the *Popular Movies 1* App , The name of this app is **Premiere**. It displays popular and top-rated movies from TMDB. 

![alt tag](http://s18.postimg.org/a26th6nuh/DFG_2015_12_23_10_30_07.png)

![alt tag](http://s3.postimg.org/gub6o3b2r/DFG_2015_12_23_10_29_51.png)

###KEY

In order to build this successfully, you'll need to obtain your own API key, which is available [here!](https://www.themoviedb.org/documentation/api?language=en)
You'll need to replace your key in `Premiere/app/src/main/java/nanodegree/premiere/Keys/Key.java`
```
public class Key
{
    private static final String PRECIOUS = "XXXXXXXXXXXXXX"; // <-- Replace your key here 

    public String getKey()
    {
        String pass = PRECIOUS;
        return pass;
    }

}
```

###REFERENCES

* [ListView with Gson](https://gist.github.com/Phonbopit/0935541274083f778d6f)
* [CardView with RecyclerView](http://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465)
* [Fragments](http://developer.android.com/reference/android/app/Fragment.html)
* [ViewPager](http://developer.android.com/reference/android/support/v4/view/ViewPager.html)
* [TabbedLayout](http://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/)


#####Questions asked:
1. [gson.fromjson](http://stackoverflow.com/questions/34391090/gson-fromjson-causes-nullpointerexception)
2. [picasso with custom adapter](http://stackoverflow.com/questions/34395777/how-to-use-picasso-with-custom-adapter-for-recyclerview)
3. [Fragment loading duplicate values](http://stackoverflow.com/questions/34421388/how-to-fix-fragment-loading-duplicate-value)
4. [non static variable](http://stackoverflow.com/questions/34421910/how-to-make-the-variable-and-method-of-an-adapter-non-static)
