 import java.util.*;
/**
 * PermitTester examines the method provided in Permit class
 *
 * @Kaja Drozd 19036837 
 * @27th April 2022
 */
public class PermitTester
{  
    private ArrayList<Permit> perm = new ArrayList<Permit>();
    private Planet Pl = new Planet(0, "Home", 0, 1000);// according to specification
    private String p = Pl.get_name();
    private void DoTest()
    {
      Permit p1 = new Permit(1, "Kaja Drozd", 10, 4, p);
      Permit p2 = new Permit(2, "Woody Allen", 5, 9, p);
      //error input
      Permit p3 = new Permit(3, "Martin Scorsese", -1, 10, p); //should set luxury rating to 0
      Permit p4 = new Permit(4, "Louis de Funes", 4, -20, p); //should set credits to 0
      
      perm.add(p1);
      perm.add(p2);
      perm.add(p3);
      perm.add(p4);

      for (int index=0; index < perm.size(); ++index)
      {
          //extracting information about permit
          Permit temp = perm.get(index);
          System.out.println("Permit " + temp.get_id() +" information: \n");
          System.out.println("Id: " + temp.get_id());
          System.out.println("Name: " + temp.get_name());
          System.out.println("Credits: " +  temp.get_credits()); 
          System.out.println("Luxury rating: " + temp.get_rate());
          System.out.println("Current location: " + temp.get_loc());
         
          //checking credits
          System.out.println("Can guest "+temp.get_name() +" have enough credits fora shuttle? : "+ temp.enough_cred());
          temp.add_credits(31);
          System.out.println("Adding 31 credits \nCredits: " + temp.get_credits());
          temp.ded_credits(9);
          System.out.println("Deducting 9 credits \nCredits: " + temp.get_credits());
          System.out.println("Can guest "+temp.get_name() +" have enough credits for a shuttle? : "+ temp.enough_cred());
          
          //Final reading string to check final version of permit
          System.out.println("\nAll info about Permit"+ (index+1) + ": \n"+ temp.toString()+"\n");
        
      }
    }
    
    public static void main(String[] args)
    {
        PermitTester xx = new PermitTester();
        xx.DoTest();
    }

}
