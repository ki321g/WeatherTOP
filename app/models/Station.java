package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  public double latitude;
  public double longitude;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public double minTemperature;
  public double maxTemperature;

  public int minPressure;
  public int maxPressure;

  public double minWindSpeed;
  public double maxWindSpeed;

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
/*
  public Station(String name) {
    this.name = name;
  }
 */

  public String getName() {
    return name;
  }


  /* If i get time i am planning on drawing a graph of up to the last 10 readings
   * I found arraylist subList https://www.geeksforgeeks.org/arraylist-sublist-method-in-java-with-examples/
   * https://www.geeksforgeeks.org/find-first-and-last-element-of-arraylist-in-java/
   * Might not use this
   */
  /*
  public List<Reading> latestReadings() {
    List<Reading> latestReadings = null;
      latestReadings = readings.subList(readings.size() - 1, readings.size());
    return latestReadings;
  }
  */
  public List<Reading> latestReading() {
    List<Reading> latestReadings = null;
    //latestReadings = readings.get(readings.size() - 1).getCode();
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - 1, readings.size());
      //  latestReadings = readings.(readings.size() - 1);
    }
    return latestReadings;
  }
}

