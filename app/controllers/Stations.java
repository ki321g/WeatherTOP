package controllers;

    import play.*;
    import play.mvc.*;
    import models.*;
    import java.util.List;

/**
 * This class renders the Stations summary
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Stations extends Controller {
  /**
   * index() - This method renders stations.html passing in the relevant Stations,
   * This method finds all stations regardless of member and displays them all.
   * This method if used for non logged in members
   *
   */
  public static void index() {
    Logger.info("Rendering Stations");
    List<Station> stations = Station.sortStations(Station.findAll());
    render("stations.html", stations);
  }

  /**
   * summary() - This method renders stationsummary.html passing in the relevant Stations,
   * This method finds all a members stations displays them all stationsummary.html
   *
   */
  public static void summary() {
    Logger.info("Rendering Station Summary");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.sortStations(member.stations);
    render("stationsummary.html", stations);
  }
}

