package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class is used to store the vehicle history.
 */
public class VehicleHistory {
  private String driverFirstName;
  private String driverLastName;
  private HashMap<LocalDate, Violation> violationHashMap;

  /**
   * Construct a vehicle history with the following parameters.
   * @param driverFirstName the first name of the driver.
   * @param driverLastName the last name of the driver.
   * @param violationHashMap the violation hashMap.
   */
  public VehicleHistory(String driverFirstName, String driverLastName,
      HashMap<LocalDate, Violation> violationHashMap) {
    this.driverFirstName = driverFirstName;
    this.driverLastName = driverLastName;
    this.violationHashMap = violationHashMap;
  }

  /**
   * Return the first name of the driver.
   * @return the first name of the driver.
   */
  public String getDriverFirstName() {
    return driverFirstName;
  }

  /**
   * Set the first name of the driver.
   * @param driverFirstName the first name of the driver.
   */
  public void setDriverFirstName(String driverFirstName) {
    this.driverFirstName = driverFirstName;
  }

  /**
   * Return the last name of the driver.
   * @return the last name of the driver.
   */
  public String getDriverLastName() {
    return driverLastName;
  }

  /**
   * Set the last name of the driver.
   * @param driverLastName the last name of the driver.
   */
  public void setDriverLastName(String driverLastName) {
    this.driverLastName = driverLastName;
  }

  /**
   * Return the hashMap which has stored all the violation records
   * according to the date.
   * @return the violation hashMap.
   */
  public HashMap<LocalDate, Violation> getViolationHashMap() {
    return violationHashMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) o;
    return Objects.equals(driverFirstName, that.driverFirstName) &&
        Objects.equals(driverLastName, that.driverLastName) &&
        Objects.equals(violationHashMap, that.violationHashMap);
  }

  @Override
  public int hashCode() {

    return Objects.hash(driverFirstName, driverLastName, violationHashMap);
  }

  @Override
  public String toString() {
    return "VehicleHistory{" +
        "driverFirstName='" + driverFirstName + '\'' +
        ", driverLastName='" + driverLastName + '\'' +
        ", violationHashMap=" + violationHashMap +
        '}';
  }
}
