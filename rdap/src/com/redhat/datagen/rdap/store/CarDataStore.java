package com.redhat.datagen.rdap.store;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.redhat.datagen.rdap.domain.CarData;
import com.redhat.datagen.rdap.domain.Route;
import com.redhat.datagen.util.JsonUtil;

public final class CarDataStore implements DomainObjectStore {

    public interface Column {

        String BAROMETRIC_PRESSURE = "BAROMETRIC_PRESSURE";
        String DISTANCE_WITH_MIL = "DISTANCE_WITH_MIL";
        String DTC_COUNT = "DTC_COUNT";
        String ENGINE_RUN_TIME = "ENGINE_RUNTIME";
        String ID = "ID";
        String LATITUDE = "LATITUDE";
        String LONGITUDE = "LONGITUDE";
        String ROUTE_ID = "ROUTE_ID";
        String RPM = "RPM";
        String SPEED = "SPEED";
        String THROTTLE_POSITION = "THROTTLE_POS";
        String TIMESTAMP = "T_STAMP";

    }

    private interface JsonId {

        String BAROMETRIC_PRESSURE = "barometricPressure";
        String DISTANCE_WITH_MIL = "distanceWithMIL";
        String DRIVERS_LICENSE_NUMBER = "driversLicNo";
        String DTC_COUNT = "dtcCount";
        String ENGINE_RUN_TIME = "engineRunTime";
        String LATITUDE = "latitude";
        String LONGITUDE = "longitude";
        String RPM = "rpm";
        String SPEED = "speed";
        String THROTTLE_POSITION = "throttlePos";
        String TIMESTAMP = "timestamp";
        String VIN = "vin";

    }

    private static final String TABLE_NAME = "CAR_DATA";

    private static final String MYSQL_COLUMNS = /* @formatter:off */
                                                Column.ID + ", "
                                                + Column.ROUTE_ID + ", "
                                                + Column.TIMESTAMP + ", "
                                                + Column.LATITUDE + ", "
                                                + Column.LONGITUDE + ", "
                                                + Column.BAROMETRIC_PRESSURE + ", "
                                                + Column.DISTANCE_WITH_MIL + ", "
                                                + Column.DTC_COUNT + ", "
                                                + Column.ENGINE_RUN_TIME + ", "
                                                + Column.RPM + ", "
                                                + Column.SPEED + ", "
                                                + Column.THROTTLE_POSITION; // @formatter:on

    private static final String MYSQL_CREATE_TABLE_STMT = /* @formatter:off */
                                                          "CREATE TABLE " + TABLE_NAME + " (\n"
                                                          + "\t" + Column.ID + " INT NOT NULL PRIMARY KEY,\n"
                                                          + "\t" + Column.ROUTE_ID + " INT NOT NULL,\n"
                                                          + "\t" + Column.TIMESTAMP + " DATE NOT NULL,\n"
                                                          + "\t" + Column.LATITUDE + " DECIMAL NOT NULL,\n"
                                                          + "\t" + Column.LONGITUDE + " DECIMAL NOT NULL,\n"
                                                          + "\t" + Column.BAROMETRIC_PRESSURE + " DECIMAL NOT NULL,\n"
                                                          + "\t" + Column.DISTANCE_WITH_MIL + " DECIMAL NOT NULL,\n"
                                                          + "\t" + Column.DTC_COUNT + " INT NOT NULL,\n"
                                                          + "\t" + Column.ENGINE_RUN_TIME + " INT NOT NULL,\n"
                                                          + "\t" + Column.RPM + " INT NOT NULL,\n"
                                                          + "\t" + Column.SPEED + " DECIMAL NOT NULL,\n"
                                                          + "\t" + Column.THROTTLE_POSITION + " DECIMAL NOT NULL,\n"
                                                          + "\tFOREIGN KEY ( ROUTE_FK ) REFERENCES "
                                                          + RouteStore.getTableName()
                                                          + " ( " + RouteStore.Column.ID + " )\n"
                                                          + ");"; // @formatter:on

    private static final String MYSQL_INSERT_STMT = "INSERT INTO "
                                                    + TABLE_NAME
                                                    + " ( "
                                                    + MYSQL_COLUMNS
                                                    + " ) VALUES ( %s, %s, '%s' %s, %s, %s %s, %s, %s %s, %s, %s );";

    private static final String POSTGRES_COLUMNS = /* @formatter:off */
                                                   '"' + Column.ID + "\", "
                                                   + '"' + Column.ROUTE_ID + "\", "
                                                   + '"' + Column.TIMESTAMP + "\", "
                                                   + '"' + Column.LATITUDE + "\", "
                                                   + '"' + Column.LONGITUDE + "\", "
                                                   + '"' + Column.BAROMETRIC_PRESSURE + "\", "
                                                   + '"' + Column.DISTANCE_WITH_MIL + "\", "
                                                   + '"' + Column.DTC_COUNT + "\", "
                                                   + '"' + Column.ENGINE_RUN_TIME + "\", "
                                                   + '"' + Column.RPM + "\", "
                                                   + '"' + Column.SPEED + "\", "
                                                   + '"' + Column.THROTTLE_POSITION + '\"'; // @formatter:on

    private static final String POSTGRES_CREATE_TABLE_STMT = /* @formatter:off */
                                                             "CREATE TABLE \"" + TABLE_NAME + "\" (\n"
                                                             + "\t\"" + Column.ID + "\" INTEGER NOT NULL,\n"
                                                             + "\t\"" + Column.ROUTE_ID + "\" INTEGER NOT NULL,\n"
                                                             + "\t\"" + Column.TIMESTAMP + "\" DATE NOT NULL,\n"
                                                             + "\t\"" + Column.LATITUDE + "\" DECIMAL NOT NULL,\n"
                                                             + "\t\"" + Column.LONGITUDE + "\" DECIMAL NOT NULL,\n"
                                                             + "\t\"" + Column.BAROMETRIC_PRESSURE + "\" DECIMAL NOT NULL,\n"
                                                             + "\t\"" + Column.DISTANCE_WITH_MIL + "\" DECIMAL NOT NULL,\n"
                                                             + "\t\"" + Column.DTC_COUNT + "\" INTEGER NOT NULL,\n"
                                                             + "\t\"" + Column.ENGINE_RUN_TIME + "\" INTEGER NOT NULL,\n"
                                                             + "\t\"" + Column.RPM + "\" INTEGER NOT NULL,\n"
                                                             + "\t\"" + Column.SPEED + "\" DECIMAL NOT NULL,\n"
                                                             + "\t\"" + Column.THROTTLE_POSITION + "\" DECIMAL NOT NULL,\n"
                                                             + "\tPRIMARY KEY ( \"" + Column.ID + "\" )\n"
                                                             + ");"; // @formatter:on

    private static final String POSTGRES_INSERT_STMT = "INSERT INTO \""
                                                       + TABLE_NAME
                                                       + "\" ( "
                                                       + POSTGRES_COLUMNS
                                                       + " ) VALUES ( %s, %s, '%s' %s, %s, %s %s, %s, %s %s, %s, %s );";

    public static String getCreateTableStatement( final Database db ) {
        switch ( db ) {
            case MYSQL:
                return MYSQL_CREATE_TABLE_STMT;
            case POSTGRES:
                return POSTGRES_CREATE_TABLE_STMT;
            default:
                break;
        }

        throw new RuntimeException( "Unknown database '" + db.name() + '\'' );
    }

    public static String getDropTableStatement( final Database db ) {
        switch ( db ) {
            case MYSQL:
                return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
            case POSTGRES:
                return String.format( DROP_POSTGRES_TABLE_STMT, TABLE_NAME );
            default:
                break;
        }

        throw new RuntimeException( "Unknown database '" + db.name() + '\'' );
    }

    private static String getInsertStatementFormatPattern( final Database db ) {
        switch ( db ) {
            case MYSQL:
                return MYSQL_INSERT_STMT;
            case POSTGRES:
                return POSTGRES_INSERT_STMT;
            default:
                break;
        }

        throw new RuntimeException( "Unknown database '" + db.name() + '\'' );
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    private static List< String > loadCarData( final File file ) throws Exception {
        final String inputFileName = file.getPath();
        final List< String > lines = new ArrayList<>();
        final Path input = Paths.get( inputFileName );
        final String content = new String( Files.readAllBytes( input ) );

        for ( final String line : content.split( System.lineSeparator() ) ) {
            lines.add( line );
        }

        return Collections.unmodifiableList( lines );
    }

    private int nextCarDataId;

    public CarDataStore( final int firstCarDataId ) {
        this.nextCarDataId = firstCarDataId;
    }

    public List< CarData > getCarData( final File carDataFile ) throws Exception {
        final List< String > jsonRecords = loadCarData( carDataFile );
        final List< CarData > carData = new ArrayList<>( jsonRecords.size() );
        final JSONParser parser = new JSONParser();

        for ( final String json : jsonRecords ) {
            JSONObject jobj = null;

            try {
                jobj = ( JSONObject ) parser.parse( json );
            } catch ( final Exception e ) {
                System.err.println( "Error processing car data:\n\n" + json );
                throw e;
            }

            final CarData data = new CarData( this.nextCarDataId++,
                                              jobj.get( JsonId.DRIVERS_LICENSE_NUMBER ).toString(),
                                              jobj.get( JsonId.VIN ).toString(),
                                              new Timestamp( DATE_FORMATTER
                                                              .parse( jobj.get( JsonId.TIMESTAMP ).toString() )
                                                              .getTime() ),
                                              JsonUtil.toInt( jobj, JsonId.DTC_COUNT ),
                                              JsonUtil.toDouble( jobj, JsonId.DISTANCE_WITH_MIL ),
                                              JsonUtil.toDouble( jobj, JsonId.SPEED ),
                                              JsonUtil.toInt( jobj, JsonId.RPM ),
                                              JsonUtil.toInt( jobj, JsonId.ENGINE_RUN_TIME ),
                                              JsonUtil.toDouble( jobj, JsonId.THROTTLE_POSITION ),
                                              JsonUtil.toDouble( jobj, JsonId.BAROMETRIC_PRESSURE ),
                                              JsonUtil.toDouble( jobj, JsonId.LATITUDE ),
                                              JsonUtil.toDouble( jobj, JsonId.LONGITUDE ) );
            carData.add( data );
        }

        return carData;
    }

    public String getInsertStatements( final Database db,
                                       final Map< Route, List< CarData > > carData ) throws Exception {
        final String insertFormatPattern = getInsertStatementFormatPattern( db );
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final Entry< Route, List< CarData > > entry : carData.entrySet() ) {
            final int routeId = entry.getKey().getId();

            for ( final CarData data : entry.getValue() ) {
                final String insert = String.format( insertFormatPattern,
                                                     toDdl( data.getId() ),
                                                     toDdl( routeId ),
                                                     toDdl( data.getDate() ),
                                                     toDdl( data.getLatitude() ),
                                                     toDdl( data.getLongitude() ),
                                                     toDdl( data.getBarometricPressure() ),
                                                     toDdl( data.getDistanceWithMil() ),
                                                     toDdl( data.getDtcCount() ),
                                                     toDdl( data.getEngineRunTime() ),
                                                     toDdl( data.getRpm() ),
                                                     toDdl( data.getSpeed() ),
                                                     toDdl( data.getThrottlePosition() ) );
                ddl.append( insert ).append( '\n' );
            }
        }

        return ddl.toString();
    }

}
