package com.redhat.rdap.datagen.domain;

import java.util.Objects;

public final class State implements Comparable< State > {

    private final String abbreviation;
    private final String name;

    public State( final String name,
                  final String abbreviation ) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    @Override
    public int compareTo( final State that ) {
        return this.abbreviation.compareTo( that.abbreviation );
    }

    @Override
    public boolean equals( final Object obj ) {
        if ( ( obj == null ) || !getClass().equals( obj.getClass() ) ) {
            return false;
        }

        final State that = ( State ) obj;
        return ( Objects.equals( this.abbreviation, that.abbreviation ) && Objects.equals( this.name, that.name ) );
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.abbreviation, this.name );
    }

    @Override
    public String toString() {
        return ( "State: name = " + this.name + ", abbreviation = " + this.abbreviation );
    }

}