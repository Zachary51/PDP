package edu.neu.ccs.cs5010.assignment4;

import java.util.Objects;

/**
 * This class is used to combine all the information about the driver and his or her
 * vehicle. Because all the information we need in the registration validator are allocated
 * in different classes, so we need this intermediate class to integrate all these information.
 */
public class ProspectiveDrivers {
  private Drivers driver;
  private VehicleInformation vehicleInformation;
  private Insurance insurance;
  private DriverHistory driverHistory;
  private VehicleHistory vehicleHistory;

  /**
   * Construct a prospective driver object by passing in the following parameters.
   * @param driver the driver object.
   * @param vehicleInformation the vehicle information object.
   * @param insurance the insurance object.
   * @param driverHistory the driver history object.
   * @param vehicleHistory the vehicle history object.
   */
  public ProspectiveDrivers(Drivers driver,
      VehicleInformation vehicleInformation, Insurance insurance,
      DriverHistory driverHistory, VehicleHistory vehicleHistory) {
    this.driver = driver;
    this.vehicleInformation = vehicleInformation;
    this.insurance = insurance;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Return the driver object.
   * @return the driver object.
   */
  public Drivers getDriver() {
    return driver;
  }

  /**
   * Return the vehicle information object.
   * @return the vehicle information object.
   */
  public VehicleInformation getVehicleInformation() {
    return vehicleInformation;
  }

  /**
   * Return the insurance object.
   * @return the insurance object.
   */
  public Insurance getInsurance() {
    return insurance;
  }

  /**
   * Return the driver history object.
   * @return the driver history object.
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Return the vehicle history object.
   * @return the vehicle history object.
   */
  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProspectiveDrivers that = (ProspectiveDrivers) o;
    return Objects.equals(driver, that.driver) &&
        Objects.equals(vehicleInformation, that.vehicleInformation) &&
        Objects.equals(insurance, that.insurance) &&
        Objects.equals(driverHistory, that.driverHistory) &&
        Objects.equals(vehicleHistory, that.vehicleHistory);
  }

  @Override
  public int hashCode() {

    return Objects.hash(driver, vehicleInformation, insurance, driverHistory, vehicleHistory);
  }

  @Override
  public String toString() {
    return "ProspectiveDrivers{" +
        "driver=" + driver +
        ", vehicleInformation=" + vehicleInformation +
        ", insurance=" + insurance +
        ", driverHistory=" + driverHistory +
        ", vehicleHistory=" + vehicleHistory +
        '}';
  }
}
