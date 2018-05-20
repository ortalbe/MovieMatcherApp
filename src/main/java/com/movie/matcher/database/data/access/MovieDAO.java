package com.movie.matcher.database.data.access;

import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.configuration.hibernate.SessionFactorySingelton;
import com.movie.matcher.definitions.ErrorCode;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * MovieDAO - control all table operation for MOVIE_S table.
 */
public class MovieDAO implements DataAccessObjectInterface<MovieBO> {


    protected SessionFactorySingelton sessionFactory;
    public final static Logger LOG = Logger.getLogger(MovieDAO.class);
    public final static String CLASS_NAME = "MovieDAO";
    private Session session;
    private static final int NUMBER_OF_MOVIES_TO_DISPLAY=20;

    public MovieDAO() {
        openSingeltonSessionFactory();
    }

    public ErrorCode openSingeltonSessionFactory() {

        String methodName ="::openSingeltonSessionFactory ";
        try
        {
            LOG.info(CLASS_NAME + methodName + " open session factory.");
            sessionFactory = SessionFactorySingelton.getInstance();

        }
        catch (Exception exception)
        {
           LOG.error(CLASS_NAME + methodName + " and error occurred while opening session",exception);
           return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;
    }

    public ErrorCode save(MovieBO movieBO) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::save ";
        try
        {

            session.beginTransaction();
            session.save(movieBO);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during save movie : "+ movieBO.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;

    }

    public ErrorCode update(MovieBO movieBO) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::update ";
        try
        {
        session.beginTransaction();
        session.update(movieBO);
        session.getTransaction().commit();
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during update movie : "+ movieBO.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;
    }

    public ErrorCode delete(MovieBO movieBO) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::delete ";
        try
        {
        session.beginTransaction();
        session.delete(movieBO);
        session.getTransaction().commit();
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during delete movie : "+ movieBO.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;
    }

    public MovieBO get(String className, String id) {

        String methodName ="::get ";
        MovieBO movieBO=null;
        try
        {
        session = sessionFactory.getSessionFactory().openSession();
        movieBO= (MovieBO) session.get(className,id);
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during get of movieID:." + id +"\nException :+\n"+  exception);
        }

        return movieBO;
    }

    public SessionFactorySingelton getSessionFactorySingelton() {
        return sessionFactory;
    }


    public MovieBO runQuery(String query) {
        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::SessionFactorySingelton ";
        MovieBO movie=null;
        try
        {
            Query hibernatQuery= session.createQuery(query);
            movie = (MovieBO) hibernatQuery.list();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during query :" + query + ".\nNException:\n" + exception);
        }

            return movie;
    }

    public List<MovieBO> runQueryWithMultiResult(String query) {
        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::runQueryWithMultiResult ";
        List<MovieBO>  movies=null;
        try
        {
            Query hibernatQuery= session.createQuery(query);
            hibernatQuery.setMaxResults(NUMBER_OF_MOVIES_TO_DISPLAY);
             movies = hibernatQuery.list();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during query :" + query + ".\nException:\n" + exception);
        }

        return movies;
    }

}
