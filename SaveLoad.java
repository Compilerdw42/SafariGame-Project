/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//SaveLoad class

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SaveLoad
{
    //save method
    public static void save(PrintWriter outputStream, Gameplay2 gpl2)
    {
        //accumulator vaiable
        String text;

        //Create and format DATE and TIME
        Date date_time = new Date();//create date-time
        DateFormat normal_format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");//create format

        //TIME
        text = normal_format.format(date_time);

        //PROTAGONIST --- String nname, int llife, int sscore, int posX, String co, int mov_speed
        text = saveProtagonist(text, gpl2);

        //DANGEROUS_ANIMALS --- name | life | MOVEMENT_SPEED | posX | posY | sleeping | colour | damage | dangerousDistance | animalOK - all Strings
        text = saveAnimalsDanger(text, gpl2);

        //BASIC_ANIMALS --- String nname, int speed, int posX, int posY, String dirX, String dirY, String col
        text = saveAnimalsBasic(text, gpl2);

        //OBJECTS --- Drugs: String nn, String picked_up, int ppoints      OR      ZoomLens: String nnn, String picked
        text = saveObjects(text, gpl2);

        outputStream.write(text);//write to a file
        outputStream.close();
    }

    //save protagonist
    public static String saveProtagonist(String text, Gameplay2 gpl2)
    {
        //PROTAGONIST --- String nname, int llife, int sscore, int posX, String co, int mov_speed
        text = text + "\n" + gpl2.getProtagonist().getName() + "\n" + gpl2.getProtagonist().getLife() + "\n" + gpl2.getProtagonist().getScore() + "\n" + gpl2.getProtagonist().getPositionX() + "\n" + gpl2.getProtagonist().getCurrentObject() + "\n" + gpl2.getProtagonist().getMOVEMENT_SPEED() + "\n";
        return text;
    }
    //save dangerous animals
    public static String saveAnimalsDanger(String text, Gameplay2 gpl2)
    {
        //DANGEROUS_ANIMALS --- name | life | MOVEMENT_SPEED | posX | posY | sleeping | colour | damage | dangerousDistance | animalOK - all Strings
        text = text + gpl2.getAnimalsDanger().getName() + "\n" + gpl2.getAnimalsDanger().getLife() + "\n" + gpl2.getAnimalsDanger().getMOVEMENT_SPEED() + "\n" + gpl2.getAnimalsDanger().getPosX() + "\n" + gpl2.getAnimalsDanger().getPosY() + "\n" + gpl2.getAnimalsDanger().getSleeping() + "\n" + gpl2.getAnimalsDanger().getColour() + "\n" + gpl2.getAnimalsDanger().getDamage() + "\n" + gpl2.getAnimalsDanger().getDangerDistance() + "\n" + gpl2.getAnimalsDanger().getAnimalOK() + "\n";
        return text;
    }
    //save basic animals
    public static String saveAnimalsBasic(String text, Gameplay2 gpl2)
    {
        //BASIC_ANIMALS --- String nname, int speed, int posX, int posY, String dirX, String dirY, String col
        AnimalsBasic[] animalsArray = gpl2.getAnimalsBasicArray();
        for(int d = 0; d<3; d++)
        {
            text = text + animalsArray[d].getName() + "\n" + animalsArray[d].getMOVEMENT_SPEED() + "\n" + animalsArray[d].getPosX() + "\n" + animalsArray[d].getPosY() + "\n" + animalsArray[d].getDirectionX() + "\n" + animalsArray[d].getDirectionY() + "\n" + animalsArray[d].getColour() + "\n";
        }
        return text;
    }
    //save objects
    public static String saveObjects(String text, Gameplay2 gpl2)
    {
        //OBJECTS --- Drugs: String nn, String picked_up, int ppoints      OR      ZoomLens: String nnn, String picked
        try
        {
            Drugs current_drug = gpl2.getDrug();
            text = text + current_drug.getName() + "\n" + current_drug.getPickedUp() + "\n" + current_drug.getPoints();
            return text;
        }
        catch(ClassCastException e)//Exception e
        {
            ZoomLens current_lens = gpl2.getZoomLens();
            text = text + current_lens.getName() + "\n" + current_lens.getPickedUp();
            return text;
        }
    }

    //load method
    public static ArrayList<String> load()
    {
        try
        {
            //to read from the file
            BufferedReader inputStream = new BufferedReader(new FileReader("gameStateHere.txt"));

            ArrayList<String> contents = new ArrayList<>(); //accumulator variable
            String current_line = "x";
            int i = 0; //counter variable
    
            while(current_line!=null)
            {
                current_line = inputStream.readLine();
                if(current_line==null)
                {
                    break;
                }
                contents.add(i, current_line);
                i++;
            }
            inputStream.close();
            return contents;
        }
        catch(IOException exs)
        {
            System.out.println("IOException was thrown in SaveLoad class, load method");
        }
		return null;
    }
}