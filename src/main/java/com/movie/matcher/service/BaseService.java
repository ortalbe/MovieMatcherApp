package com.movie.matcher.service;

import com.movie.matcher.definitions.ErrorCode;

import javax.ws.rs.core.Response;

/**
 * Created by Ortal on 5/18/2018.
 */
public abstract class BaseService {

    protected Response response;

    public  ErrorCode execute()
       {
           ErrorCode status;
           inputMapping();
           status = executeImpl();
           if(ErrorCode.SUCCESS.equals(status))
               outputMappint();
           return status;
       }

    public abstract void inputMapping();

    protected abstract ErrorCode executeImpl();

    public abstract void outputMappint();

    public Response getResponse() {
        return response;
    }
}
