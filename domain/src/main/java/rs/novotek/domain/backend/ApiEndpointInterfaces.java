
/*
 * ApiEndpointInterfaces.java
 * Heyandroid
 *
 * Created by Miroslav Ignjatovic on 9/17/2016
 * Copyright (c) 2015 CommonSun All rights reserved.
 */

package rs.novotek.domain.backend;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rs.novotek.domain.model.Movies;


public interface ApiEndpointInterfaces {

    //////////// MOVIES /////////////
    @GET("movie/{movie_id}")
    Single<Movies> getMovie(
            @Path("movie_id") String movieId);

}
