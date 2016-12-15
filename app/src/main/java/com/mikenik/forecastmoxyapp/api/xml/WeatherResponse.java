package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root
public class WeatherResponse {
    @Element(name = "TOWN")
    @Path("REPORT")
    private Town town;

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
