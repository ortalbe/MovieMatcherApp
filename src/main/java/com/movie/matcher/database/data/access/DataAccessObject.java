package com.movie.matcher.database.data.access;

import com.movie.matcher.bean.BusinessObject;
import com.movie.matcher.bean.MovieBO;
import com.movie.matcher.configuration.hibernate.SessionFactorySingelton;
import com.movie.matcher.definitions.ErrorCode;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * DataAccessObject - control all table operation for MOVIE_S table.
 */
public class DataAccessObject implements DataAccessObjectInterface<BusinessObject> {


    protected SessionFactorySingelton sessionFactory;
    public final static Logger LOG = Logger.getLogger(DataAccessObject.class);
    public final static String CLASS_NAME = "DataAccessObject";
    private Session session;
    private static final int NUMBER_OF_MOVIES_TO_DISPLAY=20;

    public DataAccessObject() {
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

    public ErrorCode save(BusinessObject businessObject) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::save ";
        try
        {

            session.beginTransaction();
            session.save(businessObject);
            session.getTransaction().commit();
            session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during save movie : "+ businessObject.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;

    }

    public ErrorCode update(BusinessObject businessObject) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::update ";
        try
        {
        session.beginTransaction();
        session.update(businessObject);
        session.getTransaction().commit();
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during update movie : "+ businessObject.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;
    }

    public ErrorCode delete(BusinessObject businessObject) {

        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::delete ";
        try
        {
        session.beginTransaction();
        session.delete(businessObject);
        session.getTransaction().commit();
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during delete movie : "+ businessObject.toString()
                    + "\nException:\n" + exception);
            return ErrorCode.ERROR;
        }

        return ErrorCode.SUCCESS;
    }

    public BusinessObject get(String className, String id) {

        String methodName ="::get ";
        BusinessObject businessObject=null;
        try
        {
        session = sessionFactory.getSessionFactory().openSession();
        businessObject= (BusinessObject)  session.get(className,id);
        session.close();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during get of movieID:." + id +"\nException :+\n"+  exception);
        }

        return businessObject;
    }

    public SessionFactorySingelton getSessionFactorySingelton() {
        return sessionFactory;
    }


    public BusinessObject runQuery(String query) {
        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::SessionFactorySingelton ";
        BusinessObject businessObject=null;
        try
        {
            Query hibernatQuery= session.createQuery(query);
            businessObject = (MovieBO) hibernatQuery.list();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during query :" + query + ".\nNException:\n" + exception);
        }

            return businessObject;
    }

    public List<BusinessObject> runQueryWithMultiResult(String query) {
        session = sessionFactory.getSessionFactory().openSession();
        String methodName ="::runQueryWithMultiResult ";
        List<BusinessObject>  businessObject=null;
        try
        {
            Query hibernatQuery= session.createQuery(query);
            hibernatQuery.setMaxResults(NUMBER_OF_MOVIES_TO_DISPLAY);
            businessObject = hibernatQuery.list();
        }
        catch (Exception exception)
        {
            LOG.error(CLASS_NAME + methodName + "an error occurred during query :" + query + ".\nException:\n" + exception);
        }

        return businessObject;
    }

}
