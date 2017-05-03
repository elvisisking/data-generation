package com.redhat.datagen.rdap.domain;

public interface TrafficViolation extends Comparable< TrafficViolation > {

    String getDescription();

    int getId();

    int getSeverity();

}