package com.redhat.datagen.rdap.domain;

public enum WeatherScenario {

    BAD( "bad", WeatherData.PrecipType.SNOW, 5.0, 50 ),
    GOOD( "good", WeatherData.PrecipType.NONE, 0.0, 0 ),
    MODERATE( "moderate", WeatherData.PrecipType.RAIN, 1.0, 20 );

    private final String name;
    private final double precipIntensity;
    private final WeatherData.PrecipType precipType;
    private final int windSpeed;

    private WeatherScenario( final String name,
                             final WeatherData.PrecipType precipType,
                             final double precipIntensity,
                             final int windSpeed ) {
        this.name = name;
        this.precipType = precipType;
        this.precipIntensity = precipIntensity;
        this.windSpeed = windSpeed;
    }

    public String getName() {
        return this.name;
    }
    
    public double getPrecipIntensity() {
        return this.precipIntensity;
    }

    public WeatherData.PrecipType getPrecipType() {
        return this.precipType;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

}
