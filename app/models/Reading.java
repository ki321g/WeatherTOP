package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import utilities.Conversions;


@Entity
public class Reading extends Model {
  public int code;
  public double temperature;
  public double windSpeed;
  public double windDirection;
  public int pressure;
  public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  public double fahrenheit() {
    return Conversions.convertToFahrenheit(this.temperature);
  }

  public String beaufort(String returnType) {
    return Conversions.convertToBeaufort(this.windSpeed, returnType);
  }

  public String weatherCode(int code) {
    return Conversions.convertWeatherCode(code);
  }

  public String windCompassDirection() {
    return Conversions.convertDegreeToDirection(this.windDirection);
  }

  public double windChill() {
    return Conversions.calculateWindChill(this.temperature, this.windSpeed);
  }

  /**** Getters ****/
  public int getCode() {
    return code;
  }

  public double getTemperature() {
    return temperature;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public int getPressure() {
    return pressure;
  }
}