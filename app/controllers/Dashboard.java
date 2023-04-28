package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Member;
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
    Logger.info("Current Local Date Time: "+ LocalDateTime.now());
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.sortStations(member.stations);
   // List<Station> stations = member.stations;
    for (Station station : stations) {
      Calculations.calculateConditions(station);
    }
    render("dashboard.html", stations);
  }

}
