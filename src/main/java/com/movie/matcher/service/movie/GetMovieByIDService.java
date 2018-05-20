package com.movie.matcher.service.movie;

import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.database.controller.Controller;
import com.movie.matcher.database.data.access.DataAccessObject;
import com.movie.matcher.definitions.ErrorCode;
import com.movie.matcher.definitions.ErrorValidation;
import com.movie.matcher.service.BaseService;
import org.apache.log4j.Logger;

import javax.persistence.Table;
import javax.ws.rs.core.Response;

/**
 * Created by Ortal on 5/19/2018.
 */
public class GetMovieByIDService extends BaseService{

    private String id;
    private static Logger LOG = Logger.getLogger(GetMovieByIDService.class);
    private static final String CLASS_NAME = "GetMovieByIDService";

    private MovieBO movie;
    public GetMovieByIDService(String id) {
        this.id = id;
    }

    public void inputMapping() {

    }

    protected ErrorCode executeImpl() {
        String methodName = "::executeImpl ";

        LOG.info(CLASS_NAME + methodName + "start.");
        DataAccessObject dataAccessObject = new DataAccessObject();
        Controller controller = new Controller(dataAccessObject);
        movie = (MovieBO) controller.getByID(MovieBO.class.getName(),id);

        if(movie==null)
        {
            String tableName = MovieBO.class.getAnnotation(Table.class).name();
            String errorMessage = "Movie with ID = " +id  +" not exist in " + tableName;
            LOG.error(CLASS_NAME + methodName + errorMessage);
            ErrorValidation errorValidation = new ErrorValidation(ErrorCode.NOT_FOUND,errorMessage);
            response = Response.ok(errorValidation).build();
            LOG.info(CLASS_NAME + methodName + " no movies found by ID: " +id );
            return ErrorCode.NOT_FOUND;
        }


        LOG.info(CLASS_NAME + methodName + "finished successfully.");
        return ErrorCode.SUCCESS;

    }

    public void outputMappint() {
        response = Response.accepted(movie).build();
    }

}
