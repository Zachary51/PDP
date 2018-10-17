package edu.neu.ccs.cs5010.assignment4;

import java.util.Objects;

/**
 * This class is used to store vehicle information about each vehicle.
 */
public class VehicleInformation {
  private String color;
  private String make;
  private String model;
  private int year;
  private String officialOwnerFirstName;
  private String officialOwnerLastName;
  private VehicleHistory vehicleHistory;

  /**
   * Construct a vehicle information object with following parameters.
   * @param color the color of the vehicle.
   * @param make the make of the vehicle.
   * @param model the model of the vehicle.
   * @param year the year of the vehicle.
   * @param officialOwnerFirstName the first name.
   * @param officialOwnerLastName the last name.
   * @param vehicleHistory the history of the vehicle.
   */
  public VehicleInformation(String color, String make, String model, int year,
      String officialOwnerFirstName, String officialOwnerLastName,
      VehicleHistory vehicleHistory) {
    this.color = color;
    this.make = make;
    this.model = model;
    this.year = year;
    this.officialOwnerFirstName = officialOwnerFirstName;
    this.officialOwnerLastName = officialOwnerLastName;
    this.vehicleHistory = vehicleHistory;
  }

  /**
   * Return the make of this vehicle.
   * @return the make of this vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * Set the make of this vehicle.
   * @param make the make of this vehicle.
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * Return the model information about this vehicle.
   * @return the model information about this vehicle.
   */
  public String getModel() {
    return model;
  }

  /**
   * Set the model information of this vehicle.
   * @param model the model information of this vehicle
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * Return the year information about this vehicle.
   * @return the year information about this vehicle.
   */
  public int getYear() {
    return year;
  }

  /**
   * Set the year information about this vehicle.
   * @param year the year information about this vehicle.
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * Return the first name of the official owner.
   * @return the first name of the official owner.
   */
  public String getOfficialOwnerFirstName() {
    return officialOwnerFirstName;
  }

  /**
   * Set the first name of the official owner.
   * @param officialOwnerFirstName the first name of the official owner.
   */
  public void setOfficialOwnerFirstName(String officialOwnerFirstName) {
    this.officialOwnerFirstName = officialOwnerFirstName;
  }

  /**
   * Return the last name of the official owner.
   * @return the last name of the official owner.
   */
  public String getOfficialOwnerLastName() {
    return officialOwnerLastName;
  }

  /**
   * Set the last name of the official owner.
   * @param officialOwnerLastName the last name of the official owner.
   */
  public void setOfficialOwnerLastName(String officialOwnerLastName) {
    this.officialOwnerLastName = officialOwnerLastName;
  }

  /**
   * Return the color of this vehicle.
   * @return the color of this vehicle.
   */
  public String getColor() {
    return color;
  }

  /**
   * Set the color of this vehicle.
   * @param color the color of this vehicle.
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * Return the vehicle history.
   * @return the vehicle history.
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
    VehicleInformation that = (VehicleInformation) o;
    return year == that.year &&
        Objects.equals(color, that.color) &&
        Objects.equals(make, that.make) &&
        Objects.equals(model, that.model) &&
        Objects.equals(officialOwnerFirstName, that.officialOwnerFirstName) &&
        Objects.equals(officialOwnerLastName, that.officialOwnerLastName) &&
        Objects.equals(vehicleHistory, that.vehicleHistory);
  }

  @Override
  public int hashCode() {

    return Objects.hash(color, make, model, year, officialOwnerFirstName, officialOwnerLastName,
        vehicleHistory);
  }

  @Override
  public String toString() {
    return "VehicleInformation{" +
        "color='" + color + '\'' +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", officialOwnerFirstName='" + officialOwnerFirstName + '\'' +
        ", officialOwnerLastName='" + officialOwnerLastName + '\'' +
        ", vehicleHistory=" + vehicleHistory +
        '}';
  }
}
