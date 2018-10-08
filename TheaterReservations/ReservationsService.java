package edu.neu.ccs.cs5010.assignment3.TheaterReservations;

import java.util.ArrayList;

/**
 * This class will implement the actual reservation service
 */
public class ReservationsService {
  private Theater theater;

  /**
   * Constructor takes a theater as its argument
   * @param theater
   */
  public ReservationsService(Theater theater){
    this.theater = theater;
  }

  /*
   * @return the theater object
   */
  public Theater getTheater() {
    return theater;
  }

  /**
   * A helper function used to register seats for customers
   * @param i the index of row
   * @param j the index of column
   * @param username the name of the customer
   */
  public void register(int i, int j, String username){
    ArrayList<Seat> seats = this.theater.getTheaterRows().get(i).getSeats();
    Seat seat = seats.get(j);
    seat.setReservedFor(username);
  }

  /**
   * This method is used to reserve seats for people who wants a wheel chair section seat
   * @param numberOfPeople
   * @param name
   * @return the row number of seat if reserve successfully. If it fails to reserve, it will return -1
   */
  public int wheelchairSeatSelection(int numberOfPeople, String name){
    int rows = this.theater.getWheelChairSection();
    int totalRows = this.theater.getNumberOfRows();
    int cols = this.theater.getSeatsOnEachRow();
    int start = totalRows - rows ;
    while(start < totalRows){
      int currentSize = 0;
      for(int k = 0; k < this.theater.getTheaterRows().get(start).getSeats().size(); k++){
        ArrayList<Seat> currentWheelchairRow = this.theater.getTheaterRows().get(start).getSeats();
        Seat currentWheelchair = currentWheelchairRow.get(k);
        if(currentWheelchair.getReservedFor() != null){
          currentSize++;
        }
      }
      if(currentSize + numberOfPeople <= cols){
        for(int i = currentSize; i < currentSize + numberOfPeople; i++){
          register(start, i, name);
        }
        return start + 1;
      } else {
        start++;
      }
    }
    return -1;
  }

  /**
   * This method is used to select best seats for customers according to the current number of
   * accessible seats and number of seats the customer want to reserve
   * @param numberOfPeople
   * @param name
   * @return the row number when reserve successfully. If it fails to reserve seats, it will return -1
   */
  public int seatSelection(int numberOfPeople, String name){
    int rows = this.theater.getNumberOfRows() - this.theater.getWheelChairSection();
    int cols = this.theater.getSeatsOnEachRow();
    int middle = rows /2;
    int count = 0;
    while(middle < rows && middle >= 0){
      int currentSize = 0;
      for(int k = 0; k < this.theater.getTheaterRows().get(middle).getSeats().size(); k++){
        ArrayList<Seat> currentRow = this.theater.getTheaterRows().get(middle).getSeats();
        Seat currentSeat = currentRow.get(k);
        if(currentSeat.getReservedFor() != null){
          currentSize++;
        }
      }
      if(currentSize + numberOfPeople <= cols){
        for(int i = currentSize; i < currentSize + numberOfPeople; i++){
          register(middle, i, name);
        }
        return middle + 1;
      } else {
        count++;
        if(count % 2 != 0){
          middle = middle - count;
        } else {
          middle = middle + count;
        }
      }
    }
    return -1;
  }

  /**
   * This method is used to print out the seats
   */
  public void showSeats(){
    int rows = this.theater.getNumberOfRows();
    int cols = this.theater.getSeatsOnEachRow();
    String[][] seatsTable = new String[rows][cols];
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        Row currentRow = this.theater.getTheaterRows().get(i);
        ArrayList<Seat> seats = this.theater.getTheaterRows().get(i).getSeats();
        Seat seat = seats.get(j);
        if(seat.getReservedFor() == null){
          if(currentRow.isWheelchair()){
            seatsTable[i][j] = " =";
          } else {
            seatsTable[i][j] = " _";
          }
        } else {
          seatsTable[i][j] = " X";
        }
      }
    }
    for(int i = 0; i < rows; i++){
      System.out.println();
      System.out.printf("%2d", i + 1);
      for(int j = 0; j < cols; j++){
        System.out.print(seatsTable[i][j]);
      }
    }
  }

}
