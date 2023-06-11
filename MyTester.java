 
import java.util.*;
/**
 * MyTester examines the methods privded in Resort class
 * 
 * @Kaja Drozd 19036837 
 * @27th April 2022
 */
public class MyTester 
{   
    private void doTest()
    {
       Resort wayward = new Resort("Wayward Asteroids");
        
       //Providing existing data
        System.out.println("All of the details of all planets including the permits \n");
        System.out.println(wayward.toString()+ "\n"); //should present all petmits
       
        System.out.println("Details of Permit 1000:\n" + wayward.getPermitDetails(1000) + "\n"); //should return permit with name Lynn
        System.out.println("\nSprite Planet id is: " + wayward.getPlanetNumber("Sprite")+ "\n\n"); //should return 1
        System.out.println("All Permits on all Planets:\n" + wayward.getAllPermitsOnEachPlanet()); //should return all permits
        System.out.println("Id 1008 - Current Location : " + wayward.getPermitLocation(1008)+ "\n"); //should return Home
        System.out.println("Permits list on Planet " + wayward.getAllPermitsOnOnePlanet("Tropicana")+ "\n\n"); // should return "No permits" as we did not add any permit there
        
        //trip for permit 1003
        System.out.println("Trip process for permit 1003");
        System.out.println(wayward.getPermitDetails(1003) + "\n"); // credits fro Olek should be 12 & current loc = Home;
        System.out.println("Can 1003 travel?: " + wayward.canTravel(1003, "ABC1")+ "\n"); ///should return true 
        System.out.println(wayward.travel(1003, "ABC1") + "\n"); //should return successful trip and take away 3 credits
        System.out.println(wayward.getPermitDetails(1003) + "\n");//credits should be 9 & current loc = Sprite
        wayward.topUpCredits(1003, 3);//credits add to 9 taken in previous line of code 9+3 =12
        System.out.println("3 credits were added\n"); 
        System.out.println(wayward.getPermitDetails(1003) + "\n"); // credits for Olek should be 12 & current loc = Sprite
        
        System.out.println("Permits on the Planet " + wayward.getAllPermitsOnOnePlanet("Sprite"));//permit 1003 should be in the list
        System.out.println("\nRich Guests with rating > 5\n" + wayward.getRichGuests() +"\n"); //only permit with luxury rating > 5 (4 permits in total)
        
        System.out.println(wayward.moveHome(1003)); 
        System.out.println("Permit 1003 details: \n" + wayward.getPermitDetails(1003) + "\n\n"); //permit 1003 current loc should be now Home
        
        System.out.println("Testing possibilities for permit to travel\n");
        System.out.println("Id 1002, shuttle ABC1: " + wayward.travel(1003, "ABC1") + "\n"); //succesful travel
        System.out.println("Id 1002, shuttle GHJ6 " + wayward.travel(1003, "GHJ6") + "\n"); //successful travel
        System.out.println("Id 1006, shuttle ABC1: " + wayward.travel(1002, "ABC1") + "\n");//successful travel
        System.out.println("Id 1006, shuttle HGJ6: " + wayward.travel(1002, "GHJ6") + "\n"); //insuccesful trip -> Full capacity of planet is reached
                                                                                           // multiple conditions may not be meet but programs dislays first unsatisfied condition
        System.out.println("Id 1005, shuttle ACB1: " + wayward.travel(1005, "ABC1") + "\n"); //successful travel
        System.out.println("Id 1005, shuttle CDE3: " + wayward.travel(1005, "ABC1") + "\n"); //unsuccessful travel - > Too few credits
        System.out.println("Id 1005 - Adding 10 credits \n");
        wayward.topUpCredits(1005, 10);
        System.out.println("Id 1005, shuttle CDE3: " + wayward.travel(1005, "ABC1") + "\n"); //unsuccessful travel - > permit not listed on the source Planet list
                                                                                           
        System.out.println("\nAll permits: \n" + wayward.getAllPermitsOnEachPlanet() + "\n"); //permit 1003 current loc = Sprite
                                                                                          //permit 1004 current loc = Tropicana
        System.out.println("\nEvacuation Home for every permit");
        wayward.evacuateAll();
        System.out.println("All permits: \n" + wayward.getAllPermitsOnEachPlanet() + "\n"); //Everyone current loc = Home
        

        //Error messages
        System.out.println("\nTesting Error messages\n");
        System.out.println("Details of permit 0: \n" + wayward.getPermitDetails(0) + "\n"); //should return "No such permit"
        System.out.println("\nDetails of Planet \"Venus\": \n" + wayward.getPlanetNumber("Venus") + "\n"); //should return -1
        System.out.println("\nLocation of permit 100: \n" + wayward.getPermitLocation(100)+ "\n"); //should return No permit found
        System.out.println("\nTropi Planet permits: \n" + wayward.getAllPermitsOnOnePlanet("Tropi")+ "\n"); //should return "No such Planet"
        System.out.println("\nCan permit 100 travel with ABC1: " + wayward.canTravel(100, "ABC1")+ "\n"); //should return false
        System.out.println("\nTrip Id 1010 --> shuttle ABC1 " + wayward.travel(1010, "ABC1") + "\n");  //should return "No permit found"
        System.out.println("\nTrip Id 1003 --> shuttle AB1 " + wayward.travel(1003, "AB1") + "\n"); // should return "No Shuttle found"
        wayward.topUpCredits(100, 3); //should not change a value of credits as there is no id =100
    }
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
