package com.redhat.rdap.datagen.store;

import java.util.List;

import com.redhat.rdap.datagen.domain.WeatherData;

public final class WeatherDataStore implements DomainObjectStore {

    public interface Column {

        String ID = "ID";
        String LATITUDE = "LATITUDE";
        String LONGITUDE = "LONGITUDE";
        String PRECIP_INTENSITY = "PRECIP_INTENSITY";
        String PRECIP_TYPE = "PRECIP_TYPE";
        String ROUTE_ID = "ROUTE_ID";
        String TIMESTAMP = "T_STAMP";
        String WIND_SPEED = "WIND_SPEED";

    }

    private static final WeatherDataStore SHARED = new WeatherDataStore();

    private static final String TABLE_NAME = "dbo.WEATHER_DATA";

    private static final String COLUMNS = /* @formatter:off */
                                          Column.ID + ", "
                                          + Column.ROUTE_ID + ", "
                                          + Column.PRECIP_TYPE + ", "
                                          + Column.TIMESTAMP + ", "
                                          + Column.LATITUDE + ", "
                                          + Column.LONGITUDE + ", "
                                          + Column.PRECIP_INTENSITY + ", "
                                          + Column.WIND_SPEED + " "; // @formatter:on

    private static final String CREATE_TABLE_STMT = /* @formatter:off */
                                                    "CREATE TABLE " + TABLE_NAME + " (\n"
                                                    + "\t" + Column.ID + " INT NOT NULL PRIMARY KEY,\n"
                                                    + "\t" + Column.ROUTE_ID + " INT NOT NULL,\n"
                                                    + "\t" + Column.PRECIP_TYPE + " VARCHAR(10) NOT NULL,\n"
                                                    + "\t" + Column.TIMESTAMP + " DATE NOT NULL,\n"
                                                    + "\t" + Column.LATITUDE + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.LONGITUDE + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.PRECIP_INTENSITY + " DECIMAL(4,2) NOT NULL,\n"
                                                    + "\t" + Column.WIND_SPEED + " INT NOT NULL\n"
                                                    + " );"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO "
                                              + TABLE_NAME
                                              + " ( "
                                              + COLUMNS
                                              + ") VALUES ( %s, %s, '%s', '%s', %s, %s, %s, %s );";

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, WeatherDataStore.getTableName() );
    }

    public static String getInsertStatements( final List< WeatherData > weatherData ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        for ( final WeatherData data : weatherData ) {
            final String weatherDdl = String.format( INSERT_STMT,
                                                     SHARED.toDdl( data.getId() ),
                                                     SHARED.toDdl( data.getRouteId() ),
                                                     SHARED.toDdl( data.getPrecipType().name() ),
                                                     SHARED.toDdl( DATE_FORMATTER.format( data.getDate() ) ),
                                                     SHARED.toDdl( data.getLatitude() ),
                                                     SHARED.toDdl( data.getLongitude() ),
                                                     SHARED.toDdl( data.getPrecipIntensity() ),
                                                     SHARED.toDdl( data.getWindSpeed() ) );
            ddl.append( weatherDdl ).append( '\n' );
        }

        return ddl.toString();
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String toCsv( final WeatherData weatherData ) {
        final StringBuilder builder = new StringBuilder();
        builder.append( weatherData.getId() ).append( ',' );
        builder.append( weatherData.getRouteId() ).append( ',' );
        builder.append( DATE_FORMATTER.format( weatherData.getDate() ) ).append( ',' );
        builder.append( weatherData.getLatitude() ).append( ',' );
        builder.append( weatherData.getLongitude() ).append( ',' );
        builder.append( weatherData.getPrecipIntensity() ).append( ',' );
        builder.append( weatherData.getPrecipType() ).append( ',' );
        builder.append( weatherData.getWindSpeed() ).append( '\n' );

        return builder.toString();
    }

    /**
     * Don't allow construction outside this class.
     */
    private WeatherDataStore() {
        // nothing to do
    }

}
