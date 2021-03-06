package com.redhat.datagen.rdap.store;

import java.util.Collection;

import com.redhat.datagen.rdap.domain.Address;
import com.redhat.datagen.rdap.domain.Driver;

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

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static Object getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
    }

    public static String getInsertStatements( final Collection< Driver > drivers ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final Driver driver : drivers ) {
            final Address address = driver.getAddress();
            final String driverDdl = String
                            .format( INSERT_STMT,
                                     DomainObjectStore.toDdl( driver.getId() ),
                                     DomainObjectStore.toDdl( driver.getFirstName() ),
                                     DomainObjectStore.toDdl( driver.getLastName() ),
                                     DomainObjectStore.toDdl( address.getLine1() ),
                                     DomainObjectStore.toDdl( address.getCity().getCity() ),
                                     DomainObjectStore.toDdl( address.getCity().getState().getAbbreviation() ),
                                     DomainObjectStore.toDdl( address.getCity().getPostalCode() ),
                                     DomainObjectStore.toDdl( driver.getPhone() ),
                                     DomainObjectStore.toDdl( driver.getLicenseNumber() ),
                                     DomainObjectStore.toDdl( driver.getVin() ) );
            ddl.append( driverDdl ).append( '\n' );
        }

        return ddl.toString();
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
