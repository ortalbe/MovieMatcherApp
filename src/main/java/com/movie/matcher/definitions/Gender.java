package com.movie.matcher.definitions;

/**
 * Gender definition
 */
public class Gender {

    private String value;
    public static Gender FEMALE = new Gender("female");
    public static Gender MEN = new Gender("men");

    private Gender(String value) {
        this.value = value;
    }

    public String getValue ()
    {
        return value;
    }

}
