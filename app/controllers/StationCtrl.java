package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

import java.util.List;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    render("station.html", station);
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
}
