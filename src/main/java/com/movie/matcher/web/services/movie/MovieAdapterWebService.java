package com.movie.matcher.web.services.movie;

import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.definitions.ErrorCode;
import com.movie.matcher.service.movie.CreateMovieService;
import com.movie.matcher.service.movie.GetMovieByIDService;
import com.movie.matcher.service.movie.GetMoviesByTypeService;
import com.movie.matcher.service.movie.GetMoviesService;
import com.movie.matcher.web.interfaces.MovieResource;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * MovieAdapterWebService - implementation of all rest resources
 */


//TODO_Ortal - understand how to separate it to a few class each method in a different class.

public class MovieAdapterWebService implements MovieResource{

    public Response createMovie(MovieBO movie) {
        CreateMovieService service = new CreateMovieService(movie);
        ErrorCode status = service.execute();
        return service.getResponse();
    }

    public Response getMovieByID(String id) {
        ErrorCode status;
        GetMovieByIDService service = new GetMovieByIDService(id);
        status = service.execute();

        return service.getResponse();
    }

    public Response getMovies() {
        ErrorCode status;
        GetMoviesService service = new GetMoviesService();
        status = service.execute();
        return service.getResponse();
    }

    public Response getMoviesByType(String type) {
        ErrorCode status;
        GetMoviesByTypeService service = new GetMoviesByTypeService(type);
        status = service.execute();
        return service.getResponse();
    }

}
