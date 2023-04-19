package utilities;

public class Conversions {
  public static String convertToBeaufort(double windSpeed, String returnType) {
    int bf = 0;
    String bfLabel = "";

    if (windSpeed == 1) {
      bf = 0;
      bfLabel = "Calm";
    } else if (windSpeed >= 2 && windSpeed <= 5) {
      bf = 1;
      bfLabel = "Light Air";
    } else if (windSpeed >= 6 && windSpeed <= 11) {
      bf = 2;
      bfLabel = "Light Breeze";
    } else if (windSpeed >= 12 && windSpeed <= 19) {
      bf = 3;
      bfLabel = "Gentle Breeze";
    } else if (windSpeed >= 20 && windSpeed <= 28) {
      bf = 4;
      bfLabel = "Moderate Breeze";
    } else if (windSpeed >= 29 && windSpeed <= 38) {
      bf = 5;
      bfLabel = "Fresh Breeze";
    } else if (windSpeed >= 39 && windSpeed <= 49) {
      bf = 6;
      bfLabel = "Strong Breeze";
    } else if (windSpeed >= 50 && windSpeed <= 61) {
      bf = 7;
      bfLabel = "Near Gale";
    } else if (windSpeed >= 62 && windSpeed <= 74) {
      bf = 8;
      bfLabel = "Gale";
    } else if (windSpeed >= 75 && windSpeed <= 88) {
      bf = 9;
      bfLabel = "Severe Gale";
    } else if (windSpeed >= 89 && windSpeed <= 102) {
      bf = 10;
      bfLabel = "Strong Storm";
    } else if (windSpeed >= 103 && windSpeed <= 117) {
      bf = 11;
      bfLabel = "Violent Storm";
    }

    if (returnType == "label") {
      return bfLabel;
    } else {
      return Integer.toString(bf);
    }

  }


  public static double convertToFahrenheit(double temperature) {
    double fahrenheit = temperature * 9 / 5 + 32;
    return fahrenheit;
  }

  public static String convertWeatherCode(int code) {
    String weatherCode = "";

    switch (code) {
      case 100:
        weatherCode = "Clear";
        break;
      case 200:
        weatherCode = "Partial clouds";
        break;
      case 300:
        weatherCode = "Cloudy";
        break;
      case 400:
        weatherCode = "Light Showers";
        break;
      case 500:
        weatherCode = "Heavy Showers";
        break;
      case 600:
        weatherCode = "Rain";
        break;
      case 700:
        weatherCode = "Snow";
        break;
      case 800:
        weatherCode = "Thunder";
        break;
    }

    return weatherCode;
  }

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
  public static double calculateWindChill(double temperature, double windSpeed) {
    return roundCalculation(13.12 + (0.6215 * temperature) - 11.37 * (Math.pow(windSpeed, 0.16)) + 0.3965 * temperature * (Math.pow(windSpeed, 0.16)),2);
  }
  public static double roundCalculation(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
  }
}

