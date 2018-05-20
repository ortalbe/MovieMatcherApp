package com.movie.matcher.web.interfaces;

import com.movie.matcher.bean.MovieBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * MovieResource - reflect all rest resources related to movies
 */

@Path("/movie")
public interface MovieResource {


    @POST
    @Path("/create_movie")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response createMovie(MovieBO movie);

    @GET
    @Path("/get_movie_by_id")
    @Produces(MediaType.APPLICATION_JSON)
    Response getMovieByID(@QueryParam("id") String id);

    @GET
    @Path("/get_movies")
    @Produces(MediaType.APPLICATION_JSON)
    Response getMovies();

    @GET
    @Path("/get_movies/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getMoviesByType(@PathParam("type") String type);

}
