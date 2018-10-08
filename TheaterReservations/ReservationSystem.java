package edu.neu.ccs.cs5010.assignment3.TheaterReservations;

import java.util.Scanner;

public class ReservationSystem {
  public static void main(String[] args) {
    ReservationsService reservationsService = new ReservationsService(
        new Theater("Cinema", 15, 10, 2));
    Scanner sc = new Scanner(System.in);
    int numberOfRequestSeats;
    String customerName;
    boolean quit = false;

    while (!quit) {
      System.out.println();
      System.out.println("What would you like to do?");
      String request = sc.nextLine();
      if (request.startsWith("reserve")) {
        String[] reserveRequest = request.split("\\s+");
        numberOfRequestSeats = Integer.valueOf(reserveRequest[1]);

        System.out.println("Do you need wheelchair accessible seats");
        String answer = sc.nextLine();

        if(answer.equals("no")){
          System.out.println("What's your name?");
          customerName = sc.nextLine();
          int rowNumber = reservationsService.seatSelection(numberOfRequestSeats, customerName);
          if (rowNumber > 0) {
            System.out.println("I've reserved " + numberOfRequestSeats + " seats for you at the "
                + reservationsService.getTheater().getName()
                + " in row " + rowNumber + ", " + customerName + ".");

          } else {
            System.out.println("Sorry, we don't have enough seats for you.");
          }
        } else if(answer.equals("yes")){
          System.out.println("What's your name?");
          customerName = sc.nextLine();
          int rowNumber = reservationsService.wheelchairSeatSelection(numberOfRequestSeats, customerName);
          if(rowNumber > 0){
            System.out.println("I've reserved " + numberOfRequestSeats + " seats for you at the "
                + reservationsService.getTheater().getName()
                + " in row " + rowNumber + ", " + customerName + ".");
          } else {
            System.out.println("Sorry, we don't have enough seats for you.");
          }
        }

      } else if (request.equals("show")) {
        reservationsService.showSeats();

      } else if(request.equals("done")){
        System.out.println("Have a nice day!");
        quit = true;
      } else {
        System.out.println("Please enter the valid answer");
      }
    }

  }
}
