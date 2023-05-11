package controllers;

    import play.*;
    import play.mvc.*;
    import models.*;
    import java.util.List;
public class Stations extends Controller {
  public static void index() {
    Logger.info("Rendering Stations");
    List<Station> stations = Station.sortStations(Station.findAll());
    render("stations.html", stations);
  }
  public static void summary() {
    Logger.info("Rendering Station Summary");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.sortStations(member.stations);
    render("stationsummary.html", stations);
  }
}

