package controllers;

import play.*;
import play.mvc.*;
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
    Station station = new Station(name, latitude, longitude);
    station.save();

    redirect("/station/" + station.id);
  }
  public static void deletestation(Long id) {
    Station station;
    if (Station.findById(id) != null) {
      station = Station.findById(id);
      Logger.info("Deleting Station " + station.name);
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
}
