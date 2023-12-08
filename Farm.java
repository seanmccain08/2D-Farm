import java.util.*;
public class Farm{

  private Acre[][] farm;
  public Scanner scan = new Scanner(System.in);

  public Farm(int rows, int columns){

    farm = new Acre[rows][columns];

  }
  public void plant(){

    boolean breakLoop = false;
    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        System.out.println("What would you like to plant on the acre at row "+(i+1)+", column "+(j+1)+"?");
        breakLoop = false;
        while(breakLoop == false){
          System.out.println("1. Corn\n2. Potatoes\n3. Soybeans\n4. Wheat\n5. Tree Nuts\n6. No crops on this acre");
          int choice = scan.nextInt();
          switch(choice){

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
  public String toString(){

    String result = "";
    for(int i = 0; i < farm.length; i++){

      for(int j = 0; j < farm[0].length; j++){

        result = result + "\nRow "+(i+1)+", column "+(j+1)+":"+farm[i][j].toString();
        
      }
      
    }
    
    return result;
    
  }
  
}