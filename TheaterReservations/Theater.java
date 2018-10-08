package edu.neu.ccs.cs5010.assignment3.TheaterReservations;

import java.util.ArrayList;

/**
 * This class is used to create a theater object
 */
public class Theater {
  private String name;
  private int numberOfRows;
  private int seatsOnEachRow;
  private ArrayList<Row> theaterRows;
  private int wheelChairSection;

  /**
   * Construct a theater object with following fields
   * When constructing a theater object, it will automatically construct row object and
   * wheelchair row object at the same time
   * @param name
   * @param numberOfRows
   * @param seatsOnEachRow
   * @param wheelChairSection
   */
  public Theater(String name, int numberOfRows, int seatsOnEachRow, int wheelChairSection) {
    this.name = name;
    this.numberOfRows = numberOfRows;
    this.seatsOnEachRow = seatsOnEachRow;
    this.wheelChairSection = wheelChairSection;
    this.theaterRows = new ArrayList<>();
    for(int i = 0; i < numberOfRows - wheelChairSection; i++) {
      this.theaterRows.add(i, new Row(i + 1, seatsOnEachRow, false));
    }
    for(int i = numberOfRows - wheelChairSection; i < numberOfRows; i++){
      this.theaterRows.add(i, new Row(i + 1, seatsOnEachRow, true));
    }

  }

  /**
   * @return the list of number which indicates which rows are accessible
   */
  public ArrayList<Integer> accessibleSeats(){
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 0; i < numberOfRows; i++){
      for(int j = 0; j < seatsOnEachRow; j++){
        ArrayList<Seat> currentSeats = this.theaterRows.get(i).getSeats();
        Seat currentSeat = currentSeats.get(j);
        if(currentSeat.getReservedFor() == null){
          result.add(i + 1);
          break;
        }
      }
    }
    return result;
  }

  /**
   * @return the number of wheelchair rows
   */
  public int getWheelChairSection() {
    return wheelChairSection;
  }

  /**
   * @return the name of this theater
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of this theater
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the number of rows
   */
  public int getNumberOfRows() {
    return numberOfRows;
  }

  /**
   * Set the number of rows
   * @param numberOfRows
   */
  public void setNumberOfRows(int numberOfRows) {
    this.numberOfRows = numberOfRows;
  }

  /**
   * @return the number of seats on each row
   */
  public int getSeatsOnEachRow() {
    return seatsOnEachRow;
  }

  /**
   * @param seatsOnEachRow set the number of seats on each row
   */
  public void setSeatsOnEachRow(int seatsOnEachRow) {
    this.seatsOnEachRow = seatsOnEachRow;
  }

  /**
   * @return the array list of row objects
   */
  public ArrayList<Row> getTheaterRows() {
    return theaterRows;
  }

}
