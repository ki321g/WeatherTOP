package utilities;

public class Conversions {
  public static String convertToBeaufort(double windSpeed, String returnType) {
    int bf = 0;
    String bfLabel  = "";

    if (windSpeed == 1) {
      bf = 0;
      bfLabel= "Calm";
    } else if (windSpeed >= 2 && windSpeed <= 5) {
      bf = 1;
      bfLabel= "Light Air";
    } else if (windSpeed >= 6 && windSpeed <= 11) {
      bf = 2;
      bfLabel= "Light Breeze";
    } else if (windSpeed >= 12 && windSpeed <= 19) {
      bf = 3;
      bfLabel= "Gentle Breeze";
    } else if (windSpeed >= 20 && windSpeed <= 28) {
      bf = 4;
      bfLabel= "Moderate Breeze";
    } else if (windSpeed >= 29 && windSpeed <= 38) {
      bf = 5;
      bfLabel= "Fresh Breeze";
    } else if (windSpeed >= 39 && windSpeed <= 49) {
      bf = 6;
      bfLabel= "Strong Breeze";
    } else if (windSpeed >= 50 && windSpeed <= 61) {
      bf = 7;
      bfLabel= "Near Gale";
    } else if (windSpeed >= 62 && windSpeed <= 74) {
      bf = 8;
      bfLabel= "Gale";
    } else if (windSpeed >= 75 && windSpeed <= 88) {
      bf = 9;
      bfLabel= "Severe Gale";
    } else if (windSpeed >= 89 && windSpeed <= 102) {
      bf = 10;
      bfLabel= "Strong Storm";
    } else if (windSpeed >= 103 && windSpeed <= 117) {
      bf = 11;
      bfLabel= "Violent Storm";
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


}
