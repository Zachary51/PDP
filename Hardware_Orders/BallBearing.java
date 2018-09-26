package edu.neu.ccs.cs5010.assignment2;

/**
 * This method is used to construct a ball bearing instance, and it extends from the super
 * class StockItem, implements the interface ShaftMounted.
 * This method provide several fields other than common fields, including sealtype, width,
 * shaft diameter and system of measurement.
 * It also provide a function to determine whether this ball bearing object fits the shaft.
 */
public class BallBearing extends StockItem implements ShaftMounted {
  private SealType sealType;
  private Fraction width;
  private Fraction shaftDiameter;
  private SystemOfMeasurement systemOfMeasurement;

  /**
   * Construct a ball bearing object with the following parameters.
   * If the input parameters is null or other form of invalid input, it will throw an Exception.
   * @param category the category information about this item
   * @param SKUNumber the SKU Number information about this item
   * @param price the price information of this item
   * @param sealType the seal type of this item
   * @param width the width of this item
   * @param shaftDiameter the shaft diameter of this item
   * @param systemOfMeasurement which system of measurement this item use
   * @param shaftMounted whether this item is shaft-mounted
   */
  public BallBearing(String category, String SKUNumber, Price price,
      SealType sealType, Fraction width, Fraction shaftDiameter,
      SystemOfMeasurement systemOfMeasurement, boolean shaftMounted) {
    super(category, SKUNumber, price, true);
    if(category == null || category.length() == 0 || SKUNumber == null || SKUNumber.length() == 0 ||
        width == null || shaftDiameter == null || price == null){
      throw new IllegalArgumentException("Not NULL");
    }
    this.sealType = sealType;
    this.width = width;
    this.shaftDiameter = shaftDiameter;
    this.systemOfMeasurement = systemOfMeasurement;
  }

  /**
   * @return the seal type of this item
   */
  public SealType getSealType() {
    return this.sealType;
  }

  /**
   * @return the width of this item in the form of Fraction
   */
  public Fraction getWidth() {
    return this.width;
  }

  /**
   * @return the system of measurement of this item
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
