package models;

import play.Logger;
import play.db.jpa.Model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
  public String getName() {
    return name;
  }

  public List<Reading> latestReading(int readingSize) {
    List<Reading> latestReadings = null;
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - readingSize, readings.size());
    }
    return latestReadings;
  }
  public static List<Station> sortStations(List<Station> stations) {
    stations.sort(Comparator.comparing(Station::getName, String.CASE_INSENSITIVE_ORDER));
    Logger.info("Sorting Stations Alphabetically");
    return stations;
  }
  public List<Reading> getSortedReadings() {
    List<Reading> readingSort = Reading.sortReadings(this.readings);
    Logger.info("Edit readingSort: " + readingSort);
    return readingSort;
  }
}

