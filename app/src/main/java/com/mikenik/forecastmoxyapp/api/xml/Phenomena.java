package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;

public class Phenomena {
    @Attribute
    private String cloudiness;
    @Attribute
    private String precipitation;
    @Attribute
    private String spower;
    @Attribute
    private String rpower;

    public String getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(String cloudiness) {
        this.cloudiness = cloudiness;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getSpower() {
        return spower;
    }

    public void setSpower(String spower) {
        this.spower = spower;
    }

    public String getRpower() {
        return rpower;
    }

    public void setRpower(String rpower) {
        this.rpower = rpower;
    }
}