package com.be1ive.weather;

/**
 * Created by Nikolay on 14.02.2015.
 */
@SuppressWarnings("serial")
public class UncategorizedApiException extends ApiException {

    public UncategorizedApiException(String message) {
        super(message);
    }

    public UncategorizedApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
