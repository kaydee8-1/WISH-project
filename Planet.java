 
import java.util.*;
import java.lang.Iterable;
/**
 * An planet is part of a STAR resort.Each planet has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(permits) who can be on the  
 * planet at any one time. Each planet must maintain a list of all people (permits)
 * currently on the planet. These lists are updated whenever permits enter or leave 
 * an planet,so that it is always possible to say how many people (permits) are on the planet 
 * and who they are.
 * 
 * @Kaja Drozd 19036837 
 * @27th April 2022
 */

public class Planet 
{   
    private int reference_number;
    private String name;
    private int rating;
    private int capacity;
    private ArrayList<Permit> permits;
    
    //Constructor
    public Planet(int ref, String nam, int rat, int cpty)
    {
        reference_number = ref;
        name = nam;
        rating = rat;
        capacity = cpty;
        permits = new ArrayList<Permit>();
    }
    //Accessors
    public int get_id()
    {
        return reference_number; 
    }
    public String get_name()
    {
        return name;
    }
    public int get_rate()
    {
        return rating;
    }
    public int get_maxcapacity()
    {
        return capacity;
    }
    
    //permits can enter or leave Planet
    public void enter(Permit p)
    {
        if (permits.size() < capacity) 
            permits.add(p);
    }
    public void leave(Permit p)
    {
        permits.remove(p);
    }
    
    //full capacity check
    public boolean full_cap()
    {
        if (permits.size() == capacity)
              return true; //true if full capacity reached
        else return false; //there is still some space for new arivals
    }
    
    //current capacity
    public int current_cap()
    {
        return permits.size();
    }
    
    //List of permits on the planet
    public String getPermitsList()
    {
        String plist = "";
        for (Permit p : permits)
        {
            plist += p.toString() + "\n";
        }
        
        if (plist == "") return "No permits";
        return plist;
    }
    //finding permit details based on id
    public Permit findPermitbyId(int id)
    {
        for (int i=0; i < permits.size(); i++)
        {
            Permit temp = permits.get(i);
            if (temp.get_id() == id)
            {
                return temp;
            }
        }
        return null;
    }
    
    //finding permit details based on name
    public Permit findPermitbyName(String name)
    {
        for (int i=0; i < permits.size(); i++)
        {
            Permit temp = permits.get(i);
            String nn = temp.get_name();
            if (nn.equals(name))
            {
                return temp;
            }
        }
        return null;
    }
    
    //if Permit in Permit's list
    public boolean inPermitList(int id)  
    {
        for (Permit temp : permits)
        {
            if (temp.get_id() == id) return true;
        }
        return false;
    }
    
    //all details about Planet + permits list
    public String toString()
    {
        String ss = "\nId: " + reference_number + "\nName: "  + name
                  + "\nRating: " + rating + "\nCapacity: " + capacity;
        ss += "\n*****Permits List*****\n";
        ss += getPermitsList();
        return ss;
    }
}

