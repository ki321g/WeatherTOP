package utilities;

import com.google.gson.JsonArray;
import models.Reading;
import models.Station;
import play.mvc.results.Result;
import play.utils.HTML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculations {
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
