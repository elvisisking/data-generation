package com.redhat.rdap.datagen.domain;

public interface TrafficViolation extends Comparable< TrafficViolation > {

    String getDescription();

    int getId();

    int getSeverity();

}