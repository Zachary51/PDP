package edu.neu.ccs.cs5010.assignment3.HardwareOrders;

/**
 * This class is used to store and handle price information. It has two fields: dollars and cents.
 * When use this class, user can only input the total cents amount of the price, then it will
 * calculate the dollars amount and cents amount and assign them to the corresponding fields. This
 * is for avoiding rounding error.
 * This class also has toString method which is used to print out the price information, which can
 * be used to present price correctly in the database.
 */
public class Price {
  private int dollars;
  private int cents;

  /**
   * @return the dollars amount of this price object
   */
  public int getDollars() {
    return dollars;
  }

  /**
   * @return the cents amount of this price object
   */
  public int getCents() {
    return cents;
  }

  /**
   * Construct a price object. When use this class, user can only input the total cents amount
   * of the price, then it will calculate the dollars amount and cents amount and assign them
   * to the corresponding fields. This is for avoiding rounding error.
   * When input value belows or equals zero, it will throw an exception because of invalid price.
   * @param cents the total cents amount of this price
   */
  public Price(int cents) {
    if(cents < 0){
      throw new IllegalArgumentException("Invalid Price");
    } else {
      this.dollars = cents / 100;
      this.cents = cents % 100;
    }
  }

  /**
   * This method is used to converse price into String. If the cents amount is less than 10
   * or the input mod 100 is less than 10, it will add zero before the cents value. For example,
   * cents 709 will be presented "$7.09".
   * @return the price information in type of String.
   */
  @Override
  public String toString() {
    if(cents < 10 || cents % 100 < 10){
      return String.format("$%d.0%d", this.dollars, this.cents);
    } else {
      return String.format("$%d.%d", this.dollars, this.cents);
    }
  }

}
