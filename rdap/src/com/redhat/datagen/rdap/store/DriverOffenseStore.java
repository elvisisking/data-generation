package com.redhat.datagen.rdap.store;

import java.util.List;

import com.redhat.datagen.rdap.domain.DriverOffense;

public final class DriverOffenseStore implements DomainObjectStore {

    public interface Column {

        String DRIVER_ID = "DRIVER_ID";
        String ID = "ID";
        String TIMESTAMP = "TIMESTAMP";
        String VIOLATION_ID = "VIOLATION_ID";

    }

    private static final String TABLE_NAME = "DRIVER_OFFENSE";

    private static final String COLUMNS = /* @formatter:off */
                                          '"' + Column.ID + "\", "
                                          + '"' + Column.TIMESTAMP + "\", "
                                          + '"' + Column.DRIVER_ID + "\", "
                                          + '"' + Column.VIOLATION_ID + "\" "; // @formatter:on

    private static final String DRIVER_FK = "\tCONSTRAINT \"DRIVER_FK\" FOREIGN KEY ( \""
                                            + Column.DRIVER_ID
                                            + "\" ) REFERENCES \""
                                            + DriverStore.getTableName()
                                            + "\" ( \""
                                            + DriverStore.Column.ID
                                            + "\" ),\n";

    private static final String VIOLATION_FK = "\tCONSTRAINT \"VIOLATION_FK\" FOREIGN KEY ( \""
                                               + Column.VIOLATION_ID
                                               + "\" ) REFERENCES \""
                                               + TrafficViolationStore.getTableName()
                                               + "\" ( \""
                                               + TrafficViolationStore.Column.ID
                                               + "\" )\n";

    private static final String CREATE_TABLE_STMT = /* @formatter:off */
                                                    "CREATE TABLE \"" + TABLE_NAME + "\" (\n"
                                                    + "\t\"" + Column.ID + "\" INTEGER NOT NULL,\n"
                                                    + "\t\"" + Column.TIMESTAMP + "\" DATE NOT NULL,\n"
                                                    + "\t\"" + Column.DRIVER_ID + "\" INTEGER NOT NULL,\n"
                                                    + "\t\"" + Column.VIOLATION_ID + "\" INTEGER NOT NULL,\n"
                                                    + "\tPRIMARY KEY ( \"" + Column.ID + "\" ),\n"
                                                    + DRIVER_FK
                                                    + VIOLATION_FK
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO \""
                                              + TABLE_NAME
                                              + "\" ( "
                                              + COLUMNS
                                              + ") VALUES ( '%s', '%s', '%s', '%s' );";

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
    }

    public static String getInsertStatements( final List< DriverOffense > offenses ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final DriverOffense offense : offenses ) {
            final String insert = String.format( INSERT_STMT,
                                                 DomainObjectStore.toDdl( offense.getId() ),
                                                 DomainObjectStore.toDdl( offense.getDate() ),
                                                 DomainObjectStore.toDdl( offense.getDriverId() ),
                                                 DomainObjectStore.toDdl( offense.getViolationId() ) );
            ddl.append( insert ).append( '\n' );
        }

        return ddl.toString();
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    /**
     * Don't allow construction outside of this class.
     */
    private DriverOffenseStore() {
        // nothing to do
    }

}
