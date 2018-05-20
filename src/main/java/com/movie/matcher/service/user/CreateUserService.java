package com.movie.matcher.service.user;

import com.movie.matcher.bean.UserBO;
import com.movie.matcher.database.controller.Controller;
import com.movie.matcher.database.data.access.DataAccessObject;
import com.movie.matcher.definitions.ErrorCode;
import com.movie.matcher.definitions.ErrorValidation;
import com.movie.matcher.service.BaseService;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;


/**
 * Created by Ortal on 5/20/2018.
 */
public class CreateUserService extends BaseService{

    private static  Logger LOG =Logger.getLogger(CreateUserService.class);
    private UserBO user;
    private static final String CLASS_NAME = "CreateUserService";

    public CreateUserService(UserBO user) {
        this.user = user;
    }

    public void inputMapping() {

    }

    protected ErrorCode executeImpl() {

        ErrorCode status;
        String methodName = "::executeImpl ";
        DataAccessObject dataAccess = new DataAccessObject();

        LOG.info(CLASS_NAME + methodName + "start.");

        Controller controller = new Controller(dataAccess);
        status = controller.create(user);
        if(ErrorCode.ERROR.equals(status))
        {
            String errorMessage =  " could not create user entry. please check hibernate transaction in the log.";
            LOG.error(CLASS_NAME + methodName + errorMessage +user);
            ErrorValidation errorValidation = new ErrorValidation(ErrorCode.ERROR,errorMessage);
            response= Response.ok(errorValidation).build();
            return  ErrorCode.ERROR;
        }
        LOG.info(CLASS_NAME + methodName + "finished successfully.");

        return ErrorCode.SUCCESS;
    }

    public void outputMappint() {

        response= Response.ok(user).build();
    }
}
