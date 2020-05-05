/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
import javax.lang.model.util.ElementScanner6;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;

public class Gameplay2 extends JPanel implements KeyListener, ActionListener
{
    //this is a model with a controller
    //controller would have private Model that is below;
    //and private GUI

    //properties
    private Timer timer;//timer for the ball moving
    private int delay = 7;
    private String message;
    private int animal_number;
    private int num;
    private int random_number;//how many objects
    //characters
    private Protagonist2 photogr;//photographer
    private Animals dangerousAnimal1;//dangerous animal that can attack
    private Animals dangerousAnimal2;//dangerous animal that can attack
    private Animals dangerousAnimal3;//dangerous animal that can attack
    private Animals anim1;//basic animal
    private Animals anim2;//basic animal
    private Animals anim3;//basic animal
    //objects
    private Objects2 o1;
    //ArrayLists
    ArrayList<Animals> dangerousAnimals;
    ArrayList<Animals> basicAnimals;
    ArrayList<Characters> chars;
    ArrayList<Objects2> objects;

    //constructor
    public Gameplay2()
    {System.out.println("KEY_RIGHT and KEY_LEFT to move the protagonist" + "\n" + "KEY_SPACE to take a picture of the animal" + "\n" + "Get as close as you can to the dangerous animal on the right to make perfect a photo!");
        //Scene setup
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //ArrayLists of characters here
        chars = new ArrayList<Characters>();
        dangerousAnimals = new ArrayList<>();
        basicAnimals = new ArrayList<>();

        //create characters here
        //Protagonist --- name | life | score | positionX | current_object | speed
        photogr = new Protagonist2("Photographer", 100, 0, 310, "You have no objects here - go get some!", 20);

        //DangerousAnimals --- name | life | MOVEMENT_SPEED | posX | posY | sleeping | colour | damage | dangerousDistance | animalOK
        dangerousAnimal1 = new AnimalsDanger("Wombat", 30, 1, 600, 450, 15, "BLUE", 100, true);     //substitution principle
        dangerousAnimal2 = new AnimalsDanger("Kangaroo", 100, 1, 600, 450, 80, "ORANGE", 180, true);//substitution principle
        dangerousAnimal3 = new AnimalsDanger("Kiwi", 10, 1, 600, 450, 100, "CYAN", 250, true);      //substitution principle
        
        //BasicAnimals --- name | MOVEMENT_SPEED | posX | posY | directionX | directionY | colour
        anim1 = new AnimalsBasic("Pigeon1", 1, 550, 250, "R", "U", "DEFAULT"); //substitution principle
        anim2 = new AnimalsBasic("Pigeon2", 1, 200, 150, "L", "U", "DEFAULT"); //substitution principle
        anim3 = new AnimalsBasic("Pigeon3", 1, 500, 580, "R", "U","DEFAULT");  //substitution principle

        //add characters to ArrayLists
        chars.add(photogr);
        chars.add(dangerousAnimal1);
        chars.add(dangerousAnimal2);
        chars.add(dangerousAnimal3);
        chars.add(anim1);
        chars.add(anim2);
        chars.add(anim3);
        dangerousAnimals.add(dangerousAnimal1);
        dangerousAnimals.add(dangerousAnimal2);
        dangerousAnimals.add(dangerousAnimal3);
        basicAnimals.add(anim1);
        basicAnimals.add(anim2);
        basicAnimals.add(anim3);
        
        animal_number = 0;//current animal number
        num = 0;//number of how many have been photographed

        //randomly create objects
        //OBJECTS --- Drugs: String nn, String picked_up, int ppoints      OR      ZoomLens: String nnn, String picked
        objects = new ArrayList<Objects2>();

        Random random = new Random();
        random_number = random.nextInt(5);//returns from 0 to 4
        int random_n;
        String[] myarray1 = new String[]{"ABC", "ZZZ", "MIT"};
        String[] myarray2 = new String[]{"Gold", "Silver", "Bronze"};
        for(int j = 0; j<random_number+1; j++)//random number of objects form 1 to 5
        {
            if(Math.random()>0.5)
            {
                //substitution principle and dynamic binding because math.random at run time
                random_n = random.nextInt(3);//from 0 to 2
                o1 = new Drugs(myarray1[random_n]);
                objects.add(o1);
            }  
            else
            {
                random_n = random.nextInt(3);//from 0 to 2
                o1 = new ZoomLens(myarray2[random_n]);//so distance is 50
                objects.add(o1);
            }
        }
        ////////////////////////Polymorphism ARRAY LIST OF CHARACHTERS and OBJECTS HERE
        System.out.println("In the room we have:");
        for(int i=0; i<chars.size(); i++)
        {
            System.out.println(chars.get(i).toString());
        }
        for(int i=0; i<objects.size(); i++)
        {
            System.out.println(objects.get(i).toString());
        } 

        timer = new Timer(delay, this);//for basic animal flying
        timer.start();
    }

    public Gameplay2(ArrayList<String> arrayList)//constructor for loading
    {System.out.println("KEY_RIGHT and KEY_LEFT to move the protagonist" + "\n" + "KEY_SPACE to take a picture of the animal" + "\n" + "Get as close as you can to the dangerous animal on the right to make perfect a photo!");
        //Scene setup
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //ArrayLists of characters here
        chars = new ArrayList<Characters>();
        dangerousAnimals = new ArrayList<>();
        basicAnimals = new ArrayList<>();

        //create characters here
        int i = 1;//0 is time

        //PROTAGONIST --- String nname, int llife, int sscore, int posX, String co, int mov_speed
        photogr = new Protagonist2(arrayList.get(i), Integer.parseInt(arrayList.get(i+1)), Integer.parseInt(arrayList.get(i+2)), Integer.parseInt(arrayList.get(i+3)), arrayList.get(i+4), Integer.parseInt(arrayList.get(i+5)));
        
        //DANGEROUS_ANIMALS --- name | life | MOVEMENT_SPEED | posX | posY | sleeping | colour | damage | dangerousDistance | animalOK - all Strings
        dangerousAnimal1 = new AnimalsDanger(arrayList.get(i+6), arrayList.get(i+7), arrayList.get(i+8), arrayList.get(i+9), arrayList.get(i+10), arrayList.get(i+11), arrayList.get(i+12), arrayList.get(i+13), arrayList.get(i+14), arrayList.get(i+15));
        dangerousAnimal2 = new AnimalsDanger("Kangaroo", 80, 1, 600, 450, 80, "ORANGE", 250, true);
        dangerousAnimal3 = new AnimalsDanger("Kiwi", 10, 1, 600, 450, 100, "CYAN", 450, true);
        
        //BASIC_ANIMALS --- String nname, int speed, int posX, int posY, String dirX, String dirY, String col
        anim1 = new AnimalsBasic(arrayList.get(i+16), Integer.parseInt(arrayList.get(i+17)), Integer.parseInt(arrayList.get(i+18)), Integer.parseInt(arrayList.get(i+19)), arrayList.get(i+20), arrayList.get(i+21), arrayList.get(i+22));
        anim2 = new AnimalsBasic(arrayList.get(i+23), Integer.parseInt(arrayList.get(i+24)), Integer.parseInt(arrayList.get(i+25)), Integer.parseInt(arrayList.get(i+26)), arrayList.get(i+27), arrayList.get(i+28), arrayList.get(i+29));
        anim3 = new AnimalsBasic(arrayList.get(i+30), Integer.parseInt(arrayList.get(i+31)), Integer.parseInt(arrayList.get(i+32)), Integer.parseInt(arrayList.get(i+33)), arrayList.get(i+34), arrayList.get(i+35), arrayList.get(i+36));

        //add characters to ArrayLists
        chars.add(photogr);
        chars.add(dangerousAnimal1);
        chars.add(dangerousAnimal2);
        chars.add(dangerousAnimal3);
        chars.add(anim1);
        chars.add(anim2);
        chars.add(anim3);
        dangerousAnimals.add(dangerousAnimal1);
        dangerousAnimals.add(dangerousAnimal2);
        dangerousAnimals.add(dangerousAnimal3);
        basicAnimals.add(anim1);
        basicAnimals.add(anim2);
        basicAnimals.add(anim3);

        animal_number = 0;//number of current animal
        num = 0;//number of how many have been photographed

        //randomly create objects
        //OBJECTS --- Drugs: String nn, String picked_up, int ppoints      OR      ZoomLens: String nnn, String picked
        objects = new ArrayList<Objects2>();

        if(arrayList.get(i+37).equals("Gold") | arrayList.get(i+37).equals("Silver") | arrayList.get(i+37).equals("Bronze"))
        {
            o1 = new ZoomLens(arrayList.get(i+37), arrayList.get(i+38));//by this name and coolDistance is set
            objects.add(o1);
        }
        else 
        {
            o1 = new Drugs(arrayList.get(i+37), arrayList.get(i+38), Integer.parseInt(arrayList.get(i+39)));
            objects.add(o1);
        }
        ////////////////////////Polymorphism ARRAY LIST OF CHARACHTERS and OBJECTS HERE
        System.out.println("In the room we have:");
        for(int l=0; l<chars.size(); l++)
        {
            System.out.println(chars.get(l).toString());
        }
        for(int m=0; m<objects.size(); m++)
        {
            System.out.println(objects.get(m).toString());
        }
        timer = new Timer(delay, this);//for basic animal flying
        timer.start();
    }

    //CONTROLLER
    //when an action is performed
    public void actionPerformed(ActionEvent e)
    {
        repaint();

        for(int n=0; n<basicAnimals.size(); n++)//move the animals (birds)
        {
            basicAnimals.get(n).move(photogr);//polymorphism because basicAnimals have supertype Animals; and real type AnimalsBasic; move() is overriden in the subclass
        }
    }
    //when the key is pressed
    public void keyPressed(KeyEvent e)
    {
        //RIGHT
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(checkTooClose(photogr, dangerousAnimals.get(animal_number)))
            {
                if(dangerousAnimals.get(animal_number).getAnimalOK()==true)//if animal is still ok
                {
                    // then move and attack photogr!
                    dangerousAnimals.get(animal_number).move(photogr);//polymorphism because basicAnimals have supertype Animals; and real type AnimalsDanger; move() is overriden
                }
            }

            if(photogr.getPositionX()>=600)//check if player is already on the very right
            {
                photogr.setPositionX(600);
                //playerX = 600; set new position X
            }
            else
            {
                photogr.moveRight();
            }
        }
        //LEFT
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(checkTooClose(photogr, dangerousAnimals.get(animal_number)))
            {
                if(dangerousAnimals.get(animal_number).getAnimalOK()==true)//if animal is still ok
                {
                    dangerousAnimals.get(animal_number).move(photogr);// then move and attack photogr!
                }
            }

            if(photogr.getPositionX()<10)
            {
                photogr.setPositionX(10);

                photogr.takeObject(o1);//take objects.get(i)

                //when protagonist is on the very left it can pick up a drug or a ZoomLens
                //playerX = 10;
            }
            else
            {
                photogr.moveLeft();
            }
        }
        //SPACE
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            if(dangerousAnimals.get(animal_number).getAnimalOK()==true)//get animalOK
            {
                int dist = Math.abs(photogr.getPositionX()-dangerousAnimals.get(animal_number).getPosX());

                if(dist<photogr.getDistance() & photogr.getLife()>0)
                {
                    dangerousAnimals.get(animal_number).setAnimalOK(false);//set animalOK to false
                    
                    photogr.kill(dangerousAnimals.get(animal_number));//real action
                    
                    num++;
                    if(num<3)//to count how many photographed
                    {
                        animal_number++;//to get another animal
                    }
                    else
                    {
                        displayYouWonWindow(photogr);
                    }
                }
            }
        }
    }
    public void keyTyped(KeyEvent e)
    {
    }
    public void keyReleased(KeyEvent e)
    {
    }

    //ACCESSOR METHODS
    //returns protagonist
    public Protagonist2 getProtagonist()
    {
        return photogr;
    }
    //returns DangerousAnimal
    public AnimalsDanger getAnimalsDanger()
    {
        AnimalsDanger dangerous = (AnimalsDanger) dangerousAnimals.get(animal_number);
        return dangerous;
    }
    //returns ArrayList of BasicAnimals
    public AnimalsBasic[] getAnimalsBasicArray()
    {
        AnimalsBasic [] array = new AnimalsBasic[]{getAnimalsBasic1(), getAnimalsBasic2(), getAnimalsBasic3()};
        return array;
    }
    //returns basic animal
    public AnimalsBasic getAnimalsBasic1()
    {
        AnimalsBasic ab = (AnimalsBasic)anim1;
        return ab;
    }
    //returns basic animal
    public AnimalsBasic getAnimalsBasic2()
    {
        AnimalsBasic ab = (AnimalsBasic)anim2;
        return ab;
    }
    //returns basic animal
    public AnimalsBasic getAnimalsBasic3()
    {
        AnimalsBasic ab = (AnimalsBasic)anim3;
        return ab;
    }
    //returns object of type Drug
    public Drugs getDrug()
    {
        Drugs drug = (Drugs) o1;
        return drug;
    }
    //returns object of type ZoomLens
    public ZoomLens getZoomLens()
    {
        ZoomLens lens = (ZoomLens) o1;
        return lens;
    }
    //returns the message
    public String getMessage()
    {
        return message;
    }

    //GUI part-----------------------
    //to paint characters and objects
    public void paint(Graphics g)//to paint shapes overriden
    {
        //Backgrounnd
        paintBackground(g);
        //Protagonist
        paintProtagonist(g);
        //Dangerous animal
        paintDangerousAnimal(g);
        //Basic animal
        paintBasicAnimal(g);
        //Objects
        paintObject(g);

        g.dispose();
    }
    public void paintBackground(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(1,1, 692, 592);
    }
    public void paintProtagonist(Graphics g)
    {
        g.setColor(Color.green);
        g.fillRect(photogr.getPositionX(), 450, 40, 40);
    }
    public void paintDangerousAnimal(Graphics g)
    {
        if(dangerousAnimals.get(animal_number).getAnimalOK()==false)//get animalOK
        {
            g.setColor(Color.red);//set to white if they are close enough
        }
        else
        {
            if(dangerousAnimals.get(animal_number).getColour().equals("BLUE"))
            {
                g.setColor(Color.blue);
            }
            else if(dangerousAnimals.get(animal_number).getColour().equals("CYAN"))
            {
                g.setColor(Color.CYAN);
            }
            else
            {
                g.setColor(Color.ORANGE);
            }
        }        
        g.fillRect(dangerousAnimals.get(animal_number).getPosX(), dangerousAnimals.get(animal_number).getPosY(), 60, 30);
    }

    public void paintBasicAnimal(Graphics g)
    {
        g.setColor(Color.ORANGE);
        g.fillOval(anim1.getPosX(), anim1.getPosY(), 45, 35);

        g.setColor(Color.lightGray);
        g.fillOval(anim2.getPosX(), anim2.getPosY(), 70, 45);
        //g.fillOval(anim2.getPosX(), anim2.getPosY(), 12, 12);
        //g.setColor(Color.black);
        //g.fillOval(anim2.getPosX()+2, anim2.getPosY()+2, 5, 5);

        g.setColor(Color.cyan);
        g.fillOval(anim3.getPosX(), anim3.getPosY(), 80, 65);
    }
    public void paintObject(Graphics g)
    {
        if(o1.getPickedUp())
        {
            g.setColor(Color.white);
        }
        else
        {
            g.setColor(Color.PINK);
        }
        g.fillOval(5, 450, 30, 30);
    }

    //check if characters are too close
    //substitution principle because method accepts second argument of supertype Animals
    //[sent value can be of AnimalsDanger or AnimalsBasic]
    public static boolean checkTooClose(Protagonist2 p, Animals ad)
    {
        int dis = Math.abs(p.getPositionX() - ad.getPosX());
        if(dis < ad.getDangerDistance())
        {
            return true;//then start moving and attack the protagonist
        }
        else
            return false;
    }
    //to show "You Won!" window
    public static void displayYouWonWindow(Protagonist2 photogr)
    {
        System.out.println("You won! with " + photogr.getScore() + " points");
        JFrame ff = new JFrame();
        JPanel my_panel = new JPanel();
        //Set FRAME
        ff.setBounds(50,100,500,400);//setBounds
        ff.setTitle("Safari Game");
        ff.setResizable(true);
        JLabel victory_label = new JLabel("YOU WON!");
        JLabel second_vic_label = new JLabel("with score " + photogr.getScore() + " points");
        my_panel.add(Box.createRigidArea(new Dimension(0,325)));//for empty space between components
        my_panel.add(victory_label);
        my_panel.add(Box.createRigidArea(new Dimension(0,20)));//for empty space between components
        my_panel.add(second_vic_label);
        victory_label.setAlignmentX(CENTER_ALIGNMENT);
        second_vic_label.setAlignmentX(CENTER_ALIGNMENT);

        ff.add(my_panel, BorderLayout.CENTER);

        ff.setVisible(true);//set to false or true for switching between panels
        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}