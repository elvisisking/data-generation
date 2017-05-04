package com.redhat.datagen.rdap.store;

import java.util.Collection;
import java.util.List;

import com.redhat.datagen.rdap.domain.Driver;
import com.redhat.datagen.rdap.domain.DriverOffense;
import com.redhat.datagen.rdap.domain.TrafficViolation;

public final class DriverHistoryStore implements DomainObjectStore {

    public interface Column {

        String ID = "ID";

        // driver
        String FIRST_NAME = "FIRST_NAME";
        String LAST_NAME = "LAST_NAME";
        String LICENSE_NUMBER = "LICENSE_NUMBER";
        String VIN = "VIN";

        // violation
        String TIMESTAMP = "T_STAMP";
        String DESCRIPTION = "DESCRIPTION";
        String SEVERITY = "SEVERITY";

    }

    private static final String TABLE_NAME = "DRIVER_HISTORY";

    private static final String COLUMNS = /* @formatter:off */
                                          '"' + Column.ID + "\", "
                                          + '"' + Column.TIMESTAMP + "\", "
                                          + '"' + Column.FIRST_NAME + "\", "
                                          + '"' + Column.LAST_NAME + "\", "
                                          + '"' + Column.LICENSE_NUMBER + "\", "
                                          + '"' + Column.VIN + "\", "
                                          + '"' + Column.DESCRIPTION + "\", "
                                          + '"' + Column.SEVERITY + "\" "; // @formatter:on

    private static final String CREATE_TABLE_STMT = "CREATE TABLE \""
                                                    + TABLE_NAME
                                                    + "\" (\n" // @formatter:off
                                                    + "\t\"" + Column.ID + "\" INTEGER NOT NULL,\n"
                                                    + "\t\"" + Column.TIMESTAMP + "\" DATE NOT NULL,\n"
                                                    + "\t\"" + Column.FIRST_NAME + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.LAST_NAME + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.LICENSE_NUMBER + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.VIN + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.DESCRIPTION + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.SEVERITY + "\" INTEGER NOT NULL,\n"
                                                    + "\tPRIMARY KEY ( \"" + Column.ID + "\" )\n"
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO \""
                                              + TABLE_NAME
                                              + "\" ( "
                                              + COLUMNS
                                              + ") VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s' );";

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static Object getDropTableStatement() {
        return String.format( DROP_POSTGRES_TABLE_STMT, TABLE_NAME );
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    private int nextId;

    public DriverHistoryStore( final int firstId ) {
        this.nextId = firstId;
    }

    private Driver getDriver( final int driverId,
                              final Collection< Driver > drivers ) {
        for ( final Driver driver : drivers ) {
            if ( driver.getId() == driverId ) {
                return driver;
            }
        }

        throw new RuntimeException( "Driver with ID '" + driverId + "' not found" );
    }

    public String getInsertStatements( final Collection< Driver > drivers,
                                       final List< TrafficViolation > violations,
                                       final List< DriverOffense > offenses ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final DriverOffense offense : offenses ) {
            final TrafficViolation violation = getViolation( offense.getViolationId(), violations );
            final Driver driver = getDriver( offense.getDriverId(), drivers );
            final String historyDdl = String.format( INSERT_STMT,
                                                     DomainObjectStore.toDdl( this.nextId++ ),
                                                     DomainObjectStore.toDdl( offense.getDate() ),
                                                     DomainObjectStore.toDdl( driver.getFirstName() ),
                                                     DomainObjectStore.toDdl( driver.getLastName() ),
                                                     DomainObjectStore.toDdl( driver.getLicenseNumber() ),
                                                     DomainObjectStore.toDdl( driver.getVin() ),
                                                     DomainObjectStore.toDdl( violation.getDescription() ),
                                                     DomainObjectStore.toDdl( violation.getSeverity() ) );
            ddl.append( historyDdl ).append( '\n' );
        }

        return ddl.toString();
    }

    private TrafficViolation getViolation( final int violationId,
                                           final List< TrafficViolation > violations ) {
        for ( final TrafficViolation violation : violations ) {
            if ( violation.getId() == violationId ) {
                return violation;
            }
        }

        throw new RuntimeException( "Violation with ID '" + violationId + "' not found" );
    }

}
