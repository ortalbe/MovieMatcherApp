package com.movie.matcher.service.movie;

import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.database.controller.Controler;
import com.movie.matcher.database.data.access.MovieDAO;
import com.movie.matcher.definitions.ErrorCode;
import com.movie.matcher.definitions.ErrorValidation;
import com.movie.matcher.service.BaseService;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;

/**
 * Created by Ortal on 5/20/2018.
 */
public class CreateMovieService extends BaseService {

    private static Logger LOG = Logger.getLogger(CreateMovieService.class);
    private static final String CLASS_NAME = "CreateMovieService";
    private MovieBO movie;

    public CreateMovieService(MovieBO movie) {
        this.movie = movie;
    }

    public void inputMapping() {

    }

    protected ErrorCode executeImpl() {
        String methodName = "::executeImpl ";

        LOG.info(CLASS_NAME + methodName + "start.");
        MovieDAO movieDAO = new MovieDAO();
        Controler controller = new Controler(movieDAO);
        ErrorCode status = controller.create(movie);
        if(ErrorCode.ERROR.equals(status))
        {
            String errorMessage =  " could not create movie entry. please check hibernate transaction in the log.";
            LOG.error(CLASS_NAME + methodName + errorMessage +movie);
            ErrorValidation errorValidation = new ErrorValidation(ErrorCode.ERROR,errorMessage);
            response=Response.ok(errorValidation).build();
            return  ErrorCode.ERROR;
        }
        LOG.info(CLASS_NAME + methodName + "finished successfully.");
        return ErrorCode.SUCCESS;
    }

    public void outputMappint() {

        response = Response.accepted(movie).build();
    }
}
