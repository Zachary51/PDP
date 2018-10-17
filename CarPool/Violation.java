package edu.neu.ccs.cs5010.assignment4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * This class is used to represent the violation information.
 */
public class Violation {
  private ViolationType violationType;
  private LocalDate violationDate;
  private Crush crush;
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;

  /**
   * Construct a violation object with the following parameters.
   * @param violationType the type of violation.
   * @param violationDate the date of violation.
   * @param crush the crash type.
   * @param movingViolation the moving violation type.
   * @param nonMovingViolation the non-moving violation type.
   */
  public Violation(ViolationType violationType, LocalDate violationDate,
      Crush crush, MovingViolation movingViolation,
      NonMovingViolation nonMovingViolation) {
    this.violationType = violationType;
    this.violationDate = violationDate;
    this.crush = crush;
    this.movingViolation = movingViolation;
    this.nonMovingViolation = nonMovingViolation;
  }

  /**
   * Return the violation type of this violation object.
   * @return the violation type of this violation object.
   */
  public ViolationType getViolationType() {
    return violationType;
  }

  /**
   * Set the violation type for this violation object.
   * @param violationType the violation type for this violation object.
   */
  public void setViolationType(ViolationType violationType) {
    this.violationType = violationType;
  }

  /**
   * Return the violation date of this violation object.
   * @return the violation date of this violation object.
   */
  public LocalDate getViolationDate() {
    return violationDate;
  }

  /**
   * Set the violation date.
   * @param violationDate the violation date.
   */
  public void setViolationDate(LocalDate violationDate) {
    this.violationDate = violationDate;
  }

  /**
   * Return the crash type.
   * @return the crash type.
   */
  public Crush getCrush() {
    return crush;
  }

  /**
   * Set the crash type.
   * @param crush the crash type.
   */
  public void setCrush(Crush crush) {
    this.crush = crush;
  }

  /**
   * Return the moving violation type.
   * @return the moving violation type.
   */
  public MovingViolation getMovingViolation() {
    return movingViolation;
  }

  /**
   * Set the moving violation type.
   * @param movingViolation the moving violation type.
   */
  public void setMovingViolation(MovingViolation movingViolation) {
    this.movingViolation = movingViolation;
  }

  /**
   * Return the non-violation type.
   * @return the non-violation type.
   */
  public NonMovingViolation getNonMovingViolation() {
    return nonMovingViolation;
  }

  /**
   * Set the non-violation type.
   * @param nonMovingViolation the non-violation type.
   */
  public void setNonMovingViolation(NonMovingViolation nonMovingViolation) {
    this.nonMovingViolation = nonMovingViolation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Violation violation = (Violation) o;
    return violationType == violation.violationType &&
        Objects.equals(violationDate, violation.violationDate) &&
        crush == violation.crush &&
        movingViolation == violation.movingViolation &&
        nonMovingViolation == violation.nonMovingViolation;
  }

  @Override
  public int hashCode() {

    return Objects.hash(violationType, violationDate, crush, movingViolation, nonMovingViolation);
  }

  @Override
  public String toString() {
    return "Violation{" +
        "violationType=" + violationType +
        ", violationDate=" + violationDate +
        ", crush=" + crush +
        ", movingViolation=" + movingViolation +
        ", nonMovingViolation=" + nonMovingViolation +
        '}';
  }
}
