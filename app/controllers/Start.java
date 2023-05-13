package controllers;

import play.Logger;
import play.mvc.Controller;

/**
 * This class renders the start page
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class Start extends Controller {
  /**
   * index() - This method renders start.html
   *
   */
  public static void index() {
    Logger.info("Rendering Start");
    render("start.html");
  }
}
