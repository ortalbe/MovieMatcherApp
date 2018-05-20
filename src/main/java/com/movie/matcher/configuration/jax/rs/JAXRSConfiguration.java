package com.movie.matcher.configuration.jax.rs;


import com.movie.matcher.web.services.movie.MovieAdapterWebService;
import com.movie.matcher.web.services.user.UserAdapterWebService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * JAX-RS configuration - reflect JAXRS all class to look in
 */
@ApplicationPath("/MovieMatcherApp")
public class JAXRSConfiguration extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();

        h.add( UserAdapterWebService.class );
        h.add( MovieAdapterWebService.class );

        return h;
    }
}
