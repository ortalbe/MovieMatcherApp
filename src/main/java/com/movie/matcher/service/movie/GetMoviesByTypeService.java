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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ortal on 5/19/2018.
 */
public class GetMoviesByTypeService extends BaseService{

    private static Logger LOG = Logger.getLogger(GetMoviesByTypeService.class);
    private static final String CLASS_NAME = "GetMoviesByTypeService";
    private String type;
    private List<MovieBO> moviesList;

    public GetMoviesByTypeService(String type) {
        this.type=type;
        moviesList = new ArrayList<MovieBO>();
    }

    public void inputMapping() {

    }

    protected ErrorCode executeImpl() {
        String methodName = "::executeImpl ";

        LOG.info(CLASS_NAME + methodName + "start.");
        DataAccessObject dataAccessObject = new DataAccessObject();
        Controller controller = new Controller(dataAccessObject);

        moviesList= (List<MovieBO>) (List)  controller.runHQLWithMultiResult("from MovieBO where ctegories = '" + type +"'" );

        if(moviesList==null || moviesList.size()==0)
        {
            String tableName = MovieBO.class.getAnnotation(Table.class).name();
            String errorMessage = "table " + tableName + "  is empty " ;
            LOG.error(CLASS_NAME + methodName + errorMessage);
            ErrorValidation errorValidation = new ErrorValidation(ErrorCode.NOT_FOUND,errorMessage);
            response = Response.ok(errorValidation).build();
            LOG.info(CLASS_NAME + methodName + "no movies found by type: " + type);
            return ErrorCode.NOT_FOUND;
        }

        LOG.info(CLASS_NAME + methodName + "finished successfully.");
        return ErrorCode.SUCCESS;

    }

    public void outputMappint() {
        response = Response.accepted(moviesList).build();

    }

}
