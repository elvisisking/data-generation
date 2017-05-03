package com.redhat.datagen.rdap;

import java.util.List;
import java.util.Map;

import com.redhat.datagen.rdap.domain.City;
import com.redhat.datagen.rdap.domain.TrafficViolation;
import com.redhat.datagen.rdap.store.AreaCodeStore;
import com.redhat.datagen.rdap.store.CityStore;
import com.redhat.datagen.rdap.store.ItemStore;
import com.redhat.datagen.rdap.store.TrafficViolationStore;

public final class RdapDataProvider {

    private static Map< String, List< Integer > > _areaCodes; // key is the state abbreviation
    private static List< City > _cities;
    private static List< String > _femaleNames;
    private static List< String > _lastNames;
    private static List< String > _maleNames;
    private static List< String > _streets;
    private static List< String > _streetSuffixes;
    private static List< TrafficViolation > _violations;

    private static final String RESOURCES_FOLDER = "resources/";
    private static final String AREA_CODES_FILE = RESOURCES_FOLDER + "area_codes.properties";
    public static final String CAR_DATA_FOLDER = RESOURCES_FOLDER + "car_data/";
    private static final String CITIES_FILE = RESOURCES_FOLDER + "us_postal_codes.csv";
    private static final String FEMALE_NAMES_FILE = RESOURCES_FOLDER + "female_names.txt";
    private static final String LAST_NAMES_FILE = RESOURCES_FOLDER + "last_names.txt";
    private static final String MALE_NAMES_FILE = RESOURCES_FOLDER + "male_names.txt";
    private static final String STREET_SUFFIXES_FILE = RESOURCES_FOLDER + "street_suffixes.txt";
    private static final String STREETS_FILE = RESOURCES_FOLDER + "streets.txt";
    private static final String VIOLATIONS_FILE = RESOURCES_FOLDER + "violations.csv";

    public static List< Integer > getAreaCodes( final String stateAbbreviation ) throws Exception {
        if ( _areaCodes == null ) {
            _areaCodes = AreaCodeStore.getAreaCodes( AREA_CODES_FILE );
        }

        return _areaCodes.get( stateAbbreviation );
    }

    public static List< City > getCities() throws Exception {
        if ( _cities == null ) {
            _cities = CityStore.get( CITIES_FILE );
        }

        return _cities;
    }

    public static List< String > getFemaleNames() throws Exception {
        if ( _femaleNames == null ) {
            _femaleNames = ItemStore.getItems( FEMALE_NAMES_FILE );
        }

        return _femaleNames;
    }

    public static List< String > getLastNames() throws Exception {
        if ( _lastNames == null ) {
            _lastNames = ItemStore.getItems( LAST_NAMES_FILE );
        }

        return _lastNames;
    }

    public static List< String > getMaleNames() throws Exception {
        if ( _maleNames == null ) {
            _maleNames = ItemStore.getItems( MALE_NAMES_FILE );
        }

        return _maleNames;
    }

    public static List< String > getStreets() throws Exception {
        if ( _streets == null ) {
            _streets = ItemStore.getItems( STREETS_FILE );
        }

        return _streets;
    }

    public static List< String > getStreetSuffixes() throws Exception {
        if ( _streetSuffixes == null ) {
            _streetSuffixes = ItemStore.getItems( STREET_SUFFIXES_FILE );
        }

        return _streetSuffixes;
    }

    public static List< TrafficViolation > getTrafficViolations() throws Exception {
        if ( _violations == null ) {
            _violations = TrafficViolationStore.get( VIOLATIONS_FILE );
        }

        return _violations;
    }

    /**
     * Don't allow construction outside this class.
     */
    private RdapDataProvider() {
        // nothing to do
    }
}
