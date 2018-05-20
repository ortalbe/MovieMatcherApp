package com.movie.matcher.bean;

import com.movie.matcher.definitions.Gender;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.ext.ParamConverter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * UserBO POJO
 */

@Entity
@Table(name="APP_USERS")
@XmlRootElement
@ParamConverter.Lazy
public class UserBO extends BusinessObject {

    @Id
    @Column(name="USER_ID")
    private String userID;

    @Column(name="USER_FIRST_NAME")
    private String userFirstName;

    @Column(name="USER_LAST_NAME")
    private String userLastName;

    @Column(name="USER_PASSWORD")
    private String userPassword;

    @Column(name="USER_EMAIL")
    private String userEmail;


    //TODO_Ortal - need to understand how to save it in the DB as gender
    @Enumerated(EnumType.STRING)
    private Gender userGender;

    @Column(name="USER_AGE")
    private float userAge;


    public UserBO() {
        this.userID = null;
    }

    public UserBO(String userID) {
        this.userID = userID;
    }

    public UserBO(String userFirstName, String userLastName, String userPassword, String userEmail) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.setName(this.getClass().getName());
    }

    public UserBO(String userFirstName, String userLastName, String userPassword, String userEmail, Gender userGender) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.setName(this.getClass().getName());
    }

    public UserBO(String userFirstName, String userLastName, String userPassword, String userEmail, Gender userGender, float userAge) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userAge = userAge;
        this.setName(this.getClass().getName());
    }


    public UserBO(String userID, String userFirstName, String userLastName, String userPassword, String userEmail, Gender userGender, float userAge) {
        this.userID = userID;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userAge = userAge;
        this.setName(this.getClass().getName());
    }

    @XmlElement
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @XmlElement
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @XmlElement
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @XmlElement
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlElement
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @XmlElement
    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    @XmlElement
    public float getUserAge() {
        return userAge;
    }

    public void setUserAge(float userAge) {
        this.userAge = userAge;
    }
}
