package edu.neu.ccs.cs5010.assignment4;


import java.time.LocalDate;
import java.util.Objects;

/**
 * This class is used to store the driver's basic information.
 */
public class Drivers {
  private String firstName;
  private String lastName;
  private LocalDate birthday;
  private Licence licenceInformation;
  private boolean accepted;
  private DriverHistory driverHistory;

  /**
   * Construct a driver object with the following parameters.
   *
   * @param firstName the first name.
   * @param lastName the last name.
   * @param birthday the birth date.
   * @param licenceInformation the licence information.
   * @param driverHistory the driver's history.
   */
  public Drivers(String firstName, String lastName, LocalDate birthday,
      Licence licenceInformation, DriverHistory driverHistory) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.licenceInformation = licenceInformation;
    this.driverHistory = driverHistory;
  }

  /**
   * Return the first name of this driver.
   *
   * @return the last name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of this driver.
   *
   * @param firstName the first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Return the last name of this driver.
   *
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of this driver.
   *
   * @param lastName the last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Return the birth date of this driver.
   *
   * @return the birth date.
   */
  public LocalDate getBirthday() {
    return birthday;
  }

  /**
   * Update the birth date of this user.
   *
   * @param birthday the birth date.
   */
  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  /**
   * Return the licence information about this driver.
   *
   * @return the licence information.
   */
  public Licence getLicenceInformation() {
    return licenceInformation;
  }

  /**
   * Return the result that whether this driver has been accepted.
   *
   * @return whether the driver has been accepted.
   */
  public boolean isAccepted() {
    return accepted;
  }

  /**
   * Change the status that whether this driver has been accepted.
   *
   * @param accepted whether the driver has been accepted.
   */
  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  /**
   * Return the history of this driver.
   *
   * @return the history of this driver.
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, birthday, licenceInformation, accepted, driverHistory);
  }

  @Override
  public String toString() {
    return "Drivers{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", birthday=" + birthday +
        ", licenceInformation=" + licenceInformation +
        ", accepted=" + accepted +
        ", driverHistory=" + driverHistory +
        '}';
  }
}
