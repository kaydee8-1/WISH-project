 
/**
 * A Permit has an id number, name, a luxury rating and number of credits.
 * 
 * @Kaja Drozd 19036837 
 * @27th April 2022
 */
public class Permit 
{
     private int permit_ID;
     private String guest_name;
     private int luxury_rating;
     private int number_of_credits;
     private String current_loc;
    //Constructor
    public Permit(int ID, String name, int lux_rate, int num_cred, String p)
    { 
        permit_ID = ID;
        guest_name = name;
        if (lux_rate > 10 || lux_rate < 0) 
            {
               lux_rate = 0;
            }
        luxury_rating = lux_rate;
        number_of_credits = num_cred;
         if (number_of_credits < 0) 
            {
                number_of_credits = 0;
            }
        current_loc = p;
        
    }
    //Accessors
    public int get_id()
    {
        return permit_ID;
    }
    public String get_name()
    {
        return guest_name; 
    } 
    public int get_credits()
    {
        return number_of_credits;
    }
    public int get_rate()
    {
        return luxury_rating;
    }
    public String get_loc()
    {
        return current_loc;
    }
    //Adding&deducting credits
    public int add_credits(int num)
    {
        return number_of_credits += num;
    }
    public int ded_credits(int num)
    {
        if (number_of_credits - num < 0) 
            {
               return 0;
            }
        return number_of_credits -= num;
    }
    
    //Check if there are enough credtis for shuttle
    public boolean enough_cred()
    {
        if (number_of_credits >= 3) 
        {
            return true;
        }
        return false;
    }
    
    //String with all information
    public String toString()
    {
        String s = "Id: " + permit_ID + " |Name: " + guest_name + " |Luxury rates: " + luxury_rating +
                   "|Credits: " + number_of_credits + " |Current location: "+ current_loc;
        return s;
    }
    public void change_loc(String new_place)
    {
        current_loc = new_place;
    }
    
}

