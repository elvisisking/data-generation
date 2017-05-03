package com.redhat.datagen.rdap;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.redhat.datagen.rdap.domain.Address;
import com.redhat.datagen.rdap.domain.CarData;
import com.redhat.datagen.rdap.domain.City;
import com.redhat.datagen.rdap.domain.Driver;
import com.redhat.datagen.rdap.domain.DriverOffense;
import com.redhat.datagen.rdap.domain.Route;
import com.redhat.datagen.rdap.domain.State;
import com.redhat.datagen.rdap.domain.TrafficViolation;
import com.redhat.datagen.rdap.domain.WeatherData;
import com.redhat.datagen.rdap.domain.WeatherScenario;
import com.redhat.datagen.rdap.store.CarDataStore;
import com.redhat.datagen.rdap.store.DriverHistoryStore;
import com.redhat.datagen.rdap.store.DriverOffenseStore;
import com.redhat.datagen.rdap.store.DriverStore;
import com.redhat.datagen.rdap.store.RouteStore;
import com.redhat.datagen.rdap.store.TrafficViolationStore;
import com.redhat.datagen.rdap.store.TripDataStore;
import com.redhat.datagen.rdap.store.WeatherDataStore;
import com.redhat.datagen.util.RandomGenerator;

public final class RdapDataGenerator {

    private static final String[] BART = new String[] { "Bart", "Simpson" };
    private static final String[] LISA = new String[] { "Lisa", BART[ 1 ] };

    private static final String CAR_DATA_FILE_PREFIX = "OBD-";
    private static final String CAR_DATA_FILE_EXT = ".txt";
    private static final String GENERATED_FILES_FOLDER = "generated/";
    private static final String ROUTES_OUTPUT_FILE = GENERATED_FILES_FOLDER + "routes.ddl";
    private static final String POSTGRES_HISTORY_OUTPUT_FILE = GENERATED_FILES_FOLDER + "driverHistory.ddl";
    private static final String POSTGRES_OUTPUT_FILE = GENERATED_FILES_FOLDER + "postgres.ddl";
    private static final String TRIP_DATA_OUTPUT_FILE = GENERATED_FILES_FOLDER + "tripData.ddl";
    private static final String WEATHER_OUTPUT_FILE = GENERATED_FILES_FOLDER + "weather.ddl";
    private static final String WEATHER_FILE_FOLDER = GENERATED_FILES_FOLDER + "weather_data/";
    private static final String WEATHER_FILE_PREFIX = WEATHER_FILE_FOLDER + "weather-";

    public static void main( final String[] args ) {
        final int firstCarDataId = 1000;
        final int firstDriverId = 4000;
        final int firstDriverHistoryId = 100;
        final int firstOffenseId = 5000;
        final int firstRouteId = 6000;
        final int firstTripDataId = 1;
        final int firstWeatherId = 7000;
        final Timestamp firstViolationDate = Timestamp.valueOf( LocalDateTime.of( 2000, 1, 1, 1, 1 ) );
        final Timestamp lastViolationDate = new Timestamp( Instant.now().toEpochMilli() );
        final int numBartOffenses = 100;
        final int numLisaOffenses = 1;
        final int maxOffenses = 15;
        final long startTime = System.currentTimeMillis();

        try {
            final RdapDataGenerator generator = new RdapDataGenerator( firstCarDataId,
                                                                       firstDriverId,
                                                                       firstRouteId,
                                                                       firstOffenseId,
                                                                       firstViolationDate,
                                                                       lastViolationDate,
                                                                       firstWeatherId,
                                                                       firstDriverHistoryId,
                                                                       firstTripDataId,
                                                                       maxOffenses,
                                                                       numBartOffenses,
                                                                       numLisaOffenses );
            generator.generateDdl();

            {
                System.out.print( "Writing Postgres DDL file ..." );
                final long start = System.currentTimeMillis();
                final Path output = Paths.get( POSTGRES_OUTPUT_FILE );
                Files.write( output, generator.getPostgresDdl().getBytes() );
                System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
            }

            {
                System.out.print( "Writing routes MySQL DDL file ..." );
                final long start = System.currentTimeMillis();
                final Path output = Paths.get( ROUTES_OUTPUT_FILE );
                Files.write( output, generator.getRoutesDdl().getBytes() );
                System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
            }

            {
                System.out.print( "Writing weather data MySQL DDL file ..." );
                final long start = System.currentTimeMillis();
                final Path output = Paths.get( WEATHER_OUTPUT_FILE );
                Files.write( output, generator.getWeatherDdl().getBytes() );
                System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
            }

            {
                System.out.print( "Writing driver history MySQL DDL file ..." );
                final long start = System.currentTimeMillis();
                final Path output = Paths.get( POSTGRES_HISTORY_OUTPUT_FILE );
                Files.write( output, generator.getDriverHistoryDdl().getBytes() );
                System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
            }

            {
                System.out.print( "Writing trip data MySQL DDL file ..." );
                final long start = System.currentTimeMillis();
                final Path output = Paths.get( TRIP_DATA_OUTPUT_FILE );
                Files.write( output, generator.getTripDataDdl().getBytes() );
                System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
            }

            final long duration = ( System.currentTimeMillis() - startTime );
            System.out.println( "\n*** Finished RDAP demo data generation in " + duration + " ms" );
        } catch ( final Exception e ) {
            e.printStackTrace();
        }
    }

    private final Map< Route, List< CarData > > carData = new HashMap<>(); // key is route name
    private final CarDataStore carDataStore;
    private final StringBuilder driverHistoryDdl = new StringBuilder();
    private final DriverHistoryStore driverHistoryStore;
    private int driverId;
    private List< DriverOffense > driverOffenses;
    private final Map< String, Driver > drivers = new HashMap<>(); // key is license
    private final Timestamp firstOffenseDate;
    private final Timestamp lastOffenseDate;
    private final int maxOffenses;
    private final int numBartOffenses;
    private final int numLisaOffenses;
    private int offenseId;
    private final StringBuilder postgresDdl = new StringBuilder();
    private final RandomGenerator random = new RandomGenerator();
    private int routeId;
    private final List< Route > routes = new ArrayList<>();
    private final StringBuilder routesDdl = new StringBuilder();
    private final StringBuilder tripDataDdl = new StringBuilder();
    private final TripDataStore tripDataStore;
    private final Map< String, List< String > > usedNames = new HashMap<>();
    private final Set< String > usedAddresses = new HashSet<>();
    private final Set< String > usedPhones = new HashSet<>();
    private List< WeatherData > weatherData;
    private final StringBuilder weatherDdl = new StringBuilder();
    private int weatherId;

    RdapDataGenerator( final int firstCarDataId,
                       final int firstDriverId,
                       final int firstRouteId,
                       final int firstOffenseId,
                       final Timestamp firstOffenseDate,
                       final Timestamp lastOffenseDate,
                       final int firstWeatherId,
                       final int firstDriverHistoryId,
                       final int firstTripDataId,
                       final int maxOffenses,
                       final int numBartOffenses,
                       final int numLisaOffenses ) throws Exception {
        this.carDataStore = new CarDataStore( firstCarDataId );
        this.driverId = firstDriverId;
        this.routeId = firstRouteId;
        this.offenseId = firstOffenseId;
        this.firstOffenseDate = firstOffenseDate;
        this.lastOffenseDate = lastOffenseDate;
        this.weatherId = firstWeatherId;
        this.driverHistoryStore = new DriverHistoryStore( firstDriverHistoryId );
        this.tripDataStore = new TripDataStore( firstTripDataId );
        this.maxOffenses = maxOffenses;
        this.numBartOffenses = numBartOffenses;
        this.numLisaOffenses = numLisaOffenses;
    }

    private List< WeatherData > createtWeatherData( final List< CarData > carData,
                                                    final Route route ) throws Exception {
        final List< WeatherData > result = new ArrayList<>();
        final int routeId = route.getId();

        // create weather scenarios for each route
        for ( final WeatherScenario scenario : WeatherScenario.values() ) {
            final StringBuilder csv = new StringBuilder();

            for ( final CarData dataPoint : carData ) {
                final WeatherData weatherData = new WeatherData( this.weatherId++,
                                                                 routeId,
                                                                 dataPoint.getDate(),
                                                                 dataPoint.getLatitude(),
                                                                 dataPoint.getLongitude(),
                                                                 scenario.getPrecipIntensity(),
                                                                 scenario.getPrecipType(),
                                                                 scenario.getWindSpeed() );
                result.add( weatherData );
                csv.append( WeatherDataStore.toCsv( weatherData ) );
            }

            // write route weather data file
            final File file = new File( WEATHER_FILE_PREFIX + route.getName() + '-' + scenario.getName() + ".csv" );
            Files.write( Paths.get( file.getPath() ), csv.toString().getBytes() );
        }

        return result;
    }

    private void generateDdl() throws Exception {
        {
            System.out.print( "Generating drop and create Postgres table statements ... " );
            final long start = System.currentTimeMillis();
            writePostgresDropTables( this.postgresDdl );
            writePostgresCreateTables( this.postgresDdl );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating Postgres insert traffic violation DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.postgresDdl.append( TrafficViolationStore
                            .getInsertStatements( RdapDataProvider.getTrafficViolations() ) );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        processCarDataFiles();

        {
            System.out.print( "Generating Postgres insert car data DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.postgresDdl.append( this.carDataStore.getInsertStatements( this.carData ) );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating drop, create, and insert route MySQL DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.routesDdl.append( RouteStore.getDropTableStatement() ).append( "\n\n" );
            this.routesDdl.append( RouteStore.getCreateTableStatement() ).append( "\n\n" );
            this.routesDdl.append( RouteStore.getInsertStatements( this.routes ) );
            this.routesDdl.append( "\n\ncommit;\n\n" );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating drop, create, and insert weather MySQL DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.weatherDdl.append( WeatherDataStore.getDropTableStatement() ).append( "\n\n" );
            this.weatherDdl.append( WeatherDataStore.getCreateTableStatement() ).append( "\n\n" );
            this.weatherDdl.append( WeatherDataStore.getInsertStatements( generateWeatherData() ) );
            this.weatherDdl.append( "\n\ncommit;\n\n" );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating Postgres insert driver DDL statements... " );
            final long start = System.currentTimeMillis();
            this.postgresDdl.append( DriverStore.getInsertStatements( this.drivers.values() ) );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating Postgres insert driver offense DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.postgresDdl.append( DriverOffenseStore.getInsertStatements( getDriverOffenses() ) );
            this.postgresDdl.append( "\n\ncommit;\n\n" );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating drop, create, and insert driver history Postgres DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.driverHistoryDdl.append( DriverHistoryStore.getDropTableStatement() ).append( "\n\n" );
            this.driverHistoryDdl.append( DriverHistoryStore.getCreateTableStatement() ).append( "\n\n" );
            this.driverHistoryDdl.append( this.driverHistoryStore.getInsertStatements( this.drivers.values(),
                                                                                       RdapDataProvider.getTrafficViolations(),
                                                                                       this.driverOffenses ) );
            this.driverHistoryDdl.append( "\n\ncommit;\n\n" );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }

        {
            System.out.print( "Generating drop, create, and insert trip data Postgres DDL statements ... " );
            final long start = System.currentTimeMillis();
            this.tripDataDdl.append( TripDataStore.getDropTableStatement() ).append( "\n\n" );
            this.tripDataDdl.append( TripDataStore.getCreateTableStatement() ).append( "\n\n" );
            this.tripDataDdl.append( this.tripDataStore.getInsertStatements( this.carData, this.weatherData ) );
            this.tripDataDdl.append( "\n\ncommit;\n\n" );
            System.out.println( "done (" + ( System.currentTimeMillis() - start ) + " ms)" );
        }
    }

    private Driver generateDriver( final String driversLicense,
                                   final String vin ) throws Exception {
        if ( this.drivers.containsKey( driversLicense ) ) {
            return this.drivers.get( driversLicense );
        }

        final String firstName = nextFirstName();
        String lastName = nextLastName();

        // make sure there is not an already first name/last name combination
        while ( this.usedNames.containsKey( firstName ) && this.usedNames.get( firstName ).contains( lastName ) ) {
            lastName = nextLastName();
        }

        // make sure line1 has not been used
        String line1 = nextAddressLine1();

        while ( this.usedAddresses.contains( line1 ) ) {
            line1 = nextAddressLine1();
        }

        final City city = nextCity();
        final Address address = new Address( line1, city );

        // make sure phone has not be used
        String phone = nextPhoneNumber( city.getState() );

        while ( this.usedPhones.contains( phone ) ) {
            phone = nextPhoneNumber( city.getState() );
        }

        final Driver driver = new Driver( this.driverId++, firstName, lastName, address, phone, driversLicense, vin );
        this.usedAddresses.add( driver.getAddress().getLine1() );
        this.usedPhones.add( driver.getPhone() );

        this.drivers.put( driversLicense, driver );
        return driver;
    }

    private List< WeatherData > generateWeatherData() throws Exception {
        if ( this.weatherData == null ) {
            // delete old weather data files
            try {
                final Path dir = Paths.get( WEATHER_FILE_FOLDER );

                if ( Files.exists( dir ) ) {
                    Files.walk( dir, new FileVisitOption[ 0 ] ).filter( p -> p != dir ).map( Path::toFile )
                                    .forEach( File::delete );
                } else {
                    Files.createDirectory( dir );
                }
            } catch ( final Exception e ) {
                System.err.println( "*** Error deleting old generated weather data files ***" );
            }

            this.weatherData = new ArrayList<>();

            for ( final Route route : this.routes ) {
                final List< CarData > dataPoints = this.carData.get( route );
                this.weatherData.addAll( createtWeatherData( dataPoints, route ) );
            }
        }

        return this.weatherData;
    }

    private String getDriverHistoryDdl() {
        return this.driverHistoryDdl.toString();
    }

    private List< DriverOffense > getDriverOffenses() throws Exception {
        if ( this.driverOffenses == null ) {
            final List< DriverOffense > offenses = new ArrayList<>();

            for ( final Driver driver : this.drivers.values() ) {
                final int driverId = driver.getId();
                final int numOffenses = nextNumberOfDriverOffenses( driver );

                for ( int i = 0; i < numOffenses; ++i ) {
                    final TrafficViolation violation = nextViolation();
                    final DriverOffense offense = new DriverOffense( this.offenseId++,
                                                                     this.random.next( this.firstOffenseDate,
                                                                                       this.lastOffenseDate ),
                                                                     driverId,
                                                                     violation.getId() );
                    offenses.add( offense );
                }
            }

            this.driverOffenses = Collections.unmodifiableList( offenses );
        }

        return this.driverOffenses;
    }

    private String getPostgresDdl() {
        return this.postgresDdl.toString();
    }

    private String getRoutesDdl() {
        return this.routesDdl.toString();
    }

    private String getTripDataDdl() {
        return this.tripDataDdl.toString();
    }

    private String getWeatherDdl() {
        return this.weatherDdl.toString();
    }

    private String nextAddressLine1() throws Exception {
        final int number = this.random.next( 1, 900 );
        final String street = nextStreet();
        final String suffix = this.random.next( RdapDataProvider.getStreetSuffixes() );
        return ( number + " " + street + ' ' + suffix );
    }

    private int nextAreaCode( final State state ) throws Exception {
        return this.random.next( RdapDataProvider.getAreaCodes( state.getAbbreviation() ) );
    }

    private City nextCity() throws Exception {
        return this.random.next( RdapDataProvider.getCities() );
    }

    private String nextFirstName() throws Exception {
        if ( this.drivers.isEmpty() ) {
            return BART[ 0 ];
        }

        if ( this.drivers.size() == 1 ) {
            return LISA[ 0 ];
        }

        return this.random.next( this.random.next() ? RdapDataProvider.getMaleNames()
                                                    : RdapDataProvider.getFemaleNames() );
    }

    private String nextLastName() throws Exception {
        if ( this.drivers.size() < 3 ) {
            return BART[ 1 ];
        }

        return this.random.next( RdapDataProvider.getLastNames() );
    }

    private int nextNumberOfDriverOffenses( final Driver driver ) {
        if ( BART[ 0 ].equals( driver.getFirstName() ) && BART[ 1 ].equals( driver.getLastName() ) ) {
            return this.numBartOffenses;
        }

        if ( LISA[ 0 ].equals( driver.getFirstName() ) && LISA[ 1 ].equals( driver.getLastName() ) ) {
            return this.numLisaOffenses;
        }

        return this.random.next( 0, this.maxOffenses );
    }

    private String nextPhoneNumber( final State state ) throws Exception {
        final StringBuilder builder = new StringBuilder();
        builder.append( '(' ).append( nextAreaCode( state ) ).append( ')' );

        for ( int i = 0; i < 3; ++i ) {
            builder.append( this.random.next( 0, 9 ) );
        }

        builder.append( '-' );

        for ( int i = 0; i < 4; ++i ) {
            builder.append( this.random.next( 0, 9 ) );
        }

        return builder.toString();
    }

    private String nextStreet() throws Exception {
        return this.random.next( RdapDataProvider.getStreets() );
    }

    private TrafficViolation nextViolation() throws Exception {
        return this.random.next( RdapDataProvider.getTrafficViolations() );
    }

    private void processCarDataFiles() throws Exception {
        System.out.println( "Processing car data files ..." );
        final long startTime = System.currentTimeMillis();
        final Path carDataFolder = Paths.get( RdapDataProvider.CAR_DATA_FOLDER );
        int i = 0;

        try ( final DirectoryStream< Path > stream = Files.newDirectoryStream( carDataFolder ) ) {
            for ( final Path path : stream ) {
                final long start = System.currentTimeMillis();
                final File carDataFile = path.toFile();
                final String fileName = carDataFile.getName();
                System.out.print( "\t- car data file '" + carDataFile.getName() + "': " );

                final String name = fileName.substring( CAR_DATA_FILE_PREFIX.length(),
                                                        ( fileName.length() - CAR_DATA_FILE_EXT.length() ) );
                final List< CarData > carData = this.carDataStore.getCarData( carDataFile );
                System.out.print( "created car data" );

                // generate a new driver if necessary
                final CarData data = carData.get( 0 );
                final String driversLicense = data.getDriversLicNumber();
                Driver driver = this.drivers.get( driversLicense );

                if ( driver == null ) {
                    driver = generateDriver( driversLicense, data.getVin() );
                    System.out.print( ", created driver" );
                }

                // generate route
                final Route route = new Route( this.routeId++, name, driver.getId() );
                this.routes.add( route );
                this.carData.put( route, carData );
                System.out.print( ", created route" );

                // finished
                System.out.println( ", done (" + ( System.currentTimeMillis() - start ) + " ms)" );
                ++i;
            }
        }

        System.out.println( "\t- done processing "
                            + i
                            + " files ("
                            + ( System.currentTimeMillis() - startTime )
                            + " ms)" );
    }

    private void writePostgresCreateTables( final StringBuilder builder ) {
        builder.append( DriverStore.getCreateTableStatement() ).append( "\n\n" );
        builder.append( TrafficViolationStore.getCreateTableStatement() ).append( "\n\n" );
        builder.append( CarDataStore.getCreateTableStatement() ).append( "\n\n" );
        builder.append( DriverOffenseStore.getCreateTableStatement() ).append( "\n\n" );
    }

    private void writePostgresDropTables( final StringBuilder builder ) {
        builder.append( DriverOffenseStore.getDropTableStatement() ).append( '\n' );
        builder.append( CarDataStore.getDropTableStatement() ).append( '\n' );
        builder.append( TrafficViolationStore.getDropTableStatement() ).append( '\n' );
        builder.append( DriverStore.getDropTableStatement() ).append( "\n\n" );
    }

}
