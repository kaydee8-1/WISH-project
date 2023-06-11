 
/**
 * A shuttle provides a one-way connection between two planets. It
 * has a Shuttle code and information about both the source and
 * the destination planet
 * 
 * @Kaja Drozd 19036837 
 * @27th April 2022
 */
public class Shuttle
{
    private String journey_code;
    private Planet source;
    private Planet dest;
    //Constructor
    public Shuttle(String j_code, Planet j_source, Planet j_dest)
    {
        journey_code = j_code;
        source = j_source;
        dest = j_dest;     
    }
    
    //Accessor
    public String get_code()
    {
        return journey_code;
    }
    public Planet get_source()
    {
        return source; 
    }
    public Planet get_dest()
    {
        return dest; 
    }
    
    //checking condition for travel
    public boolean request(Permit p)
    {
       //1.permit's luxury rating is lower than the rating of the destination planet
       if (p.get_rate() < dest.get_rate()) return false;
       
       //2.the arrival of the permit would exceed the maximum capacity of the destination planet
       else if (dest.full_cap() == true) return false;
       
       //3.the permit does not have enough credits for the journey
       else if (p.enough_cred() == false) return false;
       
       //4.the permit is not listed in the source planet for the shuttle 
       else if (source.inPermitList(p.get_id()) == false) return false;
       
       else return true;
    }
    
    //travel
    public String moveToDest(Permit p)
    {
        if (p.get_rate() < dest.get_rate()) 
        {
            return "Permit's luxury rating is too low";
        }
        else if (dest.full_cap() == true)
        {
            return "Full capacity of destination is reached";
        }
        else if (p.enough_cred() == false)
        {
            return "Too few credits on permit's account";
        }
        else if (source.inPermitList(p.get_id()) == false)
        {
            return "Permit not listed on the source Planet list";
        }
        else
        {
            source.leave(p);
            dest.enter(p);
            p.change_loc(dest.get_name());
            p.ded_credits(3);
            return "Permit " + p.get_name() + " was succesfully moved to " + dest.get_name();
        }
    }
    
    //details of a shuttle
    public String toString()
    {
        String ss = "\nJourney code: " + journey_code + 
                    "\nSource id & name: " + source.get_id() + " " + source.get_name() +
                    "\nDestination id & name: " + dest.get_id() + " " + dest.get_name();
        return ss;
    }
    
}
