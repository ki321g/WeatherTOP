package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utilities.Analytics;
import utilities.Calculations;
import utilities.Conversions;


public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");

  /*  List<Station> stations = Station.findAll();*/
    List<Station> stations = Station.sortStations(Station.findAll());

    for (Station station : stations) {
      Calculations.calculateConditions(station);
    }

    render("dashboard.html", stations);
  }

}
