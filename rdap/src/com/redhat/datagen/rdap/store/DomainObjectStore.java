package com.redhat.datagen.rdap.store;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface DomainObjectStore {

    enum Database {

        MYSQL,
        POSTGRES

    }

    String DROP_MYSQL_TABLE_STMT = "DROP TABLE IF EXISTS %s CASCADE;";
    String DROP_POSTGRES_TABLE_STMT = "DROP TABLE IF EXISTS \"%s\" CASCADE;";
    SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

    static List< String > load( final String fileName ) throws Exception {
        final String inputFileName = ( fileName );
        final List< String > result = new ArrayList<>();
        final Path input = Paths.get( inputFileName );
        final String content = new String( Files.readAllBytes( input ) );

        for ( final String line : content.split( "\r\n" ) ) {
            result.add( line );
        }

        return Collections.unmodifiableList( result );
    }

    static Object toDdl( final Object value ) {
        if ( value == null ) {
            throw new RuntimeException( "Unable to convert null to DDL value" );
        }

        if ( value instanceof Timestamp ) {
            return DATE_FORMATTER.format( ( ( Timestamp )value ).getTime() );
        }

        if ( !( value instanceof String ) ) {
            return value;
        }

        return ( ( String )value ).replace( "'", "''" ); // escape any single quotes
    }

}
