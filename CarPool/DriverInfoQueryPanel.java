package edu.neu.ccs.cs5010.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 * This class is used to mimic a query panel which for users to query
 * the drivers' information.
 */
public class DriverInfoQueryPanel {
  private AcceptedDriversPool acceptedDriversPool;

  /**
   * Construct a driver information panel object.
   * @param acceptedDriversPool the collection of accepted drivers.
   */
  public DriverInfoQueryPanel(AcceptedDriversPool acceptedDriversPool) {
    this.acceptedDriversPool = acceptedDriversPool;
  }

  /**
   * Return the accepted drivers pool object.
   * @return the collection of accepted drivers.
   */
  public AcceptedDriversPool getAcceptedDriversPool() {
    return acceptedDriversPool;
  }

  /**
   * Return the driver's information according to the last name the
   * user inputs.
   * @param lastName the last name.
   */
  public void provideDriverInfo(String lastName) {
    ArrayList<Drivers> queryDrivers = new ArrayList<>();
    for (Drivers drivers : this.acceptedDriversPool.getAcceptedDrivers()) {
      if (drivers.getLastName().equals(lastName)) {
        queryDrivers.add(drivers);
      }
    }

    if (queryDrivers.isEmpty()) {
      System.out.println("No registered driver found!");
    }

    Collections.sort(queryDrivers, new Comparator<Drivers>() {
      @Override
      public int compare(Drivers driver1, Drivers driver2) {
        return driver1.getFirstName().compareTo(driver2.getFirstName());
      }
    });

    for (Drivers queryDriver : queryDrivers) {
      ArrayList<VehicleInformation> vehicleInformationList =
          this.acceptedDriversPool.getRegisterMap().get(queryDriver);
      System.out.println(queryDriver.getLastName() + ", " + queryDriver.getFirstName());
      for (VehicleInformation vehicleInformation : vehicleInformationList) {
        System.out.println("\t" + vehicleInformation.getYear() + " " + vehicleInformation.getColor()
            + " " + vehicleInformation.getMake() + " " + vehicleInformation.getModel());
      }

      if (!queryDriver.getDriverHistory().getViolationHashMap().isEmpty()) {
        System.out.println("\tDriving Violations:");
        for (Violation violation : queryDriver.getDriverHistory().getViolationHashMap().values()) {
          if (violation.getCrush() != null) {
            System.out.println("\t" + violation.getCrush().toString());
          }
          if (violation.getMovingViolation() != null) {
            System.out.println("\t" + violation.getMovingViolation().toString());
          }
          if (violation.getNonMovingViolation() != null) {
            System.out.println("\t" + violation.getNonMovingViolation().toString());
          }
        }
      }
    }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverInfoQueryPanel that = (DriverInfoQueryPanel) o;
    return Objects.equals(acceptedDriversPool, that.acceptedDriversPool);
  }

  @Override
  public int hashCode() {

    return Objects.hash(acceptedDriversPool);
  }
}
