package com.movie.matcher.database.controller;


import com.movie.matcher.bean.BusinessObject;
import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.database.data.access.DataAccessObjectInterface;
import com.movie.matcher.database.data.access.MovieDAO;
import com.movie.matcher.definitions.ErrorCode;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Controler - will create a new entry to REF_MOVIE_DETAILS.
 * we will use to object :
 * 1. Business Object - a POJO for the entry.
 * 2. Data access object - contain all operation recognized for the table.
 */

public class Controler {

    private DataAccessObjectInterface dataAccess;


    public Controler(DataAccessObjectInterface dataAccess) {
        this.dataAccess = dataAccess;
    }

    public DataAccessObjectInterface getMovieDAO() {
        return dataAccess;
    }

    public void setMovieDAO(DataAccessObjectInterface dataAccess) {
        this.dataAccess = dataAccess;
    }

    public ErrorCode create(BusinessObject busniessObject)
    {
        ErrorCode status = dataAccess.save(busniessObject);
        return status;
    }

    public BusinessObject getByID(String businessObjectClass,String id)
    {
        BusinessObject businessObject = dataAccess.get(businessObjectClass,id);
        return businessObject;
    }

    public MovieBO runHQL (String query)
    {
        MovieBO movie = dataAccess.runQuery(query);

        return movie;
    }

    public List<MovieBO> runHQLWithMultiResult (String query)
    {
        List <MovieBO> movies = dataAccess.runQueryWithMultiResult(query);

        return movies;
    }

    
}

