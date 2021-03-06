package edu.neu.ccs.cs5010.assignment2;

/**
 * This method is used to construct a sprocket instance, and it extends from the super
 * class StockItem, implements the interface ShaftMounted.
 * This method provide several fields other than common fields, including teeth, shaft diameter
 * and system of measurement.
 * It also provide a function to determine whether this sprocket object fits the shaft.
 */
public class Sprocket extends StockItem implements ShaftMounted {
  private int teeth;
  private Fraction shaftDiameter;
  private SystemOfMeasurement systemOfMeasurement;

  /**
   * Construct a Sprocket object with the following parameters.
   * If the input parameters is null or other form of invalid input, it will throw an Exception.
   * @param category the category information about this item
   * @param SKUNumber the SKU Number information about this item
   * @param price the price information of this item
   * @param teeth the number of teeth of this item
   * @param shaftDiameter the shaft diameter of this item
   * @param shaftMounted whether this item is shaft-mounted
   */
  public Sprocket(String category, String SKUNumber, Price price, int teeth, Fraction shaftDiameter,
      SystemOfMeasurement systemOfMeasurement, boolean shaftMounted) {
    super(category, SKUNumber, price, true);
    if(category == null || category.length() == 0 || SKUNumber == null || SKUNumber.length() == 0 ||
        shaftDiameter == null || price == null){
      throw new IllegalArgumentException("Not NULL");
    }
    this.teeth = teeth;
    this.shaftDiameter = shaftDiameter;
    this.systemOfMeasurement = systemOfMeasurement;
  }

  /**
   * @return the number of teeth of this item
   */
  public int getTeeth() {
    return this.teeth;
  }

  /**
   * @return the shaft diameter of this item
   */
  public Fraction getShaftDiameter() {
    return this.shaftDiameter;
  }

  /**
   * @return the system of measurement this item uses
   */
  public SystemOfMeasurement getSystemOfMeasurement() {
    return systemOfMeasurement;
  }

  /**
   * This method is used to determine whether this item fits the shaft object. It will compare the
   * diameter information of them, if integer part, numerator and denominator all these three parts
   * are equal, it will returns true; otherwise, returns false.
   * @param shaft the Rotary Shaft object
   * @return a boolean. If this item fits the shaft object, it returns true, otherwise return false.
   */
  @Override
  public boolean fitsShaft(RotaryShaft shaft) {
    if(shaft.getDiameter().getIntegerPart() == this.shaftDiameter.getIntegerPart()
        && shaft.getDiameter().getNumerator() == this.shaftDiameter.getNumerator()
        && shaft.getDiameter().getDenominator() == this.shaftDiameter.getDenominator()){
      return true;
    } else {
      return false;
    }
  }
}
