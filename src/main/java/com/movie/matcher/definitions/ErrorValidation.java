package com.movie.matcher.definitions;

import javax.xml.bind.annotation.*;

/**
 * ErrorValidation - will be send to rest respinse in case of an error
 */

@XmlRootElement
@XmlType(propOrder={"errorCode","errorMessage"})
public class ErrorValidation {

    private ErrorCode errorCode;
    private String errorMessage;

    public ErrorValidation(ErrorCode errorcode, String errorMessage) {
        this.errorCode = errorcode;
        this.errorMessage = errorMessage;
    }

    @XmlElement
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
