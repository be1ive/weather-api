package com.be1ive.weather.auth;

import com.be1ive.weather.support.URIBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Nikolay on 14.02.2015.
 */
public class AuthTokenParameterRequestInterceptor implements ClientHttpRequestInterceptor {

    private final String parameterName;

    private final String accessToken;

    public AuthTokenParameterRequestInterceptor(String parameterName, String accessToken) {
        this.parameterName = parameterName;
        this.accessToken = accessToken;
    }

    public AuthTokenParameterRequestInterceptor(String accessToken) {
        this("access_token", accessToken);
    }

    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper protectedResourceRequest = new HttpRequestWrapper(request){

            @Override
            public URI getURI() {
                return URIBuilder.fromUri(super.getURI()).queryParam(parameterName, accessToken).build();
            }

        };
        return execution.execute(protectedResourceRequest, body);
    }
}
