package com.be1ive.weather;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 14.02.2015.
 */
public abstract class AbstractApiConfigurations implements ApiConfigurations {

    private final String accessToken;

    private final RestTemplate restTemplate;

    public AbstractApiConfigurations() {
        this(null);
    }

    public AbstractApiConfigurations(String accessToken) {
        this.accessToken = accessToken;
        restTemplate = createRestTemplate();
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
        RestTemplate template;
        List<HttpMessageConverter<?>> messageConverters = getMessageConverters();
        try {
            template = new RestTemplate(messageConverters);
        } catch (NoSuchMethodError e) {
            template = new RestTemplate();
            template.setMessageConverters(messageConverters);
        }
        return template;
    }
}
