package com.redhat.datagen.rdap.domain;

public final class Address {

    private final String line1;
    private final City city;

    public Address( final String line1,
                    final City city ) {
        this.line1 = line1;
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

    public String getLine1() {
        return this.line1;
    }

}