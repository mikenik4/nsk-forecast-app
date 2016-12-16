package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Phenomena implements Serializable {
    private static final long serialVersionUID = -5463108276507002583L;
    @Attribute
    private int cloudiness;
    @Attribute
    private int precipitation;
    @Attribute
    private int spower;
    @Attribute
    private int rpower;

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public int getSpower() {
        return spower;
    }

    public void setSpower(int spower) {
        this.spower = spower;
    }

    public int getRpower() {
        return rpower;
    }

    public void setRpower(int rpower) {
        this.rpower = rpower;
    }
}
