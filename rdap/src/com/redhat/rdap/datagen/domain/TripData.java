package com.redhat.rdap.datagen.domain;

import java.sql.Timestamp;

import com.redhat.rdap.datagen.domain.WeatherData.PrecipType;

public final class TripData {

    private final double barometricPressure;
    private final Timestamp date;
    private final double distanceWithMil;
    private final String driversLicNo;
    private final int dtcCount;
    private final int engineRunTime;
    private final int id;
    private final double latitude;
    private final double longitude;
    private final double precipIntensity; // inches per hour
    private final WeatherData.PrecipType precipType;
    private final int routeId;
    private final int rpm;
    private final double speed;
    private final double throttlePos;
    private final String vin;
    private final int windSpeed; // mph

    public TripData( final double barometricPressure,
                     final Timestamp date,
                     final double distanceWithMil,
                     final String driversLicNo,
                     final int dtcCount,
                     final int engineRunTime,
                     final int id,
                     final double latitude,
                     final double longitude,
                     final double precipIntensity,
                     final PrecipType precipType,
                     final int routeId,
                     final int rpm,
                     final double speed,
                     final double throttlePos,
                     final String vin,
                     final int windSpeed ) {
        this.barometricPressure = barometricPressure;
        this.date = date;
        this.distanceWithMil = distanceWithMil;
        this.driversLicNo = driversLicNo;
        this.dtcCount = dtcCount;
        this.engineRunTime = engineRunTime;
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precipIntensity = precipIntensity;
        this.precipType = precipType;
        this.routeId = routeId;
        this.rpm = rpm;
        this.speed = speed;
        this.throttlePos = throttlePos;
        this.vin = vin;
        this.windSpeed = windSpeed;
    }

    public double getBarometricPressure() {
        return this.barometricPressure;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public double getDistanceWithMil() {
        return this.distanceWithMil;
    }

    public String getDriversLicNo() {
        return this.driversLicNo;
    }

    public int getDtcCount() {
        return this.dtcCount;
    }

    public int getEngineRunTime() {
        return this.engineRunTime;
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

    public int getRpm() {
        return this.rpm;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getThrottlePos() {
        return this.throttlePos;
    }

    public String getVin() {
        return this.vin;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

}
