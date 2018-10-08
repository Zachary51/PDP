package edu.neu.ccs.cs5010.assignment3.TheaterReservations;

/**
 * This class is used to create a seat object
 */
public class Seat {
  private String seatName;
  private String reservedFor;

  /**
   * Construct a seat object with following fields
   * @param seatName
   * @param reservedFor
   */
  public Seat(String seatName, String reservedFor) {
    this.seatName = seatName;
    this.reservedFor = reservedFor;
  }

  /**
   * @return the name of the seat
   */
  public String getSeatName() {
    return seatName;
  }

  /*
   * @return the name of this seat reserved for
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Set the seat reserved for
   * @param reservedFor
   */
  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }
}
