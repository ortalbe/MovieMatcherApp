package com.movie.matcher.web.services.user;

import com.movie.matcher.web.interfaces.UserResource;

/**
 * UserAdapterWebService - implmentation of all users resources
 */

//TODO_Ortal - understand how to seprate it to a few class each method in a different class.
public class UserAdapterWebService implements UserResource {
    public String createUser() {
        return "createUser";
    }

    public String getUserById(String id) {
        return "getUserById";
    }

    public String updateUser() {
        return "updateUser";
    }
}
