package edu.neu.ccs.cs5010.assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * This Class is used to create a pool of existing accepted drivers.
 */
public class AcceptedDriversPool {

  /**
   * This Set can guarantee the uniqueness of the pool.
   */
  private Set<Drivers> acceptedDrivers;

  /**
   * This register Map can make it possible that for the same
   * driver, he or she can register with multiple vehicles.
   */
  private HashMap<Drivers, ArrayList<VehicleInformation>> registerMap;

  /**
   * This hash map guarantees that every driver can drive only one
   * vehicle at the time.
   */
  private HashMap<Drivers, VehicleInformation> driverVehicleMap;

  /**
   * Construct a accepted drivers pool object.
   * @param acceptedDrivers the accepted drivers.
   * @param registerMap the register map.
   * @param driverVehicleMap the driver vehicle map.
   */
  public AcceptedDriversPool(Set<Drivers> acceptedDrivers,
      HashMap<Drivers, ArrayList<VehicleInformation>> registerMap,
      HashMap<Drivers, VehicleInformation> driverVehicleMap) {
    this.acceptedDrivers = acceptedDrivers;
    this.registerMap = registerMap;
    this.driverVehicleMap = driverVehicleMap;
  }

  /**
   * Return the set of all the accepted drivers.
   * @return the set of all the accepted drivers.
   */
  public Set<Drivers> getAcceptedDrivers() {
    return this.acceptedDrivers;
  }

  /**
   * Return the hashMap of registered drivers and their vehicles.
   * @return the hashMap of registered drivers and their vehicles.
   */
  public HashMap<Drivers, ArrayList<VehicleInformation>> getRegisterMap() {
    return registerMap;
  }

  /**
   * Return the hashMap of registered drivers and their current vehicle.
   * @return the hashMap of registered drivers and their current vehicle.
   */
  public HashMap<Drivers, VehicleInformation> getDriverVehicleMap() {
    return driverVehicleMap;
  }

  /**
   * Add driver to the accepted drivers pool.
   * @param driver the driver object.
   */
  public void addDriver(Drivers driver) {
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    this.acceptedDrivers.add(driver);
  }

  /**
   * Remove driver from the accepted drivers pool.
   * @param driver the driver object.
   */
  public void removeDriver(Drivers driver) {
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (!acceptedDrivers.contains(driver)) {
      throw new IllegalArgumentException("No driver record");
    }
    this.acceptedDrivers.remove(driver);
  }

  /**
   * Register new vehicle for the current accepted drivers.
   * @param driver the driver object.
   * @param newVehicle the vehicle information object.
   */
  public void registerVehicles(Drivers driver, VehicleInformation newVehicle) {
    if (newVehicle == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (!acceptedDrivers.contains(driver)) {
      throw new IllegalArgumentException("No driver record");
    }

    if (registerMap.containsKey(driver)) {
      ArrayList<VehicleInformation> currentVehicleInformation = registerMap.get(driver);
      currentVehicleInformation.add(newVehicle);
    } else {
      ArrayList<VehicleInformation> currentVehicleInformation = new ArrayList<>();
      currentVehicleInformation.add(newVehicle);
      registerMap.put(driver, currentVehicleInformation);
    }
  }

  /**
   * Delete registered vehicles for the accepted drivers.
   * @param driver the driver object.
   * @param deleteVehicle the vehicle information object.
   */
  public void deleteRegisterVehicles(Drivers driver, VehicleInformation deleteVehicle) {
    if (deleteVehicle == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (!acceptedDrivers.contains(driver)) {
      throw new IllegalArgumentException("No driver record");
    }

    if (!registerMap.containsKey(driver) || registerMap.get(driver) == null) {
      throw new IllegalArgumentException("No record to be deleted");
    }

    ArrayList<VehicleInformation> currentVehicleInformation = registerMap.get(driver);
    currentVehicleInformation.remove(deleteVehicle);
  }

  /**
   * Update vehicle information for the accepted driver.
   * @param driver the driver object.
   * @param newVehicle the vehicle information object.
   */
  public void updateDriverVehicle(Drivers driver, VehicleInformation newVehicle) {
    if (newVehicle == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (!acceptedDrivers.contains(driver)) {
      throw new IllegalArgumentException("No driver record");
    }
    if (!registerMap.containsKey(driver)) {
      throw new IllegalArgumentException("No driver record");
    }
    if (!registerMap.get(driver).contains(newVehicle)) {
      throw new IllegalArgumentException("This vehicle has not been registered");
    }
    if (!driverVehicleMap.containsKey(driver)) {
      throw new IllegalArgumentException("This driver has not been registered");
    }
    driverVehicleMap.put(driver, newVehicle);
  }

  /**
   * Delete vehicle information from the driver-vehicle hashMap.
   * @param driver the driver object.
   * @param deleteVehicle the vehicle information object.
   */
  public void deleteDriverVehicle(Drivers driver, VehicleInformation deleteVehicle) {
    if (deleteVehicle == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (driver == null) {
      throw new IllegalArgumentException("Invalid Input");
    }
    if (!acceptedDrivers.contains(driver)) {
      throw new IllegalArgumentException("No driver record");
    }
    if (!registerMap.containsKey(driver)) {
      throw new IllegalArgumentException("No driver record");
    }
    if (!registerMap.get(driver).contains(deleteVehicle)) {
      throw new IllegalArgumentException("This vehicle has not been registered");
    }
    if (!driverVehicleMap.containsKey(driver)) {
      throw new IllegalArgumentException("This driver has not been registered");
    }
    driverVehicleMap.remove(driver);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcceptedDriversPool that = (AcceptedDriversPool) o;
    return Objects.equals(acceptedDrivers, that.acceptedDrivers) &&
        Objects.equals(registerMap, that.registerMap) &&
        Objects.equals(driverVehicleMap, that.driverVehicleMap);
  }

  @Override
  public int hashCode() {

    return Objects.hash(acceptedDrivers, registerMap, driverVehicleMap);
  }

  @Override
  public String toString() {
    return "AcceptedDriversPool{" +
        "acceptedDrivers=" + acceptedDrivers +
        ", registerMap=" + registerMap +
        ", driverVehicleMap=" + driverVehicleMap +
        '}';
  }
}
