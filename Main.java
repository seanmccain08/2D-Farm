import java.util.*;
class Main{
public static void main(String[] args) {
  
  int choice = 0;
  boolean running = true;
  Scanner scan = new Scanner(System.in);
  System.out.println("How many rows of acres?");
  int rows = scan.nextInt();
  System.out.println("How many columns of acres?");
  int columns = scan.nextInt();
  Farm farm0 = new Farm(rows, columns);
  farm0.plant();
  System.out.println("\nFarm successfully created!");
  
  while(running){

    System.out.println("\n1. Print crops\n2. Count acres of a crop\n3. Change acre to bad\n4. Check harvest days\n5. Income per harvest\n6. Income over # of days\n7. Quit");
    choice = scan.nextInt();
    switch(choice){

      case 1:
        System.out.println(farm0.toString());
        break;
        
      case 2:
        System.out.println(farm0.countAcres());
        break;
        
      case 3:
        farm0.setBad();
        break;
        
      case 4:
        farm0.checkDays();
        break;
        
      case 5:
        farm0.harvestIncome();
        break;
        
      case 6:
        farm0.harvestIncomeDays();
        break;
        
      case 7:
        System.out.println("Are you sure you want to quit?");
        System.out.println("1. Yes\n2. No");
        choice = scan.nextInt();
        if(choice == 1){

          System.out.println("\nQuitting...");
          running = false;

        }
        break;
        
      default:
        System.out.println("Please make a valid choice.");
        break;
        
    }
  }
    
  }
}
