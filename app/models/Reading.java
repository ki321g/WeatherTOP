package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;

  public Reading(int code, double temperature, double windSpeed, int pressure) {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
  }
  public double fahrenheit () {
    double fahrenheit = this.temperature * 9 / 5 + 32;
    return fahrenheit;
  }

  public int beaufort () {
    int bf = 0;

    if (this.windSpeed == 1) {
      bf = 0;
    } else if (this.windSpeed >= 2 && this.windSpeed <= 5) {
      bf = 1;
    } else if (this.windSpeed >= 6 && this.windSpeed <= 11) {
      bf = 2;
    } else if (this.windSpeed >= 12 && this.windSpeed <= 19) {
      bf = 3;
    } else if (this.windSpeed >= 20 && this.windSpeed <= 28) {
      bf = 4;
    } else if (this.windSpeed >= 29 && this.windSpeed <= 38) {
      bf = 5;
    } else if (this.windSpeed >= 39 && this.windSpeed <= 49) {
      bf = 6;
    } else if (this.windSpeed >= 50 && this.windSpeed <= 61) {
      bf = 7;
    } else if (this.windSpeed >= 62 && this.windSpeed <= 74) {
      bf = 8;
    } else if (this.windSpeed >= 75 && this.windSpeed <= 88) {
      bf = 9;
    } else if (this.windSpeed >= 89 && this.windSpeed <= 102) {
      bf = 10;
    } else if (this.windSpeed >= 103 && this.windSpeed <= 117) {
      bf = 11;
    }

    return bf;
  }

  public String weatherCode(int code){
    String weatherCode = "";

    switch(code) {
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
//  public String weatherConditions ()  {
  //  return Conversions.weatherCodeToText(code); }



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