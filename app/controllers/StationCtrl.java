package controllers;

import play.*;
import play.mvc.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import models.*;
import utilities.Calculations;

import java.util.List;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    Calculations.calculateConditions(station);
    render("station.html", station);
  }

  public static void addStation(String name, double latitude, double longitude) {
    Logger.info("Adding Station: " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/station/" + station.id);
  }
  public static void deletestation(Long id) {
    Station station;
    if (Station.findById(id) != null) {
      Member member = Accounts.getLoggedInMember();
      station = Station.findById(id);
      Logger.info("Deleting Station " + station.name);
      member.stations.remove(station);
      member.save();
      station.delete();
    } else {
      Logger.info("Station id#" + id + " doesnt exist");
    }
    List<Station> stations = Station.findAll();
    redirect("/dashboard");
  }

  public static void deletereading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    if (station.readings.contains(reading)) {
      Logger.info("Removing Reading id# " + reading.id);
      station.readings.remove(reading);
      station.save();
      reading.delete();
    } else {
      Logger.info("Reading id# " + readingid + " doesnt exist");
    }
    redirect("/station/" + id);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Logger.info("Adding Reading: " + id);
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/station/" + id);
  }
  public static void editReading(Long id, Long readingid, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Logger.info("Edit Reading: " + readingid);
    Reading reading = Reading.findById(readingid);

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Create DateTimeFormatter

    reading.dateTime  = FORMATTER.format(LocalDateTime.now()); //Get Current Date Time & Set formatted String
    reading.code = code;
    reading.temperature = temperature;
    reading.windSpeed = windSpeed;
    reading.windDirection = windDirection;
    reading.pressure = pressure;
    reading.save();

    redirect("/station/" + id);
  }

}
