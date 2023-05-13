package utilities;

import models.Station;

/**
 * This utilities class for Calculations
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Calculations {

  /**
   * calculateConditions() - Calulates Conditions
   *
   * @param station current station
   */
  public static void calculateConditions(Station station) {

    if (station.readings.size() > 0) {
      station.minTemperature = Analytics.minTemperature(station.readings).getTemperature();
      station.maxTemperature = Analytics.maxTemperature(station.readings).getTemperature();
      station.minWindSpeed = Analytics.minWindSpeed(station.readings).getWindSpeed();
      station.maxWindSpeed = Analytics.maxWindSpeed(station.readings).getWindSpeed();
      station.minPressure = Analytics.minPressure(station.readings).getPressure();
      station.maxPressure = Analytics.maxPressure(station.readings).getPressure();
      station.temperatureTrend = Analytics.temperatureTrend(station.readings);
      station.windSpeedTrend = Analytics.windSpeedTrend(station.readings);
      station.pressureTrend = Analytics.pressureTrend(station.readings);
    }
  }



}
