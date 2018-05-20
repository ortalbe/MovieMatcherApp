package com.movie.matcher.web.services.user;

import com.movie.matcher.bean.UserBO;
import com.movie.matcher.definitions.ErrorCode;
import com.movie.matcher.service.user.CreateUserService;
import com.movie.matcher.service.user.GetUserByIDService;
import com.movie.matcher.service.user.UpdateUserService;
import com.movie.matcher.web.interfaces.UserResource;

import javax.ws.rs.core.Response;

/**
 * UserAdapterWebService - implmentation of all users resources
 */

//TODO_Ortal - understand how to seprate it to a few class each method in a different class.
public class UserAdapterWebService implements UserResource {

    public Response createUser(UserBO user) {
        CreateUserService service = new CreateUserService(user);
        ErrorCode status = service.execute();
        return service.getResponse();
    }

    public Response getUserById(String id) {
        GetUserByIDService service = new GetUserByIDService(id);
        ErrorCode status = service.execute();
        return service.getResponse();
    }

    public Response updateUser(UserBO user) {
        UpdateUserService service = new UpdateUserService(user);
        ErrorCode status = service.execute();
        return service.getResponse();
    }
}
