# Premiere

This is a fully functional and powerful app developed with rich UI designed for movie buffs as part of Udacity's nano degree program. The app provides the user with top rated and popular movies with their ratings and trailers.

## Features

* Discover the most popular, the most rated or the highest rated movies
* Save favorite movies locally to view them even when offline
* Watch trailers
* Read reviews

## Screens

![alt tag](http://s18.postimg.org/a26th6nuh/DFG_2015_12_23_10_30_07.png)

![alt tag](http://s3.postimg.org/gub6o3b2r/DFG_2015_12_23_10_29_51.png)

## Work with the Source code

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


## Libraries 

* [Apache HTTP](https://hc.apache.org/httpcomponents-client-4.3.x/android-port.html)
* [GSON](https://github.com/google/gson)
* [Google design support library](https://developer.android.com/training/material/design-library.html)
* [Picasso](http://square.github.io/picasso/)

## Android Developer Nanodegree
[![udacity][1]][2]

[1]: ../master/art/nanodegree-logo.png
[2]: https://www.udacity.com/course/android-developer-nanodegree--nd801

## License

    Copyright 2015 Shaheen A Kader

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
