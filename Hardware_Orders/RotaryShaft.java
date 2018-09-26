package edu.neu.ccs.cs5010.assignment2;

/**
 * This method is used to construct a rotary shaft instance, and it extends from the super
 * class StockItem.
 * This method provide several fields other than common fields, including length diameter and
 * system of measurement.
 */
public class RotaryShaft extends StockItem {
  private Fraction length;
  private Fraction diameter;
  private SystemOfMeasurement systemOfMeasurement;

  /**
   * Construct a rotary shaft object with the following parameters.
   * If the input parameters is null or other form of invalid input, it will throw an Exception.
   * @param category the category information about this item
   * @param SKUNumber the SKU Number information about this item
   * @param price the price information of this item
   * @param shaftMounted whether this item is shaft-mounted
   * @param length the length of this item
   * @param diameter the diameter of this item
   * @param systemOfMeasurement which system of measurement this item use
   */
  public RotaryShaft(String category, String SKUNumber, Price price, boolean shaftMounted,
      Fraction length, Fraction diameter, SystemOfMeasurement systemOfMeasurement) {
    super(category, SKUNumber, price, shaftMounted);
    if(category == null || category.length() == 0 || SKUNumber == null || SKUNumber.length() == 0 ||
        length == null || diameter == null || price == null){
      throw new IllegalArgumentException("Not NULL");
    }
    this.length = length;
    this.diameter = diameter;
    this.systemOfMeasurement = systemOfMeasurement;
  }

  /**
   * @return the system of measurement of this item
   */
  public SystemOfMeasurement getSystemOfMeasurement() {
    return systemOfMeasurement;
  }

  /**
   * @return the length information of this item in the form of fraction
   */
  public Fraction getLength(){
    return this.length;
  }

  /**
   * @return the diameter information of this item in the form of fraction
   */
  public Fraction getDiameter(){
    return this.diameter;
  }
}
