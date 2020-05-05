/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//AnimalsBasic class
public class AnimalsBasic extends Animals//background animals for extra points
{
    private String directionX;
    private String directionY;

    //constructor
    public AnimalsBasic(String nname, int speed, int posX, int posY, String dirX, String dirY, String col)
    {
        super(nname, 0, speed, posX, posY, false, col);//to call constructor in superclass
        directionX = dirX;//Right
        directionY = dirY;//Up
    }
    
    //returns an animal turned into a printable string
    public String toString()
    {
        String a = "Basic: " + super.toString();
        return a;
    }
    //returns directionX
    public String getDirectionX()
    {
        return directionX;
    }
    //returns directionY
    public String getDirectionY()
    {
        return directionY;
    }

    //MOVEMENT
    public void move(Protagonist2 p)
    {
        //like a bird ->|^|->|_...
        if(directionX.equals("R"))
        {
            if(getPosX()>=600)
            {
                directionX = "L";
                moveLeft();
                moveUpDown();
            }
            else
            {
                moveRight();
                moveUpDown();
            } 
        }
        else if(directionX.equals("L"))
        {
            if(getPosX()<25)
            {
                directionX = "R";
                moveRight();
                moveUpDown();
            }
            else
            {
                moveLeft();
                moveUpDown();
            }
        }
    }
    //to move Up and Down
    public void moveUpDown()
    {
        if(directionY.equals("D"))//Down
        {
            if(getPosY()<100)
            {
                moveUp();
                directionY = "U";
            }
            else
            {
                moveDown();
            }
        }
        else if(directionY.equals("U"))//Up
        {
            if(getPosY()>200)
            {
                moveDown();
                directionY = "D";
            }
            else
            {
                moveUp();
            }
        }
    }

}