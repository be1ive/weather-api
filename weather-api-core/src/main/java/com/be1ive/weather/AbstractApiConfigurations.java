package com.be1ive.weather;

import com.be1ive.weather.auth.AuthTokenParameterRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public abstract class AbstractApiConfigurations implements ApiConfigurations {

    private final String accessToken;

    private final String parameterName;

    private final RestTemplate restTemplate;

    public AbstractApiConfigurations() {
        this(null, null);
    }

    public AbstractApiConfigurations(String parameterName, String accessToken) {
        this.parameterName = parameterName;
        this.accessToken = accessToken;
        this.restTemplate = createRestTemplate();
        configureRestTemplate(restTemplate);
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

    private RestTemplate createRestTemplate() {
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        RestTemplate template = new RestTemplate(messageConverters);

        ClientHttpRequestInterceptor interceptor = new AuthTokenParameterRequestInterceptor(parameterName, accessToken);
        List<ClientHttpRequestInterceptor> interceptors = new LinkedList<>();
        interceptors.add(interceptor);
        template.setInterceptors(interceptors);

        return template;
    }
}
