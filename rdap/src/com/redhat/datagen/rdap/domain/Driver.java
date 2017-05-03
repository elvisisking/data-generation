package com.redhat.datagen.rdap.domain;

public final class Driver {

    private final Address address;
    private final String firstName;
    private final int id;
    private final String lastName;
    private final String licenseNumber;
    private final String phone;
    private final String vin;

    public Driver( final int id,
                   final String firstName,
                   final String lastName,
                   final Address address,
                   final String phone,
                   final String licenseNumber,
                   final String vin ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.vin = ( ( vin == null ) || vin.isEmpty() ) ? "** unknown **" : vin;
    }

    public Address getAddress() {
        return this.address;
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

    public String getPhone() {
        return this.phone;
    }

    public String getVin() {
        return this.vin;
    }

}