package com.redhat.datagen.rdap.store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.redhat.datagen.rdap.domain.City;
import com.redhat.datagen.rdap.domain.State;

public final class CityStore implements DomainObjectStore {

    private static final CityStore SHARED = new CityStore();

    public static List< City > get( final String citiesFileName ) throws Exception {
        final List< City > cities = new ArrayList<>();
        final List< String > lines = SHARED.load( citiesFileName );

        for ( final String line : lines ) {
            final String tokens[] = line.split( "," );

            final String postalCode = tokens[ 0 ];
            final String city = tokens[ 1 ];
            final String stateName = tokens[ 2 ];
            final String stateAbbreviation = tokens[ 3 ];
            final String county = tokens[ 4 ];
            final double latitude = Double.parseDouble( tokens[ 5 ] );
            final double longitude = Double.parseDouble( tokens[ 6 ] );

            final State state = new State( stateName, stateAbbreviation );
            final City place = new City( postalCode, city, state, county, latitude, longitude );
            cities.add( place );
        }

        return Collections.unmodifiableList( cities );
    }

    /**
     * Don't allow construction outside of this class.
     */
    private CityStore() {
        // nothing to do
    }

}
