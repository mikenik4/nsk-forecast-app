package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

/**
 * Created by mikenik4 on 16.12.2016.
 */

public class IntRange implements Serializable {
    private static final long serialVersionUID = 7279994443540211892L;
    @Attribute
    private int min;
    @Attribute
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getMean() {
        return (min + max) / 2f;
    }

    public int getRoundedMean() {
        return Math.round(getMean());
    }
}
