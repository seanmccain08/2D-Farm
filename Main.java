import java.util.*;
class Main{
  public static void main(String[] args) {
    
    int choice = 0;
    boolean running = true;
    Scanner scan = new Scanner(System.in);
    while(running){

      System.out.println("How many rows of acres?");
      int rows = scan.nextInt();
      System.out.println("How many columns of acres?");
      int columns = scan.nextInt();
      Farm farm0 = new Farm(rows, columns);
      farm0.plant();
      System.out.println("\nFarm successfully created!");
      
      while(true){

        System.out.println("\n1. Print crops\n2. Count acres of a crop\n3. Change acre to bad\n4. Check harvest days\n5. Income per harvest\n6. Income over # of days\n7. Quit");
        choice = scan.nextInt();
        switch(choice){

          case 1:
            System.out.println(farm0.toString());
            break;
            
          case 2:
            break;
            
          case 3:
            break;
            
          case 4:
            break;
            
          case 5:
            break;
            
          case 6:
            break;
            
          case 7:
            break;
            
          default:
            System.out.println("Please make a valid choice.");
            break;
            
        }
      }
      
    }
  }
}