package com.github.kayropereira.citiesofBrasilapi.utils;

import org.springframework.data.geo.Point;

public class StringLocationUtils {
    public static Double[] transform(String geolocation) {
        String result = geolocation.replace("(", "").replace(")", "");
        String[] strings = result.trim().split(",");
        return new Double[] {Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }

    public static Double[] transform(Point geolocation) {
        return new Double[] {geolocation.getX(), geolocation.getY()};
    }
}