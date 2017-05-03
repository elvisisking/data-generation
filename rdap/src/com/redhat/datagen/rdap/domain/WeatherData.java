package com.redhat.datagen.rdap.domain;

import java.sql.Timestamp;

public final class WeatherData {

    public enum PrecipType {

        NONE,
        RAIN,
        SLEET,
        SNOW

    }

    private final Timestamp date;
    private final int id;
    private final double latitude;
    private final double longitude;
    private final double precipIntensity; // inches per hour
    private final WeatherData.PrecipType precipType;
    private final int routeId;
    private final int windSpeed; // mph

    public WeatherData( final int id,
                        final int routeId,
                        final Timestamp date,
                        final double latitude,
                        final double longitude,
                        final double precipIntensity,
                        final WeatherData.PrecipType precipType,
                        final int windSpeed ) {
        this.id = id;
        this.routeId = routeId;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precipIntensity = precipIntensity;
        this.precipType = precipType;
        this.windSpeed = windSpeed;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public int getId() {
        return this.id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getPrecipIntensity() {
        return this.precipIntensity;
    }

    public WeatherData.PrecipType getPrecipType() {
        return this.precipType;
    }

    public int getRouteId() {
        return this.routeId;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

}