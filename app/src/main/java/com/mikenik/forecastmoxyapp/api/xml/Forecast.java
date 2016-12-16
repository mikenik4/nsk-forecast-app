package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root
public class Forecast implements Serializable {
    private static final long serialVersionUID = -4677432683795573969L;
    @Attribute
    private String day;
    @Attribute
    private String month;
    @Attribute
    private String year;
    @Attribute
    private String hour;
    @Attribute
    private String tod;
    @Attribute
    private String predict;
    @Attribute
    private String weekday;

    @Element(name = "PHENOMENA")
    private Phenomena phenomena;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTod() {
        return tod;
    }

    public void setTod(String tod) {
        this.tod = tod;
    }

    public String getPredict() {
        return predict;
    }

    public void setPredict(String predict) {
        this.predict = predict;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public Phenomena getPhenomena() {
        return phenomena;
    }

    public void setPhenomena(Phenomena phenomena) {
        this.phenomena = phenomena;
    }
}
