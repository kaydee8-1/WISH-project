 
import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{
    
    private Scanner reader = new Scanner(System.in);
    private WISH wayward = new Resort("Wayward Asteroids");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllPlanets();}
            else if (choice == 2){listAllPermits();}
            else if (choice == 3){listOnePlanet();}
            else if (choice == 4){findPermitLocation();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){updateCredits();}
            else if (choice == 8){getPermitInfo();}
            else if (choice == 9){RichGuests();}
            else if (choice == 10){onePermitHome();}
            else if (choice == 11){allPermitsHome();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all planet details");
       System.out.println("2. List all permits on each planet");
       System.out.println("3. List all permits on one planet");
       System.out.println("4. Find permit location");
       System.out.println("5. Say if permit can move by shuttle");
       System.out.println("6. Move a permit by shuttle");
       System.out.println("7. Top up credits");
       System.out.println("8. Get permit details");
       System.out.println("9. Get rich guests list");
       System.out.println("10. Permit directly goes home");
       System.out.println("11. All permits go directly home");

       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllPlanets()
    {
        System.out.println("List of all planets with their permit lists\n");
        System.out.println(wayward.toString());
    }
    
    // provide the code here  
    private void listAllPermits()
    {
        System.out.println(wayward.getAllPermitsOnEachPlanet());
    }
   
    // This one has been done for you 
    private void listOnePlanet()
    {
        System.out.println("Enter name of planet");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllPermitsOnOnePlanet(ww));
    }
    
    // provide the code here
    private void findPermitLocation()
    {
        System.out.print("Enter Permit Id ");
        int Id = reader.nextInt();   
        System.out.println("Permit with Id " + Id + " location is: " + wayward.getPermitLocation(Id));  
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        reader.nextLine();
        
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    private void travelNow()
    {
       System.out.println("Enter permit id");
       int trav = reader.nextInt();
       reader.nextLine();
       
       System.out.println("Enter shuttle code");
       String shuttle = reader.nextLine();
       
       System.out.println(wayward.travel(trav,shuttle));
    }
    
    // Provide the code here
    private void updateCredits()
    {
       System.out.println("Enter permit id");
       int trav = reader.nextInt();
       reader.nextLine();
       System.out.println("Enter number of credits to add");
       int cred = reader.nextInt();
       
       wayward.topUpCredits(trav,cred);
    }
    
    // This one has been done for you  
    private void getPermitInfo()
    {
        System.out.println("Enter permit id");
        int trav = reader.nextInt();
        System.out.println(wayward.getPermitDetails(trav));
    }
   
    private void RichGuests()
    {
        System.out.println(wayward.getRichGuests());
    }
    
    private void onePermitHome()
    {
         System.out.println("Enter permit id");
         int trav = reader.nextInt();
         System.out.println(wayward.moveHome(trav));
    }
    
    private void allPermitsHome()
    {
        System.out.println(wayward.evacuateAll());
    }
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
