/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.belive.weather.auth;

import com.belive.weather.support.URIBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;
import java.net.URI;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
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
