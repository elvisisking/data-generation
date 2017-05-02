package com.redhat.rdap.datagen.store;

import java.util.Collection;

import com.redhat.rdap.datagen.domain.Address;
import com.redhat.rdap.datagen.domain.Driver;

public final class DriverStore implements DomainObjectStore {

    public interface Column {

        String ADDRESS_LINE_1 = "ADDRESS_LINE_1";
        String CITY = "CITY";
        String FIRST_NAME = "FIRST_NAME";
        String ID = "ID";
        String LAST_NAME = "LAST_NAME";
        String LICENSE_NUMBER = "LICENSE_NUMBER";
        String PHONE = "PHONE";
        String POSTAL_CODE = "POSTAL_CODE";
        String STATE = "STATE";
        String VIN = "VIN";

    }

    private static final String TABLE_NAME = "DRIVER";

    private static final String COLUMNS = /* @formatter:off */ 
                                          '"' + Column.ID + "\", "
                                          + '"' + Column.FIRST_NAME + "\", "
                                          + '"' + Column.LAST_NAME + "\", "
                                          + '"' + Column.ADDRESS_LINE_1 + "\", "
                                          + '"' + Column.CITY + "\", "
                                          + '"' + Column.STATE + "\", "
                                          + '"' + Column.POSTAL_CODE + "\", "
                                          + '"' + Column.PHONE + "\", "
                                          + '"' + Column.LICENSE_NUMBER + "\", "
                                          + '"' + Column.VIN + "\" "; // @formatter:on

    private static final String CREATE_TABLE_STMT = "CREATE TABLE \""
                                                    + TABLE_NAME
                                                    + "\" (\n" // @formatter:off
                                                    + "\t\"" + Column.ID + "\" INTEGER NOT NULL,\n"
                                                    + "\t\"" + Column.FIRST_NAME + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.LAST_NAME + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.ADDRESS_LINE_1 + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.CITY + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.STATE + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.POSTAL_CODE + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.PHONE + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.LICENSE_NUMBER + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.VIN + "\" TEXT NOT NULL,\n"
                                                    + "\tPRIMARY KEY ( \"" + Column.ID + "\" )\n"
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO \""
                                              + TABLE_NAME
                                              + "\" ( "
                                              + COLUMNS
                                              + ") VALUES ( '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s' );";
    private static final DriverStore SHARED = new DriverStore();

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getInsertStatements( final Collection< Driver > drivers ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final Driver driver : drivers ) {
            final Address address = driver.getAddress();
            final String driverDdl = String.format( INSERT_STMT,
                                                    SHARED.toDdl( driver.getId() ),
                                                    SHARED.toDdl( driver.getFirstName() ),
                                                    SHARED.toDdl( driver.getLastName() ),
                                                    SHARED.toDdl( address.getLine1() ),
                                                    SHARED.toDdl( address.getCity().getCity() ),
                                                    SHARED.toDdl( address.getCity().getState().getAbbreviation() ),
                                                    SHARED.toDdl( address.getCity().getPostalCode() ),
                                                    SHARED.toDdl( driver.getPhone() ),
                                                    SHARED.toDdl( driver.getLicenseNumber() ),
                                                    SHARED.toDdl( driver.getVin() ) );
            ddl.append( driverDdl ).append( '\n' );
        }

        return ddl.toString();
    }

    public static Object getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    /**
     * Don't allow construction outside this class.
     */
    private DriverStore() {
        // nothing to do
    }

}
