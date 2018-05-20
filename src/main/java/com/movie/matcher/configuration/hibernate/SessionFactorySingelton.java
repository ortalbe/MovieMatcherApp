package com.movie.matcher.configuration.hibernate;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * SessionFactorySingelton - for the entire app we will have only one sessionFactory to the data base.
 */
public class SessionFactorySingelton {

    private static SessionFactorySingelton sessionFactoryInstance = null;
    private SessionFactory sessionFactory = null;
    private final static String CLASS_NAME = "SessionFactorySingelton" ;
    private final static Logger LOG = Logger.getLogger(SessionFactorySingelton.class);

    private  SessionFactorySingelton() {
        String methodName = "::SessionFactorySingelton ";
        LOG.info(CLASS_NAME + methodName + " session factory not initialized yet. initialize session");
        sessionFactory =  new Configuration().configure().buildSessionFactory();
           }

    public synchronized static SessionFactorySingelton getInstance ()
    {
        if (sessionFactoryInstance ==null)
            sessionFactoryInstance = new SessionFactorySingelton();

        return sessionFactoryInstance;

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
