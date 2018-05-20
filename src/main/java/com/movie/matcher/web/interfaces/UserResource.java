package com.movie.matcher.web.interfaces;

import com.movie.matcher.bean.UserBO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * UserResource - reflact all rest resources related to Users
 */

@Path("/user")
public interface UserResource {


    @POST
    @Path("/create_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createUser(UserBO user);

    @GET
    @Path("/get_user_by_id")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUserById(@QueryParam("id") String id);

    @PUT
    @Path("/update_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateUser(UserBO user);

}
