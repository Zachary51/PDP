package edu.neu.ccs.cs5010.assignment3.TheaterReservations;

import java.util.ArrayList;

/**
 * This class is used to create a row object, which represents a list of seats
 */
public class Row{
  private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private ArrayList<Seat> seats;
  private int rowNumber;
  private int numberOfSeats;
  private boolean wheelchair;

  /**
   * Construct a row object with following fields
   * When constructing a row, it will automatically set name for each seat in this row
   * @param rowNumber
   * @param numberOfSeats
   * @param wheelchair
   */
  public Row(int rowNumber, int numberOfSeats, boolean wheelchair) {
    this.rowNumber = rowNumber;
    this.numberOfSeats = numberOfSeats;
    this.wheelchair = wheelchair;
    this.seats = new ArrayList<>();
    for(int i = 0; i < numberOfSeats; i++){
      this.seats.add(i, new Seat(Character.toString(alphabet.charAt(i)), null));
    }
  }

  /*
   * @return whether this row is special for wheelchair
   */
  public boolean isWheelchair() {
    return wheelchair;
  }

  /**
   * @return the array list of seat objects
   */
  public ArrayList getSeats() {
    return this.seats;
  }

  /**
   * @return the row number of this row
   */
  public int getRowNumber() {
    return rowNumber;
  }

  /**
   * Change the row number of this row
   * @param rowNumber
   */
  public void setRowNumber(int rowNumber) {
    this.rowNumber = rowNumber;
  }

  /**
   * @return the number of seats of this row
   */
  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  /**
   * Set the number of seats of this row
   * @param numberOfSeats
   */
  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }
}
