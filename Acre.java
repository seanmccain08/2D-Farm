public class Acre{

  private String crop;
  private double sellPrice;
  private double growPrice;
  private int harvestDays;
  private boolean crops;

  public Acre(String crop0, double sellPrice0, double growPrice0, int harvestDays0){

    crop = crop0;
    sellPrice = sellPrice0;
    growPrice = growPrice0;
    harvestDays = harvestDays0;
    crops = true;
    
  }
  public Acre(){

    crop = "No Crops";
    sellPrice = 0;
    growPrice = 0;
    harvestDays = 0;
    crops = false;
    
  }
  public String getCrop(){

    return crop;
    
  }
  public boolean enoughDays(int days){

    if(days >= harvestDays){

      return true;
      
    }
    else{

      return false;
      
    }
    
  }
  public double income(){

    return sellPrice-growPrice;
    
  }
  public double income(int days){

    double result = sellPrice-growPrice;
    double harvestAmount = days/harvestDays;
    result*=harvestAmount;
    Math.floor(result);
    return result;
    
  }
  public String toString(){

    if(crop == "No Crops"){

      return "\tNo Crops";
      
    }
    else{

      return "\tCrop: "+crop+"\tSell Price: $"+sellPrice+"\tBuy Price: $"+growPrice+"\nDays to Harvest: "+harvestDays;
      
    }
    
  }
  public boolean getCrops(){

    return crops;
    
  }
}