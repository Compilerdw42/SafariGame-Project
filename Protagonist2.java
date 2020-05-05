/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//Protagonist class

public class Protagonist2 extends Characters
{
    private int score;
    private int positionX;
    private int distance = 200;//the distance the protagonist can take pictures from (originally)
    private String current_object;
    private String killed_message="";
    
    //constructor
    public Protagonist2(String nname, int llife, int sscore, int posX, String co, int mov_speed)
    {
        super(nname, llife, mov_speed);//to call constructor in superclass
        positionX = posX;
        score = sscore;//score of protagonist
        current_object = co;
    }

    //returns a character turned into a printable string
    public String toString()
    {
        String a = super.toString() + "\nSCORE: "+ score;
        return a;
    }

    //INTERACTION
    //to photograph/kill an animal
    public void kill(Animals ad)
    {
        if(this.getLife()>0)
        {
            score = score + ad.getLife();//closer distance factor!
            ad.setLife(0);//set dangerous animal's life score to 0
            killed_message = "Well done! You photographed "+ad.getName();

            //get another animal
            positionX = 310;
        }
    }
    
    //to take an object
    public void takeObject(Objects2 obj)
    {   
        if(obj.getPickedUp()==false)//do sth only if not yet picked up
        {
            //System.out.println(obj.toString());
            current_object = obj.toString();//polymorphism

            obj.setPickedUp(true);//set to already picked up

            if(obj instanceof Drugs)//treat obj like a Drug
            {
                Drugs oo = (Drugs)obj;//cast the object into a subclass

                setLife(getLife() + oo.getPoints());
                System.out.println("Your life now is " + getLife());
            }
            else if(obj instanceof ZoomLens)//treat obj like ZoomLens
            {
                ZoomLens zl = (ZoomLens)obj;//cast object into subclass ZoomLens
                changeDistance(zl.getCoolDistance());//the modify the distance
            }
        }
    }

    //ACCESSOR METHODS
    //returns position X
    public int getPositionX()
    {
        return positionX;
    }
    //set new position x
    public void setPositionX(int np)
    {
        positionX = np;
    }
    //returns score
    public int getScore()
    {
        return score;
    }
    //returns the distance allowed for taking pictures
    public int getDistance()
    {
        return distance;
    }
    //changes the distance allowed for taking pictures
    public void changeDistance(int mod_dis)
    {
        distance = distance + mod_dis;
    }
    //returns current object hold by protagonist
    public String getCurrentObject()
    {
        return current_object;
    }
    //returns a String who was photographed
    public String getKilledMessage()
    {
        return killed_message;
    }

    //MOVEMENT
    //protagonist moves to the RIGHT
    public void moveRight()
    {
        //play=true;
        setPositionX(getPositionX()+getMOVEMENT_SPEED()); //playerX = playerX + 20 pixels
    }
    //protagonist moves to the LEFT
    public void moveLeft()
    {
        //play=true;
        setPositionX(getPositionX()-getMOVEMENT_SPEED());
    }

    
}