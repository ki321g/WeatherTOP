package utilities;

import java.util.HashMap;

/**
 * This utilities class for Conversions
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Conversions {

  /**
   * convertToBeaufort() - Returns Minimum Temperature
   *
   * @param windSpeed list of readings
   * @param returnType return type is value or Label
   * @return bf as value or Label
   */
  public static String convertToBeaufort(double windSpeed, String returnType) {
    int bf = 0;

    if (windSpeed == 1) {
      bf = 0;
    } else if (windSpeed >= 2 && windSpeed <= 5) {
      bf = 1;
    } else if (windSpeed >= 6 && windSpeed <= 11) {
      bf = 2;
    } else if (windSpeed >= 12 && windSpeed <= 19) {
      bf = 3;
    } else if (windSpeed >= 20 && windSpeed <= 28) {
      bf = 4;
    } else if (windSpeed >= 29 && windSpeed <= 38) {
      bf = 5;
    } else if (windSpeed >= 39 && windSpeed <= 49) {
      bf = 6;
    } else if (windSpeed >= 50 && windSpeed <= 61) {
      bf = 7;
    } else if (windSpeed >= 62 && windSpeed <= 74) {
      bf = 8;
    } else if (windSpeed >= 75 && windSpeed <= 88) {
      bf = 9;
    } else if (windSpeed >= 89 && windSpeed <= 102) {
      bf = 10;
    } else if (windSpeed >= 103 && windSpeed <= 117) {
      bf = 11;
    }

    if (returnType == "label") {
      return getBeaufortLabel(bf);
    } else {
      return Integer.toString(bf);
    }

  }
  /**
   * getBeaufortLabel() - Returns Beaufort Label
   *
   * @param beaufort list of beaufort
   * @return latestBeaufortLabel as Label
   */
  public static String getBeaufortLabel(int beaufort ) {
    HashMap<Integer, String> beaufortLabel = new HashMap<Integer, String>();

    beaufortLabel.put(0, "Calm");
    beaufortLabel.put(1, "Light Air");
    beaufortLabel.put(2, "Light Breeze");
    beaufortLabel.put(3, "Gentle Breeze");
    beaufortLabel.put(4, "Moderate Breeze");
    beaufortLabel.put(5, "Fresh Breeze");
    beaufortLabel.put(6, "Strong Breeze");
    beaufortLabel.put(7, "Near Gale");
    beaufortLabel.put(8, "Gale");
    beaufortLabel.put(9, "Severe Gale");
    beaufortLabel.put(10, "Strong Storm");
    beaufortLabel.put(11, "Violent Storm");

    String latestBeaufortLabel = beaufortLabel.get(beaufort);

    return latestBeaufortLabel;
  }

  /**
   * convertToFahrenheit() -  converts Temperature from celsius to fahrenheit
   *
   * @param temperature passed in temperature
   * @return roundCalculation to two decimal places
   */
  public static double convertToFahrenheit(double temperature) {
    double fahrenheit = temperature * 9 / 5 + 32;
    return roundCalculation(fahrenheit,2);
  }

  /**
   * convertWeatherCode() -  converts code to text value
   *
   * @param code passed in weather code
   * @return weatherCode code converted to text
   */
  public static String convertWeatherCode(int code) {
    HashMap<Integer, String> weatherCodeMap = new HashMap<Integer, String>();

    weatherCodeMap.put(100, "Clear");
    weatherCodeMap.put(200, "Partial Clouds");
    weatherCodeMap.put(300, "Cloudy");
    weatherCodeMap.put(400, "Light Showers");
    weatherCodeMap.put(500, "Heavy Showers");
    weatherCodeMap.put(600, "Rain");
    weatherCodeMap.put(700, "Snow");
    weatherCodeMap.put(800, "Thunder");

    String weatherCode = weatherCodeMap.get(code);

    return weatherCode;
  }

  /**
   * convertDegreeToDirection() -  converts code to text value
   *
   * @param windDirection passed in wind direction
   * @return windDirectionText windDirection converted to text
   */
  public static String convertDegreeToDirection(double windDirection) {
    String windDirectionText = "";

    if (windDirection >= 0 && windDirection <= 11.25 || windDirection >= 348.75 && windDirection <= 360.00) {
      windDirectionText = "N";
    } else if (windDirection >= 11.25 && windDirection < 33.75) {
      windDirectionText = "NNE";
    } else if (windDirection >= 33.75 && windDirection < 56.25) {
      windDirectionText = "NE";
    } else if (windDirection >= 56.25 && windDirection < 78.75) {
      windDirectionText = "ENE";
    } else if (windDirection >= 78.75 && windDirection < 101.75) {
      windDirectionText = "E";
    } else if (windDirection >= 101.25 && windDirection < 123.75) {
      windDirectionText = "ESE";
    } else if (windDirection >= 123.75 && windDirection < 146.25) {
      windDirectionText = "SE";
    } else if (windDirection >= 146.25 && windDirection < 168.75) {
      windDirectionText = "SSE";
    } else if (windDirection >= 168.75 && windDirection < 191.25) {
      windDirectionText = "S";
    } else if (windDirection >= 191.25 && windDirection < 213.75) {
      windDirectionText = "SSW";
    } else if (windDirection >= 213.75 && windDirection < 236.25) {
      windDirectionText = "SW";
    } else if (windDirection >= 236.25 && windDirection < 258.75) {
      windDirectionText = "WSW";
    } else if (windDirection >= 258.75 && windDirection < 281.25) {
      windDirectionText = "W";
    } else if (windDirection >= 281.25 && windDirection < 303.75) {
      windDirectionText = "WNW";
    } else if (windDirection >= 303.75 && windDirection < 326.75) {
      windDirectionText = "NW";
    } else if (windDirection >= 326.25 && windDirection < 348.75) {
      windDirectionText = "NNW";
    } else {
      windDirectionText = "Out of Range";
    }

    return windDirectionText;
  }

  /**
   * calculateWindChill() -  converts code to text value
   *
   * @param temperature passed in temperature
   * @param windSpeed passed in windSpeed
   * @return calcualted wind chill
   */
  public static double calculateWindChill(double temperature, double windSpeed) {
    return roundCalculation(13.12 + (0.6215 * temperature) - 11.37 * (Math.pow(windSpeed, 0.16)) + 0.3965 * temperature * (Math.pow(windSpeed, 0.16)),2);
  }

  /**
   * roundCalculation() -  converts code to text value
   *
   * @param value passed in value to round
   * @param places phow many places to round to
   * @return rounded value
   */
  public static double roundCalculation(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
  }
}

