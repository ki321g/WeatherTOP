package controllers;

import play.*;
import play.mvc.*;

/**
 * This class renders the about page
 *
 * @author Kieron GArvey
 * @version 0.1
 */
public class About extends Controller {
  /**
   * index() - This method renders about.html
   *
   */
  public static void index() {
    Logger.info("Rendering about");
    render("about.html");
  }
}
