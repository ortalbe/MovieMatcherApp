package com.movie.matcher.database.data.access;


import com.movie.matcher.bean.BusinessObject;
import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.definitions.ErrorCode;

import java.util.List;

/**
 * DataAccessObjectInterface - data access interface. all DAO must implemt it.
 */
public interface DataAccessObjectInterface <E extends BusinessObject>  {

    ErrorCode save(E busniessObject);
    ErrorCode update(E busniessObject);
    ErrorCode delete(E busniessObject);
    BusinessObject get(String className, String id);
    ErrorCode openSingeltonSessionFactory();
    BusinessObject runQuery(String query);
    List<BusinessObject> runQueryWithMultiResult(String query);

}
