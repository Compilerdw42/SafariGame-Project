/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//class of generic object

public class Objects2
{
    private String name;
    private boolean already_picked_up;

    //constructor
    public Objects2(String nname)
    {
        name = nname;
        already_picked_up = false;
    }
    //constructor for loading
    public Objects2(String nname, boolean picked)
    {
        name = nname;
        already_picked_up = picked;
    }

    //returns a string
    public String toString()
    {
        String a = "Object " + name;
        return a;
    }
    //returns name
    public String getName()
    {
        return name;
    }
    
    //returns already_picked_up
    public boolean getPickedUp()
    {
        return already_picked_up;
    }
    //changes already_picked_up
    public void setPickedUp(boolean val)
    {
        already_picked_up = val;
    }
}
