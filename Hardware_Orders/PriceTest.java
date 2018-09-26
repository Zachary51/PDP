package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This test class is used to test all the methods in Price class
 */
public class PriceTest {
  private Price validPrice;
  private Price smallPrice;
  private Price noPrice;

  @Before
  public void setUp() throws Exception {
    this.validPrice = new Price(428);
    this.smallPrice = new Price(48);
    this.noPrice = new Price(0);

  }

  /**
   * Test the dollars amount when the price has an Integer part, has no Integer part and zero
   */
  @Test
  public void getDollars() {
    Assert.assertEquals(4, this.validPrice.getDollars());
    Assert.assertEquals(0, this.smallPrice.getDollars());
    Assert.assertEquals(0, this.noPrice.getDollars());
  }

  /**
   * Test the cents amount when the price has an Integer part, has no Integer part and zero
   */
  @Test
  public void getCents() {
    Assert.assertEquals(28, this.validPrice.getCents());
    Assert.assertEquals(48, this.smallPrice.getCents());
    Assert.assertEquals(0, this.noPrice.getCents());
  }

  /**
   * Test the print function when the price has an Integer part, has no Integer part and zero
   */
  @Test
  public void toStringTest() {
    Assert.assertEquals("$4.28", this.validPrice.toString());
    Assert.assertEquals("$0.48", this.smallPrice.toString());
    Assert.assertEquals("$0.00", this.noPrice.toString());
  }

  /**
   * Test the exception when input is negative
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidPriceTest(){
    Price invalidPrice = new Price(-1);
    invalidPrice.toString();
  }

}