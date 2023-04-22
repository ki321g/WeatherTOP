package utilities;

import models.Reading;
import models.Station;

public class Calculations {
  public static void calculateConditions(Station station) {

    if (station.readings.size() > 0) {
      station.minTemperature = Analytics.minTemperature(station.readings).temperature;
      station.maxTemperature = Analytics.maxTemperature(station.readings).temperature;
      station.minWindSpeed = Analytics.minWindSpeed(station.readings).windSpeed;
      station.maxWindSpeed = Analytics.maxWindSpeed(station.readings).windSpeed;
      station.minPressure = Analytics.minPressure(station.readings).pressure;
      station.maxPressure = Analytics.maxPressure(station.readings).pressure;
    }
  }
}
