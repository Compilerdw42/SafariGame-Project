/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//class Animals

public abstract class Animals extends Characters
{
    private int positionX;
    private int positionY;
    private boolean sleeping;
    private String colour;

    //constructor
    public Animals(String nname, int llife, int speed, int posX, int posY, boolean sleep, String col)
    {
        super(nname, llife, speed);
        positionX = posX;
        positionY = posY;
        sleeping = sleep;
        colour = col;//BLUE, CYAN, ORANGE -> not white, black, pink
    }
    //constructor for loading
    public Animals(String nam, String lif, String mov_speed, String pX, String pY, String slp, String clr)
    {
        super(nam, lif, mov_speed);
        int x = Integer.parseInt(pX);
        int y = Integer.parseInt(pY);

        if(slp.equals("true"))
        {
            sleeping = true;
        }
        else if(slp.equals("false"))
        {
            sleeping = false;
        }

        positionX = x;
        positionY = y;
        colour = clr;
    }

    //ACCESSOR METHODS
    //returns position X
    public int getPosX()
    {
        return positionX;
    }
    //returns position Y
    public int getPosY()
    {
        return positionY;
    }
    //sets new value to position X
    public void setPosX(int val)
    {
        positionX = val;
    }
    //sets new value to position Y
    public void setPosY(int val)
    {
        positionY = val;
    }
    //returns colour
    public String getColour()
    {
        return colour;
    }

    public String toString()
    {
        String a = super.toString() + " sleeping: " + sleeping;
        return a;
    }

    //MOVEMENT
    public void move(Protagonist2 p)
    {
        moveRight();
        //moveUp();
    }
    //move Right
    public void moveRight()
    {
        positionX = positionX + getMOVEMENT_SPEED();
    }
    //move Left
    public void moveLeft()
    {
        positionX = positionX - getMOVEMENT_SPEED();
    }
    //move Up
    public void moveUp()
    {
        positionY = positionY + getMOVEMENT_SPEED();
    }
    //move Down
    public void moveDown()
    {
        positionY = positionY - getMOVEMENT_SPEED();
    }

    //returns sleeping
    public boolean getSleeping()
    {
        return sleeping;
    }
    //because didn't want to cast objs in Gameplay2
    public boolean getAnimalOK()
    {
        return true;
    }
    //set animalOK (update it)
    public void setAnimalOK(boolean value)
    {}
    //returns dangerDistance
    public int getDangerDistance()
    {
        return 0;
    }
}