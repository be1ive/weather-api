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
package com.be1ive.weather.support;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Builds up a URI from individual URI components. Ensures that query parameters are application/x-www-form-urlencoded.
 * @author Craig Walls
 */
public class URIBuilder {

    private final String baseUri;

    private MultiValueMap<String, String> parameters;

    private URIBuilder(String baseUri) {
        this.baseUri = baseUri;
        parameters = new LinkedMultiValueMap<String, String>();
    }

    /**
     * Creates a URIBuilder with a base URI string as the starting point
     * @param baseUri a String URI to use as a starting point for the builder
     * @return the URIBuilder
     */
    public static URIBuilder fromUri(String baseUri) {
        return new URIBuilder(baseUri);
    }

    /**
     * Creates a URIBuilder with a base URI string as the starting point
     * @param baseUri a URI to use as a starting point for the builder
     * @return the URIBuilder
     */
    public static URIBuilder fromUri(URI baseUri) {
        return new URIBuilder(baseUri.toString());
    }

    /**
     * Adds a query parameter to the URI
     * @param name the parameter name
     * @param value the parameter value
     * @return the URIBuilder
     */
    public URIBuilder queryParam(String name, String value) {
        parameters.add(name, value);
        return this;
    }

    /**
     * Adds a query parameters to the URI
     * @param params a Map of parameters to add the the URI
     * @return the URIBuilder
     */
    public URIBuilder queryParams(MultiValueMap<String, String> params) {
        parameters.putAll(params);
        return this;
    }

    /**
     * Builds the URI
     * @return the URI
     */
    public URI build() {
        try {
            StringBuilder builder = new StringBuilder();
            Set<Map.Entry<String, List<String>>> entrySet = parameters.entrySet();
            for (Iterator<Map.Entry<String, List<String>>> entryIt = entrySet.iterator(); entryIt.hasNext();) {
                Map.Entry<String, List<String>> entry = entryIt.next();
                String name = entry.getKey();
                List<String> values = entry.getValue();
                for(Iterator<String> valueIt = values.iterator(); valueIt.hasNext();) {
                    String value = valueIt.next();
                    builder.append(formEncode(name)).append("=");
                    if(value != null) {
                        builder.append(formEncode(value));
                    }
                    if(valueIt.hasNext()) {
                        builder.append("&");
                    }
                }
                if(entryIt.hasNext()) {
                    builder.append("&");
                }
            }

            String queryDelimiter = "?";
            if(URI.create(baseUri).getQuery() != null) {
                queryDelimiter = "&";
            }
            return new URI(baseUri + (builder.length() > 0 ? queryDelimiter + builder.toString() : ""));
        } catch (URISyntaxException e) {
            throw new URIBuilderException("Unable to build URI: Bad URI syntax", e);
        }
    }

    private String formEncode(String data) {
        try {
            return URLEncoder.encode(data, "UTF-8");
        }
        catch (UnsupportedEncodingException wontHappen) {
            throw new IllegalStateException(wontHappen);
        }
    }
}
