package edu.neu.ccs.cs5010.assignment2;

/**
 * This class is used to handle the input problem, since many parameters are in the form
 * of fraction. This fraction method will divide an input into three parts, the integer part,
 * the numerator and the denominator. In this class, fraction class can also be presented
 * in the form of String or be conversed into a real number.
 */
public class Fraction{
  private int integerPart;
  private int numerator;
  private int denominator;

  /**
   * Construct a fraction object with following parameters.
   * If the denominator belows or equals zero or the numerator and interger part below or equal
   * zero at the same time, which means the input fraction is zero or negative, it will throw an
   * exception.
   * @param integerPart the integer part of this fraction
   * @param numerator the numerator part of this fraction
   * @param denominator the denominator part of this fraction
   */
  public Fraction(int integerPart, int numerator, int denominator) {
    if(denominator <= 0 ){
      throw new IllegalArgumentException("Denominator Cannot Be Zero!");
    } else if(numerator <= 0 && integerPart <= 0){
      throw new IllegalArgumentException("Fraction Cannot Be Zero");
    } else {
      this.numerator = numerator;
      this.denominator = denominator;
      this.integerPart = integerPart;
    }
  }

  /**
   * @return the integer part of this fraction object.
   */
  public int getIntegerPart() {
    return integerPart;
  }

  /**
   * @return the numerator of this fraction object.
   */
  public int getNumerator() {
    return numerator;
  }

  /**
   * @return the denominator of this fraction object
   */
  public int getDenominator() {
    return denominator;
  }

  /**
   * This method is used to present the fraction in the form of String.
   * The output will change the format according to the fraction input. For example, if
   * the fraction input is Fraction(1, 3, 1), the output will be presented like "1 1/3",
   * if the fraction input is Fraction(200, 0, 1), the output will be presented like "200".
   * @return the fraction in the type of String
   */
  @Override
  public String toString() {
    if(this.integerPart == 0){
      return String.format("%d/%d", this.numerator, this.denominator);
    } else if(this.numerator == 0){
      return String.format("%d", this.integerPart);
    }
    else {
      return String.format("%d %d/%d", this.integerPart, this.numerator, this.denominator);
    }
  }

  /**
   * This method is used to calculate the value of the fraction in the type of double.
   * @return the fraction value in the type of value
   */
  public double realNumber(){
    return  this.integerPart + ((double)this.numerator / (double)this.denominator);
  }
}
