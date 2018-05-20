package com.movie.matcher.definitions;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ErrorCode enum - represent all available error code in the system.
 */

@XmlRootElement
public enum ErrorCode{

    SUCCESS("Success"),
    ERROR("Error"),
    NOT_FOUND("Not Found"),
    WARNING("Warnning");

    private final String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}



