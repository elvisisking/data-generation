package com.redhat.datagen.rdap.store;

import java.util.List;

import com.redhat.datagen.rdap.domain.Route;

public final class RouteStore implements DomainObjectStore {

    public interface Column {

        String DRIVER_ID = "DRIVER_ID";
        String ID = "ID";
        String NAME = "NAME";

    }

    private static final String TABLE_NAME = "ROUTE";

    private static final String COLUMNS = /* @formatter:off */
                                          Column.ID + ", "
                                          + Column.DRIVER_ID + ", "
                                          + Column.NAME + " "; // @formatter:on

    private static final String CREATE_TABLE_STMT = /* @formatter:off */
                                                    "CREATE TABLE " + TABLE_NAME + " (\n"
                                                    + "\t" + Column.ID + " INT NOT NULL PRIMARY KEY,\n"
                                                    + "\t" + Column.DRIVER_ID + " INT NOT NULL,\n"
                                                    + "\t" + Column.NAME + " VARCHAR(255) NOT NULL\n"
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO "
                                              + TABLE_NAME
                                              + " ( "
                                              + COLUMNS
                                              + ") VALUES ( %s, %s, '%s' );";

    private static final RouteStore SHARED = new RouteStore();

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
    }

    public static String getInsertStatements( final List< Route > routes ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final Route route : routes ) {
            final String insert = String.format( INSERT_STMT,
                                                 SHARED.toDdl( route.getId() ),
                                                 SHARED.toDdl( route.getDriverId() ),
                                                 SHARED.toDdl( route.getName() ) );
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
    private RouteStore() {
        // nothing to do
    }

}
