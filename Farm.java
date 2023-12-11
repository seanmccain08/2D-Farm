import java.util.*;

public class Farm {

  private Acre[][] farm;
  public Scanner scan = new Scanner(System.in);

  public Farm(int rows, int columns) {

    farm = new Acre[rows][columns];

  }

  public void plant() {

    boolean breakLoop = false;
    for (int i = 0; i < farm.length; i++) {

      for (int j = 0; j < farm[0].length; j++) {

        System.out.println("What would you like to plant on the acre at row " + (i + 1) + ", column " + (j + 1) + "?");
        breakLoop = false;
        while (breakLoop == false) {
          System.out.println("1. Corn\n2. Potatoes\n3. Soybeans\n4. Wheat\n5. Tree Nuts\n6. No crops on this acre");
          int choice = scan.nextInt();
          switch (choice) {

            case 1:
              farm[i][j] = new Acre("Corn", 153.0, 103.0, 60);
              breakLoop = true;
              break;
            case 2:
              farm[i][j] = new Acre("Potatoes", 485.0, 336.0, 70);
              breakLoop = true;
              break;
            case 3:
              farm[i][j] = new Acre("Soybeans", 9.64, 3.78, 45);
              breakLoop = true;
              break;
            case 4:
              farm[i][j] = new Acre("Wheat", 827.0, 170.0, 240);
              breakLoop = true;
              break;
            case 5:
              farm[i][j] = new Acre("Tree Nuts", 7200.0, 5800.0, 365);
              breakLoop = true;
              break;
            case 6:
              farm[i][j] = new Acre();
              breakLoop = true;
              break;
            default:
              System.out.println("Please make a valid choice.");
              break;

          }

        }
      }

    }

  }

  public String toString() {

    String result = "";
    for (int i = 0; i < farm.length; i++) {

      for (int j = 0; j < farm[0].length; j++) {

        if(farm[i][j].getCrops()){

          result = result + "\nRow " + (i + 1) + ", column " + (j + 1) + ":" + farm[i][j].toString();
          
        }
        else{

          result = result + "\n\u001B[33mRow " + (i + 1) + ", column " + (j + 1) + ":\u001B[0m" + farm[i][j].toString();
          
        }

      }

    }

    return result;

  }
  public String countAcres(){

    int totalAcres = farm.length*farm[0].length;
    int cornCount = 0;
    int potatoCount = 0;
    int soybeanCount = 0;
    int wheatCount = 0;
    int treenutCount = 0;
    int noCropCount = 0;
    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        if(farm[i][j].getCrop() == "Corn"){

          cornCount++;
          
        }
        else if(farm[i][j].getCrop() == "Potatoes"){

          potatoCount++;

        }
        else if(farm[i][j].getCrop() == "Soybeans"){

          soybeanCount++;

        }
        else if(farm[i][j].getCrop() == "Wheat"){

          wheatCount++;

        }
        else if(farm[i][j].getCrop() == "Tree Nuts"){

          treenutCount++;

        }
        else{

          noCropCount++;
          
        }
      }
      
    }
    return "Total Acres: "+totalAcres+"\nCorn Acres: "+cornCount+"\nPotato Acres: "+potatoCount+"\nSoybean Acres: "+soybeanCount+"\nWheat Acres: "+wheatCount+"\nTree Nut Acres: "+treenutCount+"\nAcres without crops: "+noCropCount;
    
  }
  public void setBad(){

    while(true){
      System.out.println("Which acre went bad?");
      for(int i = 0; i < farm.length; i++){
  
        for(int j = 0; j < farm[0].length; j++){
  
          System.out.println("Row "+(i+1)+", column "+(j+1)+" ("+farm[i][j].getCrop()+")");
          
        }
        
      }
      int row = 0;
      int column = 0;
      System.out.print("\nRow: ");
      row = scan.nextInt()-1;
      System.out.print("Column: ");
      column = scan.nextInt()-1;
      if(row < 0 || row > farm.length || column < 0 || column > farm[0].length){

        System.out.println("Invalid data! Please enter numbers corresponding to the acre you want to change.");
        
      }
      else{
        
        farm[row][column].setBad();
        break;
        
      }
    }
    
  }
  public void checkDays(){

    System.out.println("How many days?");
    int days = scan.nextInt();
    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        if(farm[i][j].getCrops() == false){

          System.out.println("\u001B[33mRow "+(i+1)+", column "+(j+1)+":\u001B[0m "+farm[i][j].getCrop());

        }
        else if(farm[i][j].enoughDays(days)){

          System.out.println("Row "+(i+1)+", column "+(j+1)+": "+farm[i][j].getCrop()+" will harvest in "+days+" days.");
          
        }
        else{
          
          System.out.println("\u001B[31mRow "+(i+1)+", column "+(j+1)+": \u001B[0m"+farm[i][j].getCrop()+" will \u001B[31mNOT\u001B[0m harvest in "+days+" days.");
          
        }
        
      }

    }
    
  }
  public void harvestIncome(){

    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        if(farm[i][j].getCrops()){
          int income0 = (int)(farm[i][j].income()*100);
          double income = income0;
          income = income/100;
          System.out.println("Row "+(i+1)+", column "+(j+1)+": "+farm[i][j].getCrop()+" will make $"+income);
          
        }
        else{

          System.out.println("\u001B[33mRow "+(i+1)+", column "+(j+1)+": \u001B[0m"+farm[i][j].getCrop());
          
        }
          
      }

    }
    
  }
  public void harvestIncomeDays(){

    System.out.println("How many days?");
    int days = scan.nextInt();
    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        if(farm[i][j].getCrops()){
          System.out.println("Row "+(i+1)+", column "+(j+1)+": "+farm[i][j].getCrop()+" will make $"+farm[i][j].income(days));

        }
        else{

          System.out.println("\u001B[33mRow "+(i+1)+", column "+(j+1)+": \u001B[0m"+farm[i][j].getCrop());

        }

      }

    }
    
  }

}