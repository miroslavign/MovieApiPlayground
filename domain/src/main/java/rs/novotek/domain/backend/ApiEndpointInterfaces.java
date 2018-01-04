/*
 * ApiEndpointInterfaces.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 6/30/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.backend;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rs.novotek.domain.model.discover.DiscoverMovies;
import rs.novotek.domain.model.movie.Movies;

public interface ApiEndpointInterfaces {

    //////////// MOVIES /////////////
    @GET("movie/{movie_id}")
    Single<Movies> getMovie(
            @Path("movie_id") Integer movieId);

    @GET("discover/movie")
    Single<DiscoverMovies> disoverMovies(
            @Query("page") Integer pageNr);

    // https://api.themoviedb.org/3/discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22&api_key=9c30d256def62f7f3b1cb393106536d6

}
