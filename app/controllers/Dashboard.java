package controllers;

import java.time.LocalDateTime;
import java.util.List;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utilities.Calculations;

/**
 * This class renders the Dashboard
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Dashboard extends Controller {
  /**
   * index() - This method renders dasboard.html passing in the relevant Stations,
   * It gets the the logged in member then uses this member
   * to get the relevant Staions and then Sorts the Stations
   *
   */
  public static void index() {
    Logger.info("Rendering Dashboard");
    Logger.info("Current Local Date Time: " + LocalDateTime.now());
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.sortStations(member.stations);
    for (Station station : stations) {
      Calculations.calculateConditions(station);
    }
    render("dashboard.html", stations);
  }

}
