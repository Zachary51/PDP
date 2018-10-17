package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to check if the prospective driver is suitable
 * to be added to the pool of registered and accepted drivers.
 */
public class RegistrationValidator {
  private ArrayList<String> approvedCountry;
  private ProspectiveDrivers prospectiveDrivers;


  /**
   * Construct a RegistrationValidator object. When users use this validator,
   * he or she need to pass in the ProspectiveDrivers object as an parameter.
   */
  public RegistrationValidator(ProspectiveDrivers prospectiveDrivers) {
    this.prospectiveDrivers = prospectiveDrivers;
    approvedCountry = new ArrayList<>();
    approvedCountry.add("US");
    approvedCountry.add("CANADA");
  }

  /**
   * Check whether the prospective driver is underage.
   * @return whether the prospective driver is underage.
   */
  public boolean checkDriverAge() {
    LocalDate birthday = this.prospectiveDrivers.getDriver().getBirthday();
    LocalDate today = LocalDate.now();
    int yearDifference = Period.between(birthday, today).getYears();
    if (yearDifference < 21) {
      return false;
    }
    return true;
  }

  /**
   * Check if there is any difference between the name on application and the
   * name of the licence.
   * @return a boolean result whether there is any difference between the name
   *        on application and the name of the licence.
   */
  public boolean checkName() {
    if (prospectiveDrivers.getDriver().getFirstName()
        .equals(prospectiveDrivers.getDriver().getLicenceInformation().getFirstName())
        && prospectiveDrivers.getDriver().getLastName().equals(prospectiveDrivers
            .getDriver().getLicenceInformation().getLastName())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Check if there is any difference between the birth date provided on the application
   * and the birth date on the licence.
   * @return a boolean result if there is any difference between the birth date provided
   *        on the application and the birth date on the licence.
   */
  public boolean checkBirthdate() {
    LocalDate birthdate = this.prospectiveDrivers.getDriver().getBirthday();
    LocalDate date = this.prospectiveDrivers.getDriver().getLicenceInformation().getBirthdate();
    int yearDiff = Period.between(birthdate, date).getYears();
    int monthDiff = Period.between(birthdate, date).getMonths();
    int dayDiff = Period.between(birthdate, date).getDays();
    return (yearDiff == 0 && monthDiff == 0 && dayDiff == 0);
  }

  /**
   * Check if the licence is issued in US or Canada.
   * @return a boolean result if the licence is issued in US or Canada.
   */
  public boolean checkCountry() {
    if (!approvedCountry.contains(prospectiveDrivers.getDriver()
        .getLicenceInformation().getCountry())) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Check if the driver license issued less than six months ago.
   * @return a boolean result if the driver license issued less than
   *        six months ago.
   */
  public boolean checkDataOfIssuance() {
    LocalDate issurance = this.prospectiveDrivers.getDriver().getLicenceInformation()
        .getIssuanceDate();
    LocalDate now = LocalDate.now();
    int yearDiff = Period.between(issurance, now).getYears();
    int monthDiff = Period.between(issurance, now).getMonths();
    if (yearDiff <= 0 && monthDiff < 6) {
      return false;
    }
    return true;
  }

  /**
   * Check if the driver licence expired.
   * @return a boolean result if the driver licence expired.
   */
  public boolean checkExpirationDate() {
    LocalDate expire = this.prospectiveDrivers.getDriver().getLicenceInformation()
        .getExpirationDate();
    LocalDate now = LocalDate.now();
    return now.isBefore(expire);
  }

  /**
   * Check if this vehicle order than 15 years.
   * @return a boolean result if this vehicle order than 15 years.
   */
  public boolean checkVehicleInformation() {
    return LocalDate.now().getYear()
        - Integer.valueOf(this.prospectiveDrivers.getVehicleInformation().getYear()) < 15;
  }

  /**
   * Check the validity of the vehicle insurance.
   * @return the validity of the vehicle insurance.
   */
  public boolean checkInsurance() {
    if (!prospectiveDrivers.getInsurance().getOwnerFirstName().equals(prospectiveDrivers
        .getVehicleHistory().getDriverFirstName())
        || (!prospectiveDrivers.getInsurance().getOwnerLastName().equals(prospectiveDrivers
        .getVehicleHistory().getDriverLastName()))
        && (!prospectiveDrivers.getDriver().getFirstName().equals(prospectiveDrivers
        .getInsurance().getCoveredFirstName()))
        || (!prospectiveDrivers.getDriver().getLastName().equals(prospectiveDrivers
        .getInsurance().getCoveredLastName()))) {
      return false;
    }
    LocalDate expire = this.prospectiveDrivers.getInsurance().getExpirationDateOfInsurance();
    if (LocalDate.now().isAfter(expire)) {
      return false;
    }
    return true;
  }

  /**
   * Check the history of this driver.
   * @return the history of this driver.
   */
  public boolean checkDriverHistory() {
    for (Violation violation : this.prospectiveDrivers.getDriverHistory().getViolationHashMap()
        .values()) {
      if (violation.getViolationType() == ViolationType.MovingViolation
          && (violation.getMovingViolation() == MovingViolation
            .DrivingWithoutAValidLicenseAndOrInsurance
            || violation.getMovingViolation() == MovingViolation.RecklessDriving
            || violation.getMovingViolation() == MovingViolation.Speeding
            || violation.getMovingViolation() == MovingViolation.DrivingUnderInfluence)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Check the history of this vehicle.
   * @return the history of this vehicle.
   */
  public boolean checkVehicleHistory() {
    for (Violation violation : this.prospectiveDrivers.getVehicleHistory()
        .getViolationHashMap().values()) {
      if (violation.getViolationType() == ViolationType.Crush || violation.getViolationType()
          == ViolationType.MovingViolation) {
        LocalDate violationDate = violation.getViolationDate();
        LocalDate now = LocalDate.now();
        int yearDiff = Period.between(violationDate, now).getYears();
        int monthDiff = Period.between(violationDate, now).getMonths();
        if (yearDiff <= 0 && monthDiff < 6) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistrationValidator that = (RegistrationValidator) o;
    return Objects.equals(approvedCountry, that.approvedCountry) &&
        Objects.equals(prospectiveDrivers, that.prospectiveDrivers);
  }

  @Override
  public int hashCode() {

    return Objects.hash(approvedCountry, prospectiveDrivers);
  }

}
