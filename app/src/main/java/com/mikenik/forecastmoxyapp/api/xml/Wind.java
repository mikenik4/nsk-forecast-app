package com.mikenik.forecastmoxyapp.api.xml;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

/**
 * Created by mikenik4 on 16.12.2016.
 */

public class Wind extends IntRange implements Serializable {
    private static final long serialVersionUID = -5107428753270167212L;

    public static int DIRECTION_NORTH = 0;
    public static int DIRECTION_NORTH_EAST = 1;
    public static int DIRECTION_EAST = 2;
    public static int DIRECTION_SOUTH_EAST = 3;
    public static int DIRECTION_SOUTH = 4;
    public static int DIRECTION_SOUTH_WEST = 5;
    public static int DIRECTION_WEST = 6;
    public static int DIRECTION_NORTH_WEST = 7;

    @Attribute
    private int direction;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
