package com.redhat.datagen.rdap.store;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.redhat.datagen.rdap.domain.CarData;
import com.redhat.datagen.rdap.domain.Route;
import com.redhat.datagen.rdap.domain.WeatherData;
import com.redhat.datagen.rdap.domain.WeatherData.PrecipType;

public class TripDataStore implements DomainObjectStore {

    public interface Column {

        String ID = "ID";
        String LATITUDE = "LATITUDE";
        String LONGITUDE = "LONGITUDE";
        String ROUTE_ID = "ROUTE_ID";
        String TIMESTAMP = "T_STAMP";

        // car data
        String BAROMETRIC_PRESSURE = "BAROMETRIC_PRESSURE";
        String DISTANCE_WITH_MIL = "DISTANCE_WITH_MIL";
        String DRIVERS_LICENSE_NUMBER = "DRIVERS_LIC_NO";
        String DTC_COUNT = "DTC_COUNT";
        String ENGINE_RUN_TIME = "ENGINE_RUN_TIME";
        String RPM = "RPM";
        String SPEED = "SPEED";
        String THROTTLE_POSITION = "THROTTLE_POS";
        String VIN = "VIN";

        // weather
        String PRECIP_INTENSITY = "PRECIP_INTENSITY";
        String PRECIP_TYPE = "PRECIP_TYPE";
        String WIND_SPEED = "WIND_SPEED";

    }

    private static final String TABLE_NAME = "TRIP_DATA";

    private static final String COLUMNS = /* @formatter:off */
                                          Column.ID + ", "
                                          + Column.ROUTE_ID + ", "
                                          + Column.TIMESTAMP + ", "
                                          + Column.LATITUDE + ", "
                                          + Column.LONGITUDE + ", "
                                          + Column.BAROMETRIC_PRESSURE + ", "
                                          + Column.DISTANCE_WITH_MIL + ", "
                                          + Column.DRIVERS_LICENSE_NUMBER + ", "
                                          + Column.DTC_COUNT + ", "
                                          + Column.ENGINE_RUN_TIME + ", "
                                          + Column.RPM + ", "
                                          + Column.SPEED + ", "
                                          + Column.THROTTLE_POSITION + ", "
                                          + Column.VIN + ", "
                                          + Column.PRECIP_TYPE + ", "
                                          + Column.PRECIP_INTENSITY + ", "
                                          + Column.WIND_SPEED + " "; // @formatter:on

    private static final String CREATE_TABLE_STMT = /* @formatter:off */
                                                    "CREATE TABLE " + TABLE_NAME + " (\n"
                                                    + "\t" + Column.ID + " INT NOT NULL PRIMARY KEY,\n"
                                                    + "\t" + Column.ROUTE_ID + " INT NOT NULL,\n"
                                                    + "\t" + Column.TIMESTAMP + " DATE NOT NULL,\n"
                                                    + "\t" + Column.LATITUDE + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.LONGITUDE + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.BAROMETRIC_PRESSURE + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.DISTANCE_WITH_MIL + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.DRIVERS_LICENSE_NUMBER + " VARCHAR(50) NOT NULL,\n"
                                                    + "\t" + Column.DTC_COUNT + " INT NOT NULL,\n"
                                                    + "\t" + Column.ENGINE_RUN_TIME + " INT NOT NULL,\n"
                                                    + "\t" + Column.RPM + " INT NOT NULL,\n"
                                                    + "\t" + Column.SPEED + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.THROTTLE_POSITION + " DECIMAL NOT NULL,\n"
                                                    + "\t" + Column.VIN + " VARCHAR(50) NOT NULL,\n"
                                                    + "\t" + Column.PRECIP_TYPE + " VARCHAR(10) NOT NULL,\n"
                                                    + "\t" + Column.PRECIP_INTENSITY + " DECIMAL(4,2) NOT NULL,\n"
                                                    + "\t" + Column.WIND_SPEED + " INT NOT NULL\n"
                                                    + ");"; // @formatter:on

    private static final String INSERT_STMT = "INSERT INTO "
                                              + TABLE_NAME
                                              + " ( "
                                              + COLUMNS
                                              + ") VALUES ( "
                                              + "%s, %s, '%s', %s, %s, %s, %s, '%s', %s, %s, %s, %s, %s, '%s', %s, %s, %s"
                                              + " );";

    public static String getCreateTableStatement() {
        return CREATE_TABLE_STMT;
    }

    public static String getDropTableStatement() {
        return String.format( DROP_MYSQL_TABLE_STMT, TABLE_NAME );
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    private int id;

    public TripDataStore( final int firstId ) {
        this.id = firstId;
    }

    private String createInsertDdl( final WeatherData weatherData,
                                    final List< CarData > carDataPoints ) throws Exception {
        final int routeId = weatherData.getRouteId();
        final PrecipType precipType = weatherData.getPrecipType();
        final double precipIntensity = weatherData.getPrecipIntensity();
        final int windSpeed = weatherData.getWindSpeed();
        
        for ( final CarData carData : carDataPoints ) {
            if ( carData.getLatitude() == weatherData.getLatitude()
                 && carData.getLongitude() == weatherData.getLongitude()
                 && carData.getDate().equals( weatherData.getDate() ) ) {
                final String ddl = String.format( INSERT_STMT,
                                                  toDdl( this.id++ ),
                                                  toDdl( routeId ),
                                                  toDdl( DATE_FORMATTER.format( carData.getDate() ) ),
                                                  toDdl( carData.getLatitude() ),
                                                  toDdl( carData.getLongitude() ),
                                                  toDdl( carData.getBarometricPressure() ),
                                                  toDdl( carData.getDistanceWithMil() ),
                                                  toDdl( carData.getDriversLicNumber() ),
                                                  toDdl( carData.getDtcCount() ),
                                                  toDdl( carData.getEngineRunTime() ),
                                                  toDdl( carData.getRpm() ),
                                                  toDdl( carData.getSpeed() ),
                                                  toDdl( carData.getThrottlePosition() ),
                                                  toDdl( carData.getVin() ),
                                                  toDdl( precipType ),
                                                  toDdl( precipIntensity ),
                                                  toDdl( windSpeed ) );
                return ddl;
            }
        }

        throw new RuntimeException( "Unable to find car data for the weather data with ID '"
                                    + weatherData.getId()
                                    + '\'' );
    }

    private Route findRoute( final int routeId,
                             final Set< Route > routes ) {
        for ( final Route route : routes ) {
            if ( routeId == route.getId() ) {
                return route;
            }
        }

        throw new RuntimeException( "Unable to find route with ID '" + routeId + '\'' );
    }

    public String getInsertStatements( final Map< Route, List< CarData > > carDataPoints,
                                       final List< WeatherData > weatherDataPoints ) throws Exception {
        final StringBuilder ddl = new StringBuilder();
        ddl.append( "\n--" ).append( TABLE_NAME ).append( "\n\n" );

        Route route = null;

        for ( final WeatherData weatherData : weatherDataPoints ) {
            final int routeId = weatherData.getRouteId();

            if ( ( route == null ) || ( routeId != route.getId() ) ) {
                route = findRoute( routeId, carDataPoints.keySet() );
            }
            
            final String tripDataDdl = createInsertDdl( weatherData, carDataPoints.get( route ) );
            ddl.append( tripDataDdl ).append( '\n' );
        }

        return ddl.toString();
    }

}
