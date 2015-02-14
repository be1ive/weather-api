package com.be1ive.weather;

/**
 * Created by Nikolay on 14.02.2015.
 */
@SuppressWarnings("serial")
public abstract class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
