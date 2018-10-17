package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class is used to store the licence information of the driver.
 */
public class Licence {
  private String number;
  private String firstName;
  private String lastName;
  private String address;
  private LocalDate birthdate;
  private String country;
  private String state;
  private LocalDate issuanceDate;
  private LocalDate expirationDate;

  /**
   * Construct a licence object with the following parameters.
   *
   * @param number the number.
   * @param firstName the first name.
   * @param lastName the last name.
   * @param address the address.
   * @param birthdate the birthdate.
   * @param country the country.
   * @param state the state.
   * @param issuanceDate the issuance date.
   * @param expirationDate the expiration date.
   */
  public Licence(String number, String firstName, String lastName, String address,
      LocalDate birthdate, String country, String state, LocalDate issuanceDate,
      LocalDate expirationDate) {
    this.number = number;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthdate = birthdate;
    this.country = country;
    this.state = state;
    this.issuanceDate = issuanceDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Return the licence number of this licence.
   * @return the licence number of this licence.
   */
  public String getNumber() {
    return number;
  }

  /**
   * Return the first name of the driver.
   * @return the first name of the driver.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the driver.
   * @param firstName the first name of the driver.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Return the last name of the driver.
   * @return the last name of the driver.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the driver.
   * @param lastName the last name of the driver.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Return the address information about the driver.
   * @return the address information about the driver.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Return the birth date about the driver.
   * @return the birth date about the driver.
   */
  public LocalDate getBirthdate() {
    return birthdate;
  }

  /**
   * Return the country information about the driver.
   * @return the country information about the driver.
   */
  public String getCountry() {
    return country;
  }

  /**
   * Return the state information about the driver.
   * @return the state information about the driver.
   */
  public String getState() {
    return state;
  }

  /**
   * Return the expiration date of this licence.
   * @return the expiration date of this licence.
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  /**
   * Set the licence number of this licence.
   * @param number the licence number of this licence.
   */
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * Set the address information about this licence.
   * @param address the address information about this licence.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Set the birth date of this driver.
   * @param birthdate the birth date of this driver.
   */
  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  /**
   * Set the country information about this driver.
   * @param country the country information about this driver.
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Set the state information about this driver.
   * @param state the state information about this driver.
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Set the expiration date of this licence.
   * @param expirationDate the expiration date of this licence.
   */
  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  /**
   * Return the issauance date of this licence.
   * @return the issauance date of this licence.
   */
  public LocalDate getIssuanceDate() {
    return issuanceDate;
  }

  /**
   * Set the issuance date of this licence.
   * @param issuanceDate the issauance date of this licence.
   */
  public void setIssuanceDate(LocalDate issuanceDate) {
    this.issuanceDate = issuanceDate;
  }

  @Override
  public int hashCode() {

    return Objects
        .hash(number, firstName, lastName, address, birthdate, country, state, issuanceDate,
            expirationDate);
  }

  @Override
  public String toString() {
    return "Licence{" +
        "number='" + number + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", birthdate=" + birthdate +
        ", country='" + country + '\'' +
        ", state='" + state + '\'' +
        ", issuanceDate=" + issuanceDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
