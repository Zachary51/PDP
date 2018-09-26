package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test all the methods in the Sprocket class
 */
public class SprocketTest {
  private Sprocket sprocketStandard;
  private Sprocket sprocketInch;
  private RotaryShaft fits;
  private RotaryShaft unfits;

  @Before
  public void setUp() throws Exception {
    this.sprocketStandard = new Sprocket("Sprocket", "2737T1", new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    this.sprocketInch = new Sprocket("Sprocket", "2302K22", new Price(2243),
        16, new Fraction(12, 0, 1), SystemOfMeasurement.METRIC, true);

  }

  /**
   * Test the getTeeth method
   */
  @Test
  public void getTeeth() {
    Assert.assertEquals(9, this.sprocketStandard.getTeeth());
    Assert.assertEquals(16, this.sprocketInch.getTeeth());

  }

  /**
   * Test the getShaftDiameter method when the input has no integer part and no fraction part
   */
  @Test
  public void getShaftDiameter() {
    Assert.assertEquals(0, this.sprocketStandard.getShaftDiameter().getIntegerPart());
    Assert.assertEquals(1, this.sprocketStandard.getShaftDiameter().getNumerator());
    Assert.assertEquals(4, this.sprocketStandard.getShaftDiameter().getDenominator());

    Assert.assertEquals(12, this.sprocketInch.getShaftDiameter().getIntegerPart());
    Assert.assertEquals(0, this.sprocketInch.getShaftDiameter().getNumerator());
    Assert.assertEquals(1, this.sprocketInch.getShaftDiameter().getDenominator());
  }

  /**
   * Test the getSystemOfMeasurement method
   */
  @Test
  public void getSystemOfMeasurement() {
    Assert.assertEquals(SystemOfMeasurement.STANDARD, this.sprocketStandard.getSystemOfMeasurement());
    Assert.assertEquals(SystemOfMeasurement.METRIC, this.sprocketInch.getSystemOfMeasurement());
  }

  /**
   * Test the fitsShaft method when the shaft object fits the item
   */
  @Test
  public void fitsShaft() {
    this.fits = new RotaryShaft("RotaryShaft", "1327K114", new Price(393),
        false, new Fraction(4, 0, 1), new Fraction(0, 1, 4),
        SystemOfMeasurement.STANDARD);
    Assert.assertEquals(true, this.sprocketStandard.fitsShaft(fits));

  }

  /**
   * Test the fitsShaft method when the shaft object unfits the item
   */
  @Test
  public void unfitsShaft(){
    this.unfits = new RotaryShaft("RotaryShaft", "1327K83", new Price(270),
        false, new Fraction(3, 0, 1), new Fraction(0, 1, 16),
        SystemOfMeasurement.STANDARD);
    Assert.assertEquals(false, this.sprocketStandard.fitsShaft(unfits));
  }

  /**
   * Test the getCategory method
   */
  @Test
  public void getCategory() {
    Assert.assertEquals("Sprocket", this.sprocketStandard.getCategory());
    Assert.assertEquals("Sprocket", this.sprocketInch.getCategory());
  }

  /**
   * Test get getSKUNumber method
   */
  @Test
  public void getSKUNumber() {
    Assert.assertEquals("2737T1", this.sprocketStandard.getSKUNumber());
    Assert.assertEquals("2302K22", this.sprocketInch.getSKUNumber());
  }

  /**
   * Test the getPrice method by comparing the dollars and cents amount of the price
   */
  @Test
  public void getPrice() {
    Assert.assertEquals(9, this.sprocketStandard.getPrice().getDollars());
    Assert.assertEquals(96, this.sprocketStandard.getPrice().getCents());

    Assert.assertEquals(22, this.sprocketInch.getPrice().getDollars());
    Assert.assertEquals(43, this.sprocketInch.getPrice().getCents());
  }

  /**
   * Test isShaftMounted method
   */
  @Test
  public void isShaftMounted() {
    Assert.assertEquals(true, this.sprocketStandard.isShaftMounted());
    Assert.assertEquals(true, this.sprocketInch.isShaftMounted());
  }

  /**
   * Test updatePrice method
   */
  @Test
  public void updatePrice() {
    this.sprocketStandard.updatePrice(998);
    Assert.assertEquals(9, this.sprocketStandard.getPrice().getDollars());
    Assert.assertEquals(98, this.sprocketStandard.getPrice().getCents());

    this.sprocketInch.updatePrice(2500);
    Assert.assertEquals(25, this.sprocketInch.getPrice().getDollars());
    Assert.assertEquals(0, this.sprocketInch.getPrice().getCents());
  }

  /**
   *  All the following tests are testing the exception case when inputs are not valid
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullCategoryTest(){
    Sprocket nullCategory = new Sprocket(null, "2737T1", new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    nullCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyCategoryTest(){
    Sprocket emptyCategory = new Sprocket("", "2737T1", new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    emptyCategory.getCategory();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullSKUNumberTest(){
    Sprocket nullSKUNumber = new Sprocket("Sprocket", null, new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    nullSKUNumber.getSKUNumber();
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptySKUNumberTest(){
    Sprocket emptySKUNumber = new Sprocket("Sprocket", "", new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    emptySKUNumber.getSKUNumber();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullShaftDiameterTest(){
    Sprocket nullShaftDiameter = new Sprocket("Sprocket", "2737T1", new Price(996),
        9, null, SystemOfMeasurement.STANDARD, true);
    nullShaftDiameter.getShaftDiameter();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullPriceTest(){
    Sprocket nullPrice = new Sprocket("Sprocket", "2737T1", null,
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    nullPrice.getPrice();
  }
}