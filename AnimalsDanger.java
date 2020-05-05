/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//AnimalsDanger class
public class AnimalsDanger extends Animals//Dangerous animals
{
    protected int damage;//damage caused when attacks the protagonist
    private boolean animalOK;//true -> animal alive (not yet photograhped), false -> animal dead
    private int dangerDistance;//distance from which the animal attacks
    private String who_attacked;
    
    //constructor
    public AnimalsDanger(String nname, int llife, int speed, int posX, int posY, int ddamage, String col, int dan_dis, boolean anOK)
    {
        super(nname, llife, getRandomInt(), posX, posY, true, col);//movement speed of DangerousAnimal is generated randomly
        animalOK = anOK;//animal alive
        damage = ddamage;//damage animal causes
        dangerDistance = dan_dis;
        who_attacked = "";
    }

    //DangerousAnimals --- name | life | MOVEMENT_SPEED | posX | posY | sleeping | colour | damage | dangerousDistance | animalOK
    public AnimalsDanger(String nam, String lif, String mov_speed, String pX, String pY, String slp, String clr, String dm, String danDistance, String anOk)
    {
        super(nam, lif, mov_speed, pX, pY, slp, clr);
        //String dm, String dandistance, String anOk
        damage = Integer.parseInt(dm);
        dangerDistance = Integer.parseInt(danDistance);
        if(anOk.equals("true"))
        {
            animalOK = true;
        }
        else if(anOk.equals("false"))
        {
            animalOK = false;
        }
    }

    //returns a dangerous animal turned into a printable string
    public String toString()
    {
        String a = "Dangerous: " + super.toString() + " damage:"+ damage;
        return a;
    }
    
    //INTERACTION
    //instance method attack
    public String attack(Protagonist2 p)//this.attacks(sb)
    {
       int currentlife = p.getLife();
       p.setLife(currentlife - damage);//set new life score of protagonist
       String message = getName() + " attacked you!";
       return message;
    }

    //ACCESSOR METHODS
    //returns boolean animalOK
    public boolean getAnimalOK()
    {
        return animalOK;
    }
    //set animalOK (update it)
    public void setAnimalOK(boolean value)
    {
        animalOK = value;
    }
    //returns dangerDistance
    public int getDangerDistance()
    {
        return dangerDistance;
    }
    //returns who_attacked
    public String getWhoAttacked()
    {
        return who_attacked;
    }
    //returns damage
    public int getDamage()
    {
        return damage;
    }

    //MOVEMENT
    public void move(Protagonist2 p)
    {
        //dependent on protagonist

        while(Math.abs(p.getPositionX()-this.getPosX())>10)
        {
            moveLeft();
            //repaint();
        }
        who_attacked = attack(p);
        return;
    }

    //returns a random int
    public static int getRandomInt()//class method
    {
        double speed_num = Math.random()*100;
        int speed_to_use = (int) speed_num;//cast to int
        return speed_to_use;
    }
}