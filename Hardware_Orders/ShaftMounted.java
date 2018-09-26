package edu.neu.ccs.cs5010.assignment2;

/**
 * This interface is used to define a fitsShaft method, which is used to determine whether the
 * item object can fits the target shaft. It will be implemented in the concrete class which is
 * shaft-mounted
 */
public interface ShaftMounted {

  /**
   * This method is used to determine whether the item object can fits the target shaft
   * @param shaft the RotaryShaft object
   * @return a boolean. If this item fits the shaft object, it returns true, otherwise return false.
   */
  boolean fitsShaft(RotaryShaft shaft);

}
