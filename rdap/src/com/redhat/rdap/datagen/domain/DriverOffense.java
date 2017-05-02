package com.redhat.rdap.datagen.domain;

import java.sql.Timestamp;
import java.util.Objects;

public final class DriverOffense implements Comparable< DriverOffense > {

    private final Timestamp date;
    private final int driverId;
    private final int id;
    private final int violationId;

    public DriverOffense( final int id,
                          final Timestamp date,
                          final int driverId,
                          final int violationId ) {
        this.id = id;
        this.date = date;
        this.driverId = driverId;
        this.violationId = violationId;
    }

    @Override
    public int compareTo( final DriverOffense that ) {
        return Integer.compare( this.id, that.id );
    }

    @Override
    public boolean equals( final Object that ) {
        if ( ( that == null ) || !( that instanceof DriverOffense ) ) {
            return false;
        }

        return ( this.id == ( ( DriverOffense ) that ).id );
    }

    public Timestamp getDate() {
        return this.date;
    }

    public int getDriverId() {
        return this.driverId;
    }

    public int getId() {
        return this.id;
    }

    public int getViolationId() {
        return this.violationId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( this.id );
    }

}
