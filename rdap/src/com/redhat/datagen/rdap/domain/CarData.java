package com.redhat.datagen.rdap.domain;

import java.sql.Timestamp;

public final class CarData {

    private final double barometricPressure;
    private final Timestamp date;
    private final double distanceWithMil;
    private final String driversLicNo;
    private final int dtcCount;
    private final int engineRunTime;
    private final int id;
    private final double latitude;
    private final double longitude;
    private final int rpm;
    private final double speed;
    private final double throttlePos;
    private final String vin;

    public CarData( final int id,
                    final String driversLicNo,
                    final String vin,
                    final Timestamp date,
                    final int dtcCount,
                    final double distanceWithMIL,
                    final double speed,
                    final int rpm,
                    final int engineRunTime,
                    final double throttlePos,
                    final double barometricPressure,
                    final double latitude,
                    final double longitude ) {
        this.id = id;
        this.driversLicNo = driversLicNo;
        this.vin = ( ( vin == null ) || vin.isEmpty() ) ? "** unknown **" : vin;
        this.date = date;
        this.dtcCount = dtcCount;
        this.distanceWithMil = distanceWithMIL;
        this.speed = speed;
        this.rpm = rpm;
        this.engineRunTime = engineRunTime;
        this.throttlePos = throttlePos;
        this.barometricPressure = barometricPressure;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getDriversLicNumber() {
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

    public int getRpm() {
        return this.rpm;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getThrottlePosition() {
        return this.throttlePos;
    }

    public String getVin() {
        return this.vin;
    }

}