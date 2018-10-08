package edu.neu.ccs.cs5010.assignment3.HardwareOrders;

/**
 * This interface is used to define two conversion function in order to change system of measurement
 * in the future and a mixedMeasurement function, which is used to check whether the parameters of
 * the target object are under the same system of measurement.
 */
public interface Conversion {

  /**
   * This method is used to change the system of measurement into standard measurement
   * @param item the StockItem object
   * @return a new StockItem in the standard measurement
   */
  StockItem metricToStandard(StockItem item);

  /**
   * his method is used to change the system of measurement into metric measuremen
   * @param item the StockItem object
   * @return a new StockItem in the standard measurement
   */
  StockItem standardToMetric(StockItem item);

  /**
   * This method is used to check whether the parameters of the target object are under the
   * same system of measurement.
   * @param item the StockItem object
   * @return a boolean. If all the parameters in the item are under the same system of measurement,
   * it returns true; otherwise, false.
   */
  boolean mixedMeasurement(StockItem item);
}
