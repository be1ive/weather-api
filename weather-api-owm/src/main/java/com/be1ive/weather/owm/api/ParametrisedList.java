package com.be1ive.weather.owm.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 15.02.2015.
 */
public class ParametrisedList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 1L;

    private final Map<String, String> params;

    public ParametrisedList(List<T> list, Map<String, String> params) {
        super(list);
        this.params = Collections.unmodifiableMap(params);
    }

    public Map<String, String> getParams() {
        return params;
    }
}