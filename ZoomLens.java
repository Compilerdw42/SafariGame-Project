/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//Lens can be:
//1. Gold lens
//2. Silver lens
//3. Bronze lens

public class ZoomLens extends Objects2
{
    //coolDistance increases the distance between the animal and protagonist 
    //where the photogr can take pictures from
    private int coolDistance;
    private String message;

    //constructor
    public ZoomLens(String nnn)
    {
        super(nnn);//there are 3 types of lens
        if(this.getName().equals("Gold"))
        {
            coolDistance = 50;
        }
        else if(getName().equals("Silver"))
        {
            coolDistance = 30;
        }
        else if(getName().equals("Bronze"))
        {
            coolDistance = 15;
        }
    }
    //constructor for loading
    public ZoomLens(String nnn, String picked)
    {
        super(nnn, true);

        if(picked.equals("true"))
        {
            setPickedUp(true);//there are 3 types of lens
        }
        else if(picked.equals("false"))
        {
            setPickedUp(false);//there are 3 types of lens
        }
        
        if(this.getName().equals("Gold"))
        {
            coolDistance = 50;
        }
        else if(getName().equals("Silver"))
        {
            coolDistance = 30;
        }
        else if(getName().equals("Bronze"))
        {
            coolDistance = 15;
        }

    }
    //returns a string
    public String toString()
    {
        message = "Lens is " + this.getName() + " and increases the distance by " + coolDistance;
        return message;
    }
    //returns coolDistance
    public int getCoolDistance()
    {
        return coolDistance;
    }
}