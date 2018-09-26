package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test all the methods in Fraction test
 */
public class FractionTest {
  private Fraction validFraction;
  private Fraction noIntegerPart;
  private Fraction noFractionPart;


  @Before
  public void setUp() throws Exception {
    validFraction = new Fraction(1, 3, 4);
    noIntegerPart = new Fraction(0, 1, 32);
    noFractionPart = new Fraction(5, 0, 1);

  }

  /**
   * Test the Integer part then the input has all three parts and has no Integer part
   */
  @Test
  public void getIntegerPart() {
    Assert.assertEquals(1, this.validFraction.getIntegerPart());
    Assert.assertEquals(0, this.noIntegerPart.getIntegerPart());
  }

  /**
   * Test the numerator part then the input has all three parts and has no Integer part
   */
  @Test
  public void getNumerator() {
    Assert.assertEquals(3, this.validFraction.getNumerator());
    Assert.assertEquals(1, this.noIntegerPart.getNumerator());
  }

  /**
   * Test the denominator part then the input has all three parts and has no Integer part
   */
  @Test
  public void getDenominator() {
    Assert.assertEquals(4, this.validFraction.getDenominator());
    Assert.assertEquals(32, this.noIntegerPart.getDenominator());
  }

  /**
   * Test the print function when  then the input has all three parts, has no Integer part
   * and has no fraction part
   */
  @Test
  public void printFraction() {
    Assert.assertEquals("1 3/4", this.validFraction.toString());
    Assert.assertEquals("1/32", this.noIntegerPart.toString());
    Assert.assertEquals("5", this.noFractionPart.toString());
  }

  /**
   * Test the method that turn the fraction into real number when the input has all three parts
   * and has no Integer part
   */
  @Test
  public void realNumber() {
    Assert.assertEquals(1.75, this.validFraction.realNumber(), 0);
    Assert.assertEquals(0.03125, this.noIntegerPart.realNumber(), 0);
  }

  /**
   * Test the exception case when input is zero
   */
  @Test(expected = IllegalArgumentException.class)
  public void zeroTest(){
    Fraction zero = new Fraction(0, 0, 3);
    zero.getNumerator();
  }

  /**
   * Test the exception case when the denominator is zero
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidFractionTest(){
    Fraction invalidFraction = new Fraction(1, 1, 0);
    invalidFraction.getDenominator();
  }
}