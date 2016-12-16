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
    private int tod;
    @Attribute
    private int predict;
    @Attribute
    private int weekday;

    @Element(name = "PHENOMENA")
    private Phenomena phenomena;
    @Element(name = "PRESSURE")
    private IntRange pressure;
    @Element(name = "TEMPERATURE")
    private IntRange temperature;
    @Element(name = "WIND")
    private Wind wind;
    @Element(name = "RELWET")
    private IntRange relwet;
    @Element(name = "HEAT")
    private IntRange heat;

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

    public int getTod() {
        return tod;
    }

    public void setTod(int tod) {
        this.tod = tod;
    }

    public int getPredict() {
        return predict;
    }

    public void setPredict(int predict) {
        this.predict = predict;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public Phenomena getPhenomena() {
        return phenomena;
    }

    public void setPhenomena(Phenomena phenomena) {
        this.phenomena = phenomena;
    }

    public IntRange getPressure() {
        return pressure;
    }

    public void setPressure(IntRange pressure) {
        this.pressure = pressure;
    }

    public IntRange getTemperature() {
        return temperature;
    }

    public void setTemperature(IntRange temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public IntRange getRelwet() {
        return relwet;
    }

    public void setRelwet(IntRange relwet) {
        this.relwet = relwet;
    }

    public IntRange getHeat() {
        return heat;
    }

    public void setHeat(IntRange heat) {
        this.heat = heat;
    }
}
