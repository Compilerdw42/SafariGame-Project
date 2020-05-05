/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
import java.awt.Image;
import java.awt.event.KeyEvent;

public abstract class Characters//class of a generic character
{
    private String name;//name of character
    private int life;//life score
    private int MOVEMENT_SPEED;//how fast char moves

    //constructor
    Characters(String nname, int llife, int speed)
    {
      name = nname;
      life = llife;
      MOVEMENT_SPEED=speed;
    }
    //constructor for loading
    Characters(String nname, String lllife, String speed)
    {
        int l = Integer.parseInt(lllife);
        int sp = Integer.parseInt(speed);

        name = nname;
        life = l;
        MOVEMENT_SPEED=sp;
    }
    //returns a character turned into a printable string
    public String toString()
    {
        String a = getName() + "\nLIFE: " + getLife();
        return a;
    }
    //returns name of character
    public String getName()
    {
        return name;
    }
    //returns life score
    public int getLife()
    {
        return life;
    } 
    //set new life value
    public void setLife(int nv)
    {
        life = nv;
    }
    //returns MOVEMENT_SPEED
    public int getMOVEMENT_SPEED()
    {
        return MOVEMENT_SPEED;
    }

}