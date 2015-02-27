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
package com.belive.weather.support;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URIBuilder {

    private static final Pattern URI_PARAM_PATTERN = Pattern.compile("\\$([^/]+?)\\$");

    private final String baseUri;

    private MultiValueMap<String, String> queryParameters;
    private MultiValueMap<String, String> uriParameters;

    private URIBuilder(String baseUri) {
        this.baseUri = baseUri;
        queryParameters = new LinkedMultiValueMap<>();
        uriParameters = new LinkedMultiValueMap<>();
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
     * Adds a uri parameters to the URI
     * @param name the parameter name
     * @param value the parameter value
     * @return the URIBuilder
     */
    public URIBuilder uriParameter(String name, String value) {
        uriParameters.add(name, value);
        return this;
    }

    /**
     * Adds a uri parameters to the URI
     * @param params a Map of uriParameters to add the the URI
     * @return the URIBuilder
     */
    public URIBuilder uriParameters(MultiValueMap<String, String> params) {
        uriParameters.putAll(params);
        return this;
    }

    /**
     * Adds a query parameter to the URI
     * @param name the parameter name
     * @param value the parameter value
     * @return the URIBuilder
     */
    public URIBuilder queryParam(String name, String value) {
        queryParameters.add(name, value);
        return this;
    }

    /**
     * Adds a query queryParameters to the URI
     * @param params a Map of queryParameters to add the the URI
     * @return the URIBuilder
     */
    public URIBuilder queryParams(MultiValueMap<String, String> params) {
        queryParameters.putAll(params);
        return this;
    }

    /**
     * Builds the URI
     * @return the URI
     */
    public URI build() {
        URI uri = applyUriParams(baseUri.toString());
        uri = applyQueryParams(uri.toString());
        return uri;
    }

    private URI applyQueryParams(String url) {
        try {
            StringBuffer sb = new StringBuffer();
            Set<Map.Entry<String, List<String>>> entrySet = queryParameters.entrySet();
            for (Iterator<Map.Entry<String, List<String>>> entryIt = entrySet.iterator(); entryIt.hasNext();) {
                Map.Entry<String, List<String>> entry = entryIt.next();
                String name = entry.getKey();
                List<String> values = entry.getValue();
                for(Iterator<String> valueIt = values.iterator(); valueIt.hasNext();) {
                    String value = valueIt.next();
                    sb.append(formEncode(name)).append("=");
                    if(value != null) {
                        sb.append(formEncode(value));
                    }
                    if(valueIt.hasNext()) {
                        sb.append("&");
                    }
                }
                if(entryIt.hasNext()) {
                    sb.append("&");
                }
            }

            String queryDelimiter = "?";
            if(URI.create(url).getQuery() != null) {
                queryDelimiter = "&";
            }

            return new URI(url + (sb.length() > 0 ? queryDelimiter + sb.toString() : ""));

        } catch (URISyntaxException e) {
            throw new URIBuilderException("Unable to build URI: Bad URI syntax", e);
        }
    }

    private URI applyUriParams(String url) {
        try {
            if (url.indexOf('$') != -1) {
                StringBuffer uri = new StringBuffer();

                Matcher matcher = URI_PARAM_PATTERN.matcher(url);

                while (matcher.find()) {
                    String name = matcher.group(1);
                    List<String> values = uriParameters.get(name);
                    if (values != null) {
                        StringBuffer sb = new StringBuffer();
                        for (Iterator<String> valueIt = values.iterator(); valueIt.hasNext(); ) {
                            String value = valueIt.next();
                            if (value != null) {
                                sb.append(formEncode(value));
                            }
                            if (valueIt.hasNext()) {
                                sb.append(",");
                            }
                        }

                        String replacement = Matcher.quoteReplacement(sb.toString());
                        matcher.appendReplacement(uri, replacement);
                    }
                }
                matcher.appendTail(uri);

                return new URI(uri.toString());
            }

            return new URI(url);
        } catch (URISyntaxException e) {
            throw new URIBuilderException("Unable to build URI: Bad URI syntax", e);
        }
    }

    private String formEncode(String data) {
        try {
            return URLEncoder.encode(data, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
