/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//class of drugs
//a drug can be good or bad (poison)

public class Drugs extends Objects2
{
    private int points;
    private String message;//can make it class variable
    
    //constructor
    public Drugs(String nn)
    {
        super(nn);
        
        if(Math.random()>0.5)
            points = 10;//good drug
        else
            points = -10;//bad drug
    }

    //constructor for loading
    public Drugs(String nn, String picked_up, int ppoints)
    {
        super(nn, true);

        if(picked_up.equals("true"))
        {
            setPickedUp(true);
        }
        else if(picked_up.equals("false"))
        {
            setPickedUp(false);
        }
        points = ppoints;
    }
    //returns points
    public int getPoints()
    {
        return points;
    }
    //returns a string
    public String toString()
    {
        if(getPoints()>0)
        {
            message = "Drug " + getName() + " is good and worth " + points + " life points";
        }
        else if(getPoints()<0)
        {
            message = "This " + getName() + " is a poison and has damage " + points + " points";
        }

        return message;
    }
}