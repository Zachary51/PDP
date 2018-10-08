package edu.neu.ccs.cs5010.assignment3.HardwareOrders;

/**
 * This class is used to maintain a current order in the form of a list
 * of SKU#s and implement the following public methods
 */
import edu.neu.ccs.cs5010.assignment3.HardwareOrders.StockService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderManager extends StockService{
  private List<String> order;
  private HashMap<String, StockItem> stock;

  /**
   * Construct an OrderManager object with an empty order list and
   * the stock object inherited from StockService class
   */
  public OrderManager() {
    this.order = new ArrayList<>();
    this.stock = new StockService().getStock();
  }

  /**
   * @return the item order
   */
  public List<String> getOrder() {
    return this.order;
  }

  /**
   * This method takes a SKU# as an argument and add that item to the current order
   * @param SKUNumber
   */
  public void addToOrder(String SKUNumber){
    if(SKUNumber == null || SKUNumber == ""){
      throw new IllegalArgumentException("SKUNumber cannot be empty");
    }
    if(this.order.contains(SKUNumber)){
      throw new IllegalArgumentException("Sorry! This Item Has Already Be Added Before");
    } else {
      this.order.add(SKUNumber);
      System.out.println("Great! Your Order Has Already Been Added");
    }
  }

  /**
   * This method takes a SKU# as an argument and remove it from the current order
   * @param SKUNumber
   */
  public void removeOneFromOrder(String SKUNumber){
    if(SKUNumber == null || SKUNumber == ""){
      throw new IllegalArgumentException("SKUNumber cannot be empty");
    }
    if(this.order.size() == 0){
      throw new IllegalArgumentException("Your Order Is Empty!");
    } else {
      if(!this.order.contains(SKUNumber)){
        throw new IllegalArgumentException("You Haven't Order This Item yet");
      } else {
        this.order.remove(SKUNumber);
        System.out.println("You Have Removed Your Order Successfully");
      }
    }
  }

  /**
   * This method is used to confirm that all items in the current order conform
   * to the same measurement of system
   * @return
   */
  public boolean validateMeasurementSystem(){
    SystemOfMeasurement measurement = stock.get(order.get(0)).getSystemOfMeasurement();
    for(int i = 0; i < order.size(); i++){
      if(stock.get(order.get(i)).getSystemOfMeasurement() != measurement){
        return false;
      }
    }
    return true;
  }

  /**
   * This method is used to filter out all the items that belong to the same
   * target measurement system
   * @param systemOfMeasurement
   */
  public void filterByMeasurementSystem(SystemOfMeasurement systemOfMeasurement){
    for(int i = 0; i < order.size(); i++){
      if(stock.get(order.get(i)).getSystemOfMeasurement() != systemOfMeasurement){
        order.remove(i);
      }
    }
  }

  /**
   * This method is used to check whether all items in the current order
   * share the same category
   * @return
   */
  public String orderCategory(){
    String orderCategory = stock.get(order.get(0)).getCategory();
    for(int i = 0; i < order.size(); i++){
      if(stock.get(order.get(i)).getCategory() != orderCategory){
        return "Mixed";
      }
    }
    return orderCategory;
  }

  /**
   * This method is used to print out a tabulated report of the current order
   */
  public void printDocket(){
    int TotalDollars = 0;
    int TotalCents = 0;
    if(order.isEmpty()){
      throw new IllegalArgumentException("There is no order");
    } else {
      for(int i = 0; i < order.size(); i++){
        System.out.println("No." + i + " Category: " + stock.get(order.get(i)).getCategory() +
        " SKU#: " + stock.get(order.get(i)).getSKUNumber() + " Price: " + stock.get(order.get(i)).getPrice().toString());
        TotalDollars += stock.get(order.get(i)).getPrice().getDollars();
        TotalCents += stock.get(order.get(i)).getPrice().getCents();
      }
      System.out.print("The total price of this order is " + TotalDollars + " dollars and " + TotalCents + " cents");
    }
  }

  /**
   * This method takes two arbitrary stock item SKU#s and determine
   * whether they represent a shaft/shaft-mounted pair of the items
   * @param itemA
   * @param itemB
   * @return
   */
  public boolean checkFit(String itemA, String itemB){
    if(itemA == null || itemB == null || itemA == "" || itemB == ""){
      return false;
    } else {
      if(this.stock.get(itemA).isShaftMounted() != this.stock.get(itemB).isShaftMounted()){
        if(stock.get(itemA) instanceof RotaryShaft){
          return printCheckFit(itemB, itemA);
        } else {
          return printCheckFit(itemA, itemB);
        }
      } else {
        System.out.print("Not a Shaft/Shaft-mounted pair");
        return false;
      }
    }
  }

  /**
   * This is a helper method which is used to check whether two fractions are equal
   * @param itemA
   * @param itemB
   * @return
   */
  public boolean compareFraction(String itemA, String itemB){
    if(this.stock.get(itemA).getDiameter().getIntegerPart() == this.stock.get(itemB).getDiameter().getIntegerPart() &&
        this.stock.get(itemA).getDiameter().getNumerator() == this.stock.get(itemB).getDiameter().getNumerator() &&
        this.stock.get(itemA).getDiameter().getDenominator() == this.stock.get(itemB).getDiameter().getDenominator()){
      return true;
    } else {
      return false;
    }
  }

  /**
   * This is a helper function which is used to pr int out the standard output
   * @param shaftMounted
   * @param shaft
   * @return
   */
  public boolean printCheckFit(String shaftMounted, String shaft){
    if(compareFraction(shaftMounted, shaft)){
      System.out.print(stock.get(shaftMounted).getCategory() + " SKU# "
          + stock.get(shaftMounted).getSKUNumber() + " for "
          + stock.get(shaft).getDiameter().realNumber() + " mm shaft fits on Rotary Shafts SKU# "
          + stock.get(shaft).getSKUNumber());
      return true;
    } else {
      System.out.print(stock.get(shaftMounted).getCategory() + " SKU# "
          + stock.get(shaftMounted).getSKUNumber() + " for "
          + stock.get(shaft).getDiameter().realNumber() + " mm shaft does not fit on Rotary Shafts SKU# "
          + stock.get(shaft).getSKUNumber());
      return false;
    }
  }

}
