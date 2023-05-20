package models;

import utilities.Conversions;
import play.Logger;
import play.db.jpa.Model;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Comparator;
import java.util.List;

/**
 * This model class is used for Readings
 *
 * @author Kieron GArvey
 * @version 0.1
 */
@Entity
public class Reading extends Model {
  public String dateTime;
  public int code;
  public double temperature;
  public double windSpeed;
  public double windDirection;
  public int pressure;

  /**
   * Reading() - This constructor creates the new Reading
   *
   * @param code Reading code
   * @param temperature Reading temperature
   * @param windSpeed Reading windSpeed
   * @param windDirection Reading windDirection
   * @param pressure Reading pressure
   */
  public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {
    //Set Date Time, Overrides date/time in yaml file to set current date/time
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Create DateTimeFormatter
    this.dateTime = FORMATTER.format(LocalDateTime.now()); //Get Current Date Time & Set formatted String

    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  /**
   * Reading() - This Overloaded constructor creates the new Reading
   *
   * @param code Reading code
   * @param temperature Reading temperature
   * @param windSpeed Reading windSpeed
   * @param windDirection Reading windDirection
   * @param pressure Reading pressure
   * @param dateTime Reading pressure
   */
  public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure, Date dateTime) {
    this.dateTime = dateTime.toString();
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  /**
   * fahrenheit() -
   * Method Calls convertToFahrenheit() to convert the
   * relevant temperature from celsius to fahrenheit
   *
   * @return temperature in fahrenheit
   */
  public double fahrenheit() {
    return Conversions.convertToFahrenheit(this.temperature);
  }

  /**
   * beaufort() -
   * Method Calls convertToBeaufort() to convert the
   * relevant windSpeed from km/hr to beaufort.
   *
   * The return type is used to return the value in
   * words or beaufort
   *
   * @param returnType returnType used
   * @return windSpeed in beaufort
   */
  public String beaufort(String returnType) {
    return Conversions.convertToBeaufort(this.windSpeed, returnType);
  }

  /**
   * weatherCode() -
   * Method Calls convertWeatherCode() to convert the
   * relevant code to words
   *
   * The return type is used to return the value in
   * words or beaufort
   *
   * @param code code to convert
   * @return code in words
   */
  public String weatherCode(int code) {
    return Conversions.convertWeatherCode(code);
  }

  /**
   * windCompassDirection() -
   * Method Calls convertWeatherCode() to convert the
   * relevant windDirections
   *
   * @return windDirection in words
   */
  public String windCompassDirection() {
    return Conversions.convertDegreeToDirection(this.windDirection);
  }

  /**
   * windChill() -
   * Method Calls calculateWindChill() passing in the relevant
   * temperature and windSpeed calculate the windChill.
   *
   * @return windDirection in words
   */
  public double windChill() {
    return Conversions.calculateWindChill(this.temperature, this.windSpeed);
  }

  /**
   * sortReadings() -
   * Method sorts the passed in readings by ID
   *
   * @param reading list of readings
   * @return reading list of readings
   */
  public static List<Reading> sortReadings(List<Reading> reading) {
    reading.sort(Comparator.comparingLong(Reading::getId));
    Logger.info("Sorting Readings by ID");

    return reading;
  }

  /**** Getters ****/
  public String getDateTime() {
    return dateTime;
  }

  public int getCode() {
    return code;
  }

  public double getTemperature() {
    return temperature;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public double getWindDirection() {
    return windDirection;
  }

  public int getPressure() {
    return this.pressure;
  }
}