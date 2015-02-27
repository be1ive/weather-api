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

package com.belive.weather;

import com.belive.weather.auth.AuthQueryParameterRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public abstract class AbstractApiConfigurations implements ApiConfigurations {

    private final String accessToken;

    private final String parameterName;

    private final RestTemplate restTemplate;

    public AbstractApiConfigurations() {
        accessToken = null;
        parameterName = null;
        this.restTemplate = createRestTemplate();
        configureRestTemplate(restTemplate);
    }

    public AbstractApiConfigurations(String accessToken, String parameterName, AuthStrategy authStrategy) {
        this.parameterName = parameterName;
        this.accessToken = accessToken;
        this.restTemplate = createRestTemplate(authStrategy);
        configureRestTemplate(restTemplate);
    }

    public AbstractApiConfigurations(String accessToken, String parameterName) {
        this(parameterName, accessToken, AuthStrategy.AUTHORIZATION_QUERY_PARAMETER);
    }

    public AbstractApiConfigurations(String accessToken) {
        this(accessToken, null, AuthStrategy.AUTHORIZATION_QUERY_PARAMETER);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        restTemplate.setRequestFactory(requestFactory);
    }

    protected void configureRestTemplate(RestTemplate restTemplate) {
    }

    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(getJsonMessageConverter());
        return messageConverters;
    }

    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    private RestTemplate createRestTemplate(AuthStrategy authStrategy) {
        RestTemplate template = createRestTemplate();

        ClientHttpRequestInterceptor interceptor = authStrategy.interceptor(parameterName, accessToken);
        List<ClientHttpRequestInterceptor> interceptors = new LinkedList<>();
        interceptors.add(interceptor);
        template.setInterceptors(interceptors);

        return template;
    }

    private RestTemplate createRestTemplate() {
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        RestTemplate template = new RestTemplate(messageConverters);

        return template;
    }
}
