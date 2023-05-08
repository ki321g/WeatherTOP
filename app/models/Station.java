package models;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gson.*;
import com.google.gson.JsonArray;
import org.h2.util.json.JSONArray;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.google.gson.Gson;
import org.h2.util.json.JSONObject;
import play.Logger;
import play.db.jpa.Model;
import play.utils.HTML;

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

  //https://stackoverflow.com/questions/30096229/using-javascript-in-play-template

  /*public void chartDataPressure() {
    //public Result chartDataPressure() {
    // For JS you need an array of arrays, so use a List of Lists in Java
    List<List<Object>> myValues = new ArrayList<>();
    Gson gson = new Gson();

    // create a writer
    Writer writer = Files.newBufferedWriter(Paths.get("readings.json"));


    // Inserting  data,
    for (Reading reading : readings) {
      String date = "'" + reading.dateTime + "'";
      myValues.add(new ArrayList<Object>(Arrays.asList(date, reading.pressure)));

      // convert user object to JSON file
      gson.toJson(reading, writer);

    }

    // close writer
    writer.close();

        //String jsonString = gson.toJson(myValues);


    Logger.info("myValues Json " + );
    Logger.info("myValues " + myValues);
    //return myValues;
  }
  */

/*
  public List<List<Object>> chartDataPressure() {

  //public Result chartDataPressure() {
    // For JS you need an array of arrays, so use a List of Lists in Java
    List<List<Object>> myValues = new ArrayList<>();

    // Add the header
    myValues.add(new ArrayList<Object>(Arrays.asList("date", "pressure")));

    // Inserting  data,
    for(Reading reading : readings) {
      String date = "'" + reading.dateTime +"'";
      myValues.add(new ArrayList<Object>(Arrays.asList(date, reading.pressure)));
    }

    Logger.info("myValues " + myValues);
    return myValues;


  }
  */
  public List<Integer> chartDataPressure() {
    //public Result chartDataPressure() {
    // For JS you need an array of arrays, so use a List of Lists in Java
    List<Integer> myValues = new ArrayList<>();

    // Inserting  data,
    for(Reading reading : readings) {
      myValues.add(reading.pressure);
    }

    Logger.info("myValues " + myValues);
    return myValues;


  }


  public  List<String>  chartDataDate() {
    //public Result chartDataPressure() {
    // For JS you need an array of arrays, so use a List of Lists in Java
    List<String> myValues = new ArrayList<>();

    // Inserting  data,
    for(Reading reading : readings) {
      String date = "'" + reading.dateTime +"'";
      myValues.add(date);
    }

    Logger.info("myValues " + myValues);
    return myValues;
  }

}

