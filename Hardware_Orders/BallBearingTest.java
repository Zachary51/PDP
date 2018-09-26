package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test is used to test all the methods in BallBearing class
 */
public class BallBearingTest {
  private BallBearing ballBearingMetric;
  private RotaryShaft fits;
  private RotaryShaft unfits;
  private BallBearing ballBearingOpen;
  private BallBearing ballBearingSealed;

  @Before
  public void setUp() throws Exception {
    this.ballBearingMetric = new BallBearing("BallBearing", "5972K323", new Price(754),
        SealType.SHIELDED, new Fraction(8, 0,1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    this.fits = new RotaryShaft("RotaryShaft", "1482K25", new Price(4009),
        false, new Fraction(2000, 0, 1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC);
    this.unfits = new RotaryShaft("RotaryShaft", "1482K49", new Price(1755),
        false, new Fraction(200, 0, 1), new Fraction(30, 0, 1),
        SystemOfMeasurement.METRIC);
    this.ballBearingOpen = new BallBearing("BallBearing", "5972K91", new Price(432),
        SealType.OPEN, new Fraction(7, 0, 1), new Fraction(8, 0, 1),
        SystemOfMeasurement.STANDARD, true);
    this.ballBearingSealed = new BallBearing("BallBearing", "5972K225", new Price(2026),
        SealType.SEALED, new Fraction(6, 0, 1), new Fraction(7, 0 , 1),
        SystemOfMeasurement.METRIC, true);
  }

  /**
   * Test the getSealType method when the seal type is shielded, open and sealed
   */
  @Test
  public void getSealType() {
    Assert.assertEquals(SealType.SHIELDED, this.ballBearingMetric.getSealType());
    Assert.assertEquals(SealType.OPEN, this.ballBearingOpen.getSealType());
    Assert.assertEquals(SealType.SEALED, this.ballBearingSealed.getSealType());
  }

  /**
   * Test the getWidth method by comparing all three parts in the width
   */
  @Test
  public void getWidth() {
    Assert.assertEquals(8, this.ballBearingMetric.getWidth().getIntegerPart());
    Assert.assertEquals(0, this.ballBearingMetric.getWidth().getNumerator());
    Assert.assertEquals(1, this.ballBearingMetric.getWidth().getDenominator());
  }

  /**
   * Test the getSystemOfMeasurement method when the system of measurement is metric and standard
   */
  @Test
  public void getSystemOfMeasurement() {
    Assert.assertEquals(SystemOfMeasurement.METRIC, this.ballBearingMetric.getSystemOfMeasurement());
    Assert.assertEquals(SystemOfMeasurement.STANDARD, this.ballBearingOpen.getSystemOfMeasurement());
  }

  /**
   * Test the fitsShaft method when the rotary object fits the item
   */
  @Test
  public void fitsShaft() {
    Assert.assertEquals(true, this.ballBearingMetric.fitsShaft(fits));
  }

  /**
   * Test the fitsShaft method when the rotary object unfits the item
   */
  @Test
  public void unfitsShaft(){
    Assert.assertEquals(false, this.ballBearingMetric.fitsShaft(unfits));
  }

  /**
   * Test the getCategory method
   */
  @Test
  public void getCategory() {
    Assert.assertEquals("BallBearing", this.ballBearingMetric.getCategory());
  }

  /**
   * Test the getSKUNumber method
   */
  @Test
  public void getSKUNumber() {
    Assert.assertEquals("5972K323", this.ballBearingMetric.getSKUNumber());
  }

  /**
   * Test the getPrice method by comparing dollars amount and cents amount
   */
  @Test
  public void getPrice() {
    Assert.assertEquals(7, this.ballBearingMetric.getPrice().getDollars());
    Assert.assertEquals(54, this.ballBearingMetric.getPrice().getCents());
  }

  /**
   * Test the isShaftMounted method
   */
  @Test
  public void isShaftMounted() {
    Assert.assertEquals(true, this.ballBearingMetric.isShaftMounted());
    Assert.assertEquals(false, this.fits.isShaftMounted());
  }
  /**
   * Test the updatePrice method
   */
  @Test
  public void updatePrice() {
    this.ballBearingMetric.updatePrice(756);
    Assert.assertEquals(7, this.ballBearingMetric.getPrice().getDollars());
    Assert.assertEquals(56, this.ballBearingMetric.getPrice().getCents());
  }

  /**
   *  All the following tests are testing the exception case when inputs are not valid
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullCategory(){
    BallBearing nullCategory = new BallBearing(null, "5972K323", new Price(754),
        SealType.SHIELDED, new Fraction(8, 0,1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    nullCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyCategory() {
    BallBearing emptyCategory = new BallBearing("", "5972K323", new Price(754),
        SealType.SHIELDED, new Fraction(8, 0, 1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    emptyCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullSKUNumber(){
    BallBearing nullSKUNumber = new BallBearing("RotaryShaft", null, new Price(754),
        SealType.SHIELDED, new Fraction(8, 0,1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    nullSKUNumber.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptySKUNumber() {
    BallBearing emptySKUNumber = new BallBearing("RotaryShaft", "", new Price(754),
        SealType.SHIELDED, new Fraction(8, 0, 1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    emptySKUNumber.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullPrice(){
    BallBearing nullPrice = new BallBearing("RotaryShaft", "5972K323", null,
        SealType.SHIELDED, new Fraction(8, 0, 1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    nullPrice.getPrice();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullWidth(){
    BallBearing nullWidth = new BallBearing("RotaryShaft", "5972K323", new Price(754),
        SealType.SHIELDED,null, new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    nullWidth.getWidth();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullDiameter(){
    BallBearing nullDiameter = new BallBearing("RotaryShaft", "5972K323", new Price(754),
        SealType.SHIELDED,new Fraction(8, 0, 1), null,
        SystemOfMeasurement.METRIC, true);
  }
}