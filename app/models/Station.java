package models;

import play.Logger;
import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This model class is used for Stations
 *
 * @author Kieron GArvey
 * @version 0.1
 */
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
  public String temperatureTrend;
  public String windSpeedTrend;
  public String pressureTrend;

  /**
   * Station() - This constructor creates the new Station
   *
   * @param name Station name
   * @param latitude Station latitude
   * @param longitude Station longitude
   */
  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * latestReading() - Returns a list of the latest readings
   *
   * @param readingSize amount of Readings to return
   * @return latestReadings list of readings
   */
  public List<Reading> latestReading(int readingSize) {
    List<Reading> latestReadings = null;
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - readingSize, readings.size());
    }
    return latestReadings;
  }

  /**
   * latestReading() - Returns a sorted list of stations
   *
   * @param stations liost of stations
   * @return stations list of sorted stations
   */
  public static List<Station> sortStations(List<Station> stations) {
    stations.sort(Comparator.comparing(Station::getName, String.CASE_INSENSITIVE_ORDER));
    Logger.info("Sorting Stations Alphabetically");
    return stations;
  }

  /**
   * getSortedReadings() - Returns a list of the sorted readings
   *
   * @return readingSort list of sorted readings
   */
  public List<Reading> getSortedReadings() {
    List<Reading> readingSort = Reading.sortReadings(this.readings);
    Logger.info("Edit readingSort: " + readingSort);
    return readingSort;
  }

  /**** Getters ****/
  public String getName() {
    return name;
  }
}

