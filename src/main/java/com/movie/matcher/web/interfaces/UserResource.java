package com.movie.matcher.web.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 * UserResource - reflact all rest resources related to Users
 */

@Path("/user")
public interface UserResource {


    @POST
    @Path("/create_user")
    String createUser();

    @GET
    @Path("/get_user_by_id")
    String getUserById(String id);

    @PUT
    @Path("/update_user")
    String updateUser();

}
