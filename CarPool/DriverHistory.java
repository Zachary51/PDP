package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class is used to store the history information about the driver.
 */
public class DriverHistory {
  private HashMap<LocalDate, Violation> violationHashMap;

  /**
   * Construct the driverHistory object.
   * @param violationHashMap a violation hashMap.
   */
  public DriverHistory(
      HashMap<LocalDate, Violation> violationHashMap) {
    this.violationHashMap = violationHashMap;
  }

  /**
   * Return the hashMap of violation information about this driver.
   * @return a violation hashMap.
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
    DriverHistory that = (DriverHistory) o;
    return Objects.equals(violationHashMap, that.violationHashMap);
  }

  @Override
  public int hashCode() {

    return Objects.hash(violationHashMap);
  }

  @Override
  public String toString() {
    return "DriverHistory{" +
        "violationHashMap=" + violationHashMap +
        '}';
  }
}
