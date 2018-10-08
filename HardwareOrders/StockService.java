package edu.neu.ccs.cs5010.assignment3.HardwareOrders;

import edu.neu.ccs.cs5010.assignment3.HardwareOrders.Fraction;
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.Price;
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.RotaryShaft;
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.SystemOfMeasurement;
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.BallBearing;
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.Sprocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is used to mimic the behavior of a database interface
 */
public class StockService {
  private HashMap<String, StockItem> stock;

  /**
   * This method is used to get the current stock
   * @return the hashmap of item stock
   */
  public HashMap<String, StockItem> getStock() {
    return stock;
  }

  /**
   * This constructor creates a hashmap which represents the stock database
   */
  public StockService(){
    this.stock = new HashMap<>()  ;
    RotaryShaft carbonSteel = new RotaryShaft("RotaryShaft", "1327K3",
        new Price(428), false, new Fraction(3, 0, 1),
        new Fraction(0, 1, 32), SystemOfMeasurement.STANDARD);
    RotaryShaft carbonSteelMetric = new RotaryShaft("RotaryShaft", "1482K11",
        new Price(768), false, new Fraction(200, 0, 1),
        new Fraction(10, 0, 1), SystemOfMeasurement.METRIC);
    BallBearing ballBearingMetric = new BallBearing("BallBearing", "5972K323", new Price(754),
        SealType.SHIELDED, new Fraction(8, 0,1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC, true);
    RotaryShaft fits = new RotaryShaft("RotaryShaft", "1482K25", new Price(4009),
        false, new Fraction(2000, 0, 1), new Fraction(12, 0, 1),
        SystemOfMeasurement.METRIC);
    RotaryShaft unfits = new RotaryShaft("RotaryShaft", "1482K49", new Price(1755),
        false, new Fraction(200, 0, 1), new Fraction(30, 0, 1),
        SystemOfMeasurement.METRIC);
    BallBearing ballBearingOpen = new BallBearing("BallBearing", "5972K91", new Price(432),
        SealType.OPEN, new Fraction(7, 0, 1), new Fraction(8, 0, 1),
        SystemOfMeasurement.STANDARD, true);
    BallBearing ballBearingSealed  = new BallBearing("BallBearing", "5972K225", new Price(2026),
        SealType.SEALED, new Fraction(6, 0, 1), new Fraction(7, 0 , 1),
        SystemOfMeasurement.METRIC, true);
    Sprocket sprocketStandard = new Sprocket("Sprocket", "2737T1", new Price(996),
        9, new Fraction(0, 1, 4), SystemOfMeasurement.STANDARD, true);
    Sprocket sprocketInch = new Sprocket("Sprocket", "2302K22", new Price(2243),
        16, new Fraction(12, 0, 1), SystemOfMeasurement.METRIC, true);

    stock.put("1327K3", carbonSteel);
    stock.put("1482K11", carbonSteelMetric);
    stock.put("5972K323", ballBearingMetric);
    stock.put("1482K25", fits);
    stock.put("1482K49", unfits);
    stock.put("5972K91", ballBearingOpen);
    stock.put("5972K225", ballBearingSealed);
    stock.put("2737T1", sprocketStandard);
    stock.put("2302K22", sprocketInch);

  }

}
