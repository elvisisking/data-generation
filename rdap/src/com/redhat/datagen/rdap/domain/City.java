package com.redhat.datagen.rdap.domain;

public final class City {

    private final String postalCode;
    private final String city;
    private final State state;
    private final String county;
    private final double latitude;
    private final double longitude;

    public City( final String postalCode,
                 final String city,
                 final State state,
                 final String county,
                 final double latitude,
                 final double longitude ) {
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.county = county;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return this.city;
    }

    public String getCounty() {
        return this.county;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public State getState() {
        return this.state;
    }

}