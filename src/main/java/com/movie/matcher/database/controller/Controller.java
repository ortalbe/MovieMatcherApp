package com.movie.matcher.database.controller;


import com.movie.matcher.bean.BusinessObject;
import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.database.data.access.DataAccessObjectInterface;
import com.movie.matcher.definitions.ErrorCode;

import java.util.List;

/**
 * Controller - will create a new entry to REF_MOVIE_DETAILS.
 * we will use to object :
 * 1. Business Object - a POJO for the entry.
 * 2. Data access object - contain all operation recognized for the table.
 */

public class Controller {

    private DataAccessObjectInterface dataAccess;


    public Controller(DataAccessObjectInterface dataAccess) {
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

    public ErrorCode update(BusinessObject busniessObject)
    {
        ErrorCode status = dataAccess.update(busniessObject);
        return status;
    }

    public BusinessObject getByID(String businessObjectClass,String id)
    {
        BusinessObject businessObject = dataAccess.get(businessObjectClass,id);
        return businessObject;
    }

    public BusinessObject runHQL (String query)
    {
        BusinessObject businessObject = dataAccess.runQuery(query);

        return businessObject;
    }

    public List<BusinessObject> runHQLWithMultiResult (String query)
    {
        List <BusinessObject> businessObject = dataAccess.runQueryWithMultiResult(query);

        return businessObject;
    }

    
}

