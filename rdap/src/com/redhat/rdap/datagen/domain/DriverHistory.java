package com.redhat.rdap.datagen.domain;

import java.sql.Timestamp;

public final class DriverHistory {

    private final Timestamp date;
    private final String description;
    private final String firstName;
    private final int id;
    private final String lastName;
    private final String licenseNumber;
    private final int severity;
    private final String vin;

    public DriverHistory( final int id,
                          final Timestamp date,
                          final String firstName,
                          final String lastName,
                          final String licenseNumber,
                          final String vin,
                          final String description,
                          final int severity ) {
        this.id = id;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.vin = ( ( vin == null ) || vin.isEmpty() ) ? "** unknown **" : vin;
        this.description = description;
        this.severity = severity;
    }

    public Timestamp getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public int getSeverity() {
        return this.severity;
    }

    public String getVin() {
        return this.vin;
    }

}