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

package com.belive.weather.fio.api;

import java.util.List;

/**
 * @author Nikolay Denisenko
 * @version 2015/02/16
 */
public class Weather<T extends AbstractWeatherPoint> {

    private final String summary;

    private final String icon;

    private final List<T> data;

    public Weather(String summary, String icon, List<T> data) {
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    //A human-readable text summary of this data block.
    public String getSummary() {
        return summary;
    }

    //A machine-readable text summary of this data block (see data point, above, for an enumeration of possible values that this property may take on).
    public String getIcon() {
        return icon;
    }

    //An array of data point objects (see above), ordered by time, which together describe the weather conditions at the requested location over time.
    public List<T> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", data=" + data +
                '}';
    }
}
