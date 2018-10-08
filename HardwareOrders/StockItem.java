package edu.neu.ccs.cs5010.assignment3.HardwareOrders;

/**
 * This Class is an abstract class which is used to define a stock item. A stock item have the
 * following fields in common: categoru, SKUNumber, price and the information about whether they
 * are shaft-mounted
 */
public abstract class StockItem {

  private String category;
  private String SKUNumber;
  private Price price;
  private boolean shaftMounted;
  private SystemOfMeasurement systemOfMeasurement;
  private Fraction diameter;

  /**
   * Construct the stock item object with following parameters.
   * In order to guarantee valid input, if category or SKU number is empty or null or if price
   * information is null, there will be exception.
   * @param category the category information about this item.
   * @param SKUNumber stock-keeping unit number.
   * @param price the price information about this item.
   * @param shaftMounted whether this item is shaft-mounted.
   */
  public StockItem(String category, String SKUNumber, Price price, boolean shaftMounted,
      SystemOfMeasurement systemOfMeasurement, Fraction diameter) {
    if(category == null || category.length() == 0 || SKUNumber == null || SKUNumber.length() == 0 ||
        price == null){
      throw new IllegalArgumentException("Not Null");
    }
    this.category = category;
    this.SKUNumber = SKUNumber;
    this.price = price;
    this.shaftMounted = shaftMounted;
    this.systemOfMeasurement = systemOfMeasurement;
    this.diameter = diameter;
  }

  /**
   * @return the category information of this item
   */

  public String getCategory(){
    return this.category;
  };

  /**
   * @return the SKU Number of this item
   */
  public String getSKUNumber(){
    return this.SKUNumber;
  };

  /**
   * @return the price information of this item.
   */
  public Price getPrice(){
    return this.price;
  };

  /**
   * @return whether this item is shaft-mounted. If it is, this method will return true.
   */
  public boolean isShaftMounted() {
    return this.shaftMounted;
  }

  /**
   * @return the system of measurement
   */
  public SystemOfMeasurement getSystemOfMeasurement() {
    return systemOfMeasurement;
  }

  /**
   * @return the diameter of the item
   */
  public Fraction getDiameter() {
    return diameter;
  }

  /**
   * This method is used to update the price information about an item.
   * If the input amount is smaller or equals zero, it will throw an exception.
   * @param cents enter the total price in cents, and this method will calculate the dollars amount
   * and cents amount.
   */
  public void updatePrice(int cents){
    if(cents <= 0){
      throw new IllegalArgumentException("Please Enter Valid Price");
    } else {
      this.price = new Price(cents);
    }
  }

}
