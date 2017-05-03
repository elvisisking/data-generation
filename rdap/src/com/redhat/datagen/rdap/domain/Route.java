package com.redhat.datagen.rdap.domain;

import java.util.Objects;

public final class Route implements Comparable< Route > {

    private final int driverId;
    private final int id;
    private final String name;

    public Route( final int id,
                  final String name,
                  final int driverId ) {
        this.id = id;
        this.name = name;
        this.driverId = driverId;
    }

    @Override
    public int compareTo( final Route that ) {
        return Integer.compare( this.id, that.id );
    }

    @Override
    public boolean equals( final Object that ) {
        if ( ( that == null ) || !( that instanceof Route ) ) {
            return false;
        }

        return ( this.id == ( ( Route ) that ).id );
    }

    public int getDriverId() {
        return this.driverId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode( this.id );
    }

}
