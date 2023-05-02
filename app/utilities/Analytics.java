package utilities;

import models.Reading;
import java.util.ArrayList;
import java.util.List;
public class Analytics {

  public static Reading minTemperature(List<Reading> readings) {
    Reading minTemperature = null;

    if (readings.size() > 0) {
      minTemperature = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getTemperature() < minTemperature.getTemperature()) {
          minTemperature = reading;
        }
      }
    }

    return minTemperature;
  }

  public static Reading maxTemperature(List<Reading> readings) {
    Reading maxTemperature = null;

    if (readings.size() > 0) {
      maxTemperature = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getTemperature() > maxTemperature.getTemperature()) {
          maxTemperature = reading;
        }
      }
    }

    return maxTemperature;
  }

  public static Reading minWindSpeed(List<Reading> readings) {
    Reading minWindSpeed = null;

    if (readings.size() > 0) {
      minWindSpeed = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getWindSpeed() < minWindSpeed.getWindSpeed()) {
          minWindSpeed = reading;
        }
      }
    }

    return minWindSpeed;
  }

  public static Reading maxWindSpeed(List<Reading> readings) {
    Reading maxWindSpeed = null;

    if (readings.size() > 0) {
      maxWindSpeed = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getWindSpeed() > maxWindSpeed.getWindSpeed()) {
          maxWindSpeed = reading;
        }
      }
    }

    return maxWindSpeed;
  }

  public static Reading minPressure(List<Reading> readings) {
    Reading minPressure = null;

    if (readings.size() > 0) {
      minPressure = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getPressure() < minPressure.getPressure()) {
          minPressure = reading;
        }
      }
    }

    return minPressure;
  }

  public static Reading maxPressure(List<Reading> readings) {
    Reading maxPressure = null;

    if (readings.size() > 0) {
      maxPressure = readings.get(0);

      for (Reading reading : readings) {
        if (reading.getPressure() > maxPressure.getPressure()) {
          maxPressure = reading;
        }
      }
    }

    return maxPressure;
  }


}
