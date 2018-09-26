package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test all the methods in RotaryShaft class
 */
public class RotaryShaftTest {
  private RotaryShaft carbonSteel;
  private RotaryShaft carbonSteelMetric;

  @Before
  public void setUp() throws Exception {
    this.carbonSteel = new RotaryShaft("RotaryShaft", "1327K3",
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    this.carbonSteelMetric = new RotaryShaft("RotaryShaft", "1482K11",
        new Price(768), false, new Fraction(200, 0, 1),
        new Fraction(10, 0, 1), SystemOfMeasurement.METRIC);
  }

  /**
   * Test getSystemOfMeasurement method
   */
  @Test
  public void getSystemOfMeasurement() {
    Assert.assertEquals(SystemOfMeasurement.STANDARD, this.carbonSteel.getSystemOfMeasurement());
    Assert.assertEquals(SystemOfMeasurement.METRIC, this.carbonSteelMetric.getSystemOfMeasurement());
  }

  /**
   * Test getLength method by comparing all three parts in the Fraction object
   */
  @Test
  public void getLength() {
    Assert.assertEquals(3, this.carbonSteel.getLength().getIntegerPart());
    Assert.assertEquals(0, this.carbonSteel.getLength().getNumerator());
    Assert.assertEquals(1, this.carbonSteel.getLength().getDenominator());

    Assert.assertEquals(200, this.carbonSteelMetric.getLength().getIntegerPart());
    Assert.assertEquals(0, this.carbonSteelMetric.getLength().getNumerator());
    Assert.assertEquals(1, this.carbonSteelMetric.getLength().getDenominator());
  }

  /**
   * Test getDiameter method by comparing all three parts in the Fraction object
   */
  @Test
  public void getDiameter() {
    Assert.assertEquals(0, this.carbonSteel.getDiameter().getIntegerPart());
    Assert.assertEquals(1, this.carbonSteel.getDiameter().getNumerator());
    Assert.assertEquals(32, this.carbonSteel.getDiameter().getDenominator());

    Assert.assertEquals(10, this.carbonSteelMetric.getDiameter().getIntegerPart());
    Assert.assertEquals(0, this.carbonSteelMetric.getDiameter().getNumerator());
    Assert.assertEquals(1, this.carbonSteelMetric.getDiameter().getDenominator());
  }

  /**
   * Test getCategory method
   */
  @Test
  public void getCategory() {
    Assert.assertEquals("RotaryShaft", this.carbonSteel.getCategory());
    Assert.assertEquals("RotaryShaft", this.carbonSteelMetric.getCategory());
  }

  /**
   * Test getSKUNumber method
   */
  @Test
  public void getSKUNumber() {
    Assert.assertEquals("1327K3", this.carbonSteel.getSKUNumber());
    Assert.assertEquals("1482K11", this.carbonSteelMetric.getSKUNumber());
  }

  /**
   * Test getPrice method by comparing dollars and cents amount of the price
   */
  @Test
  public void getPrice() {
    Assert.assertEquals(4, this.carbonSteel.getPrice().getDollars());
    Assert.assertEquals(28, this.carbonSteel.getPrice().getCents());

    Assert.assertEquals(7, this.carbonSteelMetric.getPrice().getDollars());
    Assert.assertEquals(68, this.carbonSteelMetric.getPrice().getCents());
  }

  /**
   * Test the isShaftMounted method
   */
  @Test
  public void isShaftMounted() {
    Assert.assertEquals(false, this.carbonSteel.isShaftMounted());
    Assert.assertEquals(false, this.carbonSteelMetric.isShaftMounted());
  }

  /**
   * Test the updatePrice method
   */
  @Test
  public void updatePrice() {
    this.carbonSteel.updatePrice(430);
    Assert.assertEquals(4, this.carbonSteel.getPrice().getDollars());
    Assert.assertEquals(30, this.carbonSteel.getPrice().getCents());

    this.carbonSteelMetric.updatePrice(800);
    Assert.assertEquals(8, this.carbonSteelMetric.getPrice().getDollars());
    Assert.assertEquals(0, this.carbonSteelMetric.getPrice().getCents());
  }

  /**
   *  All the following tests are testing the exception case when inputs are not valid
   */
  @Test(expected = IllegalArgumentException.class)
  public void updatePriceFailed(){
    this.carbonSteel.updatePrice(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullCategoryTest(){
    RotaryShaft nullCategory = new RotaryShaft(null, "1327K3",
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    nullCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyCategoryTest(){
    RotaryShaft emptyCategory = new RotaryShaft("", "1327K3",
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    emptyCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullSKUNumberTest(){
    RotaryShaft nullSKUNumber = new RotaryShaft("RotaryShaft", null,
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    nullSKUNumber.getSKUNumber();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptySKUNumberTest(){
    RotaryShaft emptySKUNumber = new RotaryShaft("RotaryShaft", "",
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    emptySKUNumber.getSKUNumber();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullPriceTest(){
    RotaryShaft nullPrice = new RotaryShaft("RotaryShaft", "1327K3",
        null, false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    nullPrice.getPrice();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullLengthTest(){
    RotaryShaft nullLength = new RotaryShaft("RotaryShaft", "1327K3",
        new Price(428), false, null,
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    nullLength.getLength();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullDiameterTest(){
    RotaryShaft nullDiameter = new RotaryShaft("RotaryShaft", "1327K3",
        new Price(428), false, new Fraction(3, 0, 1),
        null, SystemOfMeasurement.STANDARD);
    nullDiameter.getDiameter();
  }
}