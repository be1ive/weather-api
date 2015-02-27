package com.belive.weather;

import com.belive.weather.auth.AuthQueryParameterRequestInterceptor;
import com.belive.weather.auth.AuthUriVariablesRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestInterceptor;

/**  * @author Nikolay Denisenko  * @version 2015/02/16  */
public enum AuthStrategy {

    /**
     * Indicates that the access token should be carried as a query parameter.
     */
    AUTHORIZATION_QUERY_PARAMETER {
        public ClientHttpRequestInterceptor interceptor(String accessToken, String parameterName) {
            return new AuthQueryParameterRequestInterceptor(parameterName, accessToken);
        }
    },

    /**
     * Indicates that the access token should be carried as a uri parameter.
     */
    AUTHORIZATION_URI_PARAMETER {
        public ClientHttpRequestInterceptor interceptor(String accessToken, String parameterName) {
            return new AuthUriVariablesRequestInterceptor(accessToken, parameterName);
        }
    };

    abstract ClientHttpRequestInterceptor interceptor(String accessToken, String parameterName);

}
