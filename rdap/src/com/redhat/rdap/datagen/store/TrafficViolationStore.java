package com.redhat.rdap.datagen.store;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.redhat.rdap.datagen.domain.TrafficViolation;

public final class TrafficViolationStore implements DomainObjectStore {

    public interface Column {

        String ID = "ID";
        String DESCRIPTION = "DESCRIPTION";
        String SEVERITY = "SEVERITY";

    }

    private static final class TrafficViolationImpl implements TrafficViolation {

        private final String description;
        private final int id;
        private final int severity;

        public TrafficViolationImpl( final int id,
                                     final String description,
                                     final int severity ) {
            this.id = id;
            this.description = description;
            this.severity = severity;
        }

        /**
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo( final TrafficViolation that ) {
            return Integer.compare( this.id, that.getId() );
        }

        /**
         * @see com.redhat.rdap.datagen.domain.TrafficViolation#getDescription()
         */
        @Override
        public String getDescription() {
            return this.description;
        }

        /**
         * @see com.redhat.rdap.datagen.domain.TrafficViolation#getId()
         */
        @Override
        public int getId() {
            return this.id;
        }

        /**
         * @see com.redhat.rdap.datagen.domain.TrafficViolation#getSeverity()
         */
        @Override
        public int getSeverity() {
            return this.severity;
        }

    }

    private static final TrafficViolationStore SHARED = new TrafficViolationStore();

    private static final String TABLE_NAME = "TRAFFIC_VIOLATION";

    private static final String COLUMNS = /* @formatter:off */
                                          '"' + Column.ID + "\", "
                                          + '"' + Column.DESCRIPTION + "\", "
                                          + '"' + Column.SEVERITY + "\" "; // @formatter:on

    private static final String CREATE_TABLE_STMT = /* @formatter:off */
                                                    "CREATE TABLE \"" + TABLE_NAME + "\" (\n"
                                                    + "\t\"" + Column.ID + "\" INTEGER NOT NULL,\n"
                                                    + "\t\"" + Column.DESCRIPTION + "\" TEXT NOT NULL,\n"
                                                    + "\t\"" + Column.SEVERITY + "\" INTEGER NOT NULL,\n"
                                                    + "\tPRIMARY KEY ( \"" + Column.ID + "\" )\n"
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO \""
                                              + TABLE_NAME
                                              + "\" ( "
                                              + COLUMNS
                                              + ") VALUES ( '%s', '%s', '%s' );";

    public static List< TrafficViolation > get( final String fileName ) throws Exception {
        final Path input = Paths.get( fileName );
        final String content = new String( Files.readAllBytes( input ) );
        final List< TrafficViolationImpl > violations = new ArrayList<>();

        for ( final String line : content.split( System.lineSeparator() ) ) {
            final String tokens[] = line.split( "," );

            if ( tokens.length != 3 ) {
                throw new RuntimeException( "Invalid violations file." );
            }

            final int code = Integer.parseInt( tokens[ 0 ] );
            final String description = tokens[ 1 ];
            final int severity = Integer.parseInt( tokens[ 2 ] );

            final TrafficViolationImpl violation = new TrafficViolationImpl( code, description, severity );
            violations.add( violation );
        }

        return Collections.unmodifiableList( violations );
    }

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TrafficViolationStore.getTableName() );
    }

    public static String getInsertStatements( final List< TrafficViolation > violations ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final TrafficViolation violation : violations ) {
            final String insert = String.format( INSERT_STMT,
                                                 SHARED.toDdl( violation.getId() ),
                                                 SHARED.toDdl( violation.getDescription() ),
                                                 SHARED.toDdl( violation.getSeverity() ) );
            ddl.append( insert ).append( '\n' );
        }

        return ddl.toString();
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    /**
     * Don't allow construction outside this class.
     */
    private TrafficViolationStore() {
        // nothing to do
    }

}
