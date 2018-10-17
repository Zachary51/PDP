package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class is used to store insurance information of the vehicle owner.
 */
public class Insurance {
  private String ownerFirstName;
  private String ownerLastName;
  private String coveredFirstName;
  private String coveredLastName;
  private LocalDate expirationDateOfInsurance;

  /**
   * Construc a insurance object with the following parameters.
   * @param ownerFirstName the first name.
   * @param ownerLastName the last name.
   * @param coveredFirstName the first name.
   * @param coveredLastName the last name.
   * @param expirationDateOfInsurance the expiration date.
   */
  public Insurance(String ownerFirstName, String ownerLastName, String coveredFirstName,
      String coveredLastName, LocalDate expirationDateOfInsurance) {
    this.ownerFirstName = ownerFirstName;
    this.ownerLastName = ownerLastName;
    this.coveredFirstName = coveredFirstName;
    this.coveredLastName = coveredLastName;
    this.expirationDateOfInsurance = expirationDateOfInsurance;
  }

  /**
   * Return the owner's first name.
   * @return the first name.
   */
  public String getOwnerFirstName() {
    return ownerFirstName;
  }

  /**
   * Set the owner's first name.
   * @param ownerFirstName the first name.
   */
  public void setOwnerFirstName(String ownerFirstName) {
    this.ownerFirstName = ownerFirstName;
  }

  /**
   * Return the owner's last name.
   * @return the last name.
   */
  public String getOwnerLastName() {
    return ownerLastName;
  }

  /**
   * Set the owner's last name.
   * @param ownerLastName the last name.
   */
  public void setOwnerLastName(String ownerLastName) {
    this.ownerLastName = ownerLastName;
  }

  /**
   * Return the covered person's first name.
   * @return the first name.
   */
  public String getCoveredFirstName() {
    return coveredFirstName;
  }

  /**
   * Set the covered person's first name.
   * @param coveredFirstName the first name.
   */
  public void setCoveredFirstName(String coveredFirstName) {
    this.coveredFirstName = coveredFirstName;
  }

  /**
   * Return the covered person's last name.
   * @return the last name.
   */
  public String getCoveredLastName() {
    return coveredLastName;
  }

  /**
   * Set the covered person's last name.
   * @param coveredLastName the last name.
   */
  public void setCoveredLastName(String coveredLastName) {
    this.coveredLastName = coveredLastName;
  }

  /**
   * Return the expiration date of this insurance.
   * @return the expiration date.
   */
  public LocalDate getExpirationDateOfInsurance() {
    return expirationDateOfInsurance;
  }

  /**
   * Update the expiration date of this insurance.
   * @param expirationDateOfInsurance the expiration date.
   */
  public void setExpirationDateOfInsurance(LocalDate expirationDateOfInsurance) {
    this.expirationDateOfInsurance = expirationDateOfInsurance;
  }

  @Override
  public int hashCode() {

    return Objects.hash(ownerFirstName, ownerLastName, coveredFirstName, coveredLastName,
        expirationDateOfInsurance);
  }

  @Override
  public String toString() {
    return "Insurance{" +
        "ownerFirstName='" + ownerFirstName + '\'' +
        ", ownerLastName='" + ownerLastName + '\'' +
        ", coveredFirstName='" + coveredFirstName + '\'' +
        ", coveredLastName='" + coveredLastName + '\'' +
        ", expirationDateOfInsurance=" + expirationDateOfInsurance +
        '}';
  }
}
