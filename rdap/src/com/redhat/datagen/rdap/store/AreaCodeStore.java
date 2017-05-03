package com.redhat.datagen.rdap.store;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public final class AreaCodeStore implements DomainObjectStore {

    public static Map< String, List< Integer > > getAreaCodes( final String areaCodesFileName ) throws Exception {
        final Map< String, List< Integer > > result = new HashMap<>();
        final Path input = Paths.get( areaCodesFileName );

        try ( final InputStream stream = Files.newInputStream( input ) ) {
            final Properties props = new Properties();
            props.load( stream );

            for ( final String key : props.stringPropertyNames() ) {
                final String[] value = props.getProperty( key ).split( "," );
                final List< Integer > areaCodes = new ArrayList<>( value.length );

                for ( final String areaCodeAsString : value ) {
                    areaCodes.add( Integer.parseInt( areaCodeAsString ) );
                }

                result.put( key, Collections.unmodifiableList( areaCodes ) );
            }
        }

        return Collections.unmodifiableMap( result );
    }

    /**
     * Don't allow construction outside of this class.
     */
    private AreaCodeStore() {
        // nothing to do
    }
}
