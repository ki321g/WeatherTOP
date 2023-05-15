package controllers;

import play.*;
import play.mvc.*;
import models.*;
import utilities.Calculations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class controls Stations and relevant Station Readings.
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class StationCtrl extends Controller {
  /**
   * index() - This method renders station.html
   * Method finds the relevant Station by ID
   * then Calculates that stations Conditions and
   * passes the station back to the station.html file
   *
   * @param id Station ID
   */
  public static void index(Long id) {
    boolean checkMemberStations = false;
    Member member = Accounts.getLoggedInMember();
    List<Station> stationsToCheck = member.stations;

    for (Station stationCheck : stationsToCheck) {
      Logger.info("stationCheck " + stationCheck.id);
      if (stationCheck.id.equals(id)) {
        checkMemberStations = true;
      }
    }
    if (member != null && checkMemberStations) {
      Logger.info("Rendering Station id#" + id);
      Station station = Station.findById(id);
      Calculations.calculateConditions(station);
      render("station.html", station);
    } else if (!checkMemberStations) {
      Logger.info("Station not Members");
      redirect("/dashboard");
    } else {
      Logger.info("Member not logged in");
      redirect("/login");
    }
  }

  /**
   * addStation() - This method redirects to station url
   * Method uses passed in params to create a new Station
   * for teh logged in member then redirects the member to
   * the new station to enter there first reading.
   *
   * @param name      Station name
   * @param latitude  Station latitude
   * @param longitude Station longitude
   */
  public static void addStation(String name, double latitude, double longitude) {
    Logger.info("Adding Station: " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/station/" + station.id);
  }

  /**
   * deletestation() - This method redirects to dashboard url
   * Method uses passed in Station ID delete the station.
   *
   * @param id Station ID
   */
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

  /**
   * deletereading() - This method redirects to the relevant station
   * Method uses passed in Station ID and Reading ID to find the relevant
   * Station and Reading. It then deletes the reading.
   *
   * @param id        Station ID
   * @param readingid Reading readingid
   */
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

  /**
   * addReading() - This method redirects to the relevant station
   * Method uses passed in Reading params to create a new reading
   * for the passed in Station ID
   *
   * @param id            Station ID
   * @param code          Reading code
   * @param temperature   Reading temperature
   * @param windSpeed     Reading windSpeed
   * @param windDirection Reading windDirection
   * @param pressure      Reading pressure
   */
  public static void addReading(Long id, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Logger.info("Adding Reading: " + id);
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect("/station/" + id);
  }

  /**
   * editReading() - This method redirects to the relevant station
   * Method uses passed in the new Reading params to edit a the reading
   *
   * @param id            Station ID
   * @param readingid     Station readingid
   * @param code          Reading code
   * @param temperature   Reading temperature
   * @param windSpeed     Reading windSpeed
   * @param windDirection Reading windDirection
   * @param pressure      Reading pressure
   */
  public static void editReading(Long id, Long readingid, int code, double temperature, double windSpeed, double windDirection, int pressure) {
    Logger.info("Edit Reading: " + readingid);
    Reading reading = Reading.findById(readingid);
    reading.code = code;
    reading.temperature = temperature;
    reading.windSpeed = windSpeed;
    reading.windDirection = windDirection;
    reading.pressure = pressure;
    reading.save();
    redirect("/station/" + id);
  }
}
