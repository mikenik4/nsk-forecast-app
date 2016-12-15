package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root
public class Town {
    @Attribute(name = "sname")
    private String name;//TODO parse name to normal coding
    @ElementList(inline = true, entry = "FORECAST")
    private List<Forecast> forecastList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }
}
