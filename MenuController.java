/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//MenuController class
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class MenuController implements ActionListener
{
    private MenuModel model;
    private MenuView view;

    //constructor
    public MenuController(MenuModel mm, MenuView mv)
    {
        model = mm;
        view = mv;
    }
    //when sth happens
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("NEW GAME"))
        {
            Gameplay2 gamePlay2 = new Gameplay2();
            GUI myGui = new GUI(gamePlay2);

            view.setFrameInvisible();
        }
        else if(e.getActionCommand().equals("LOAD GAME")) 
        {   
            Gameplay2 gamePlay = new Gameplay2(SaveLoad.load());

            GUI myGui = new GUI(gamePlay);

            view.setFrameInvisible();//to hide menu frame
        }
    }
}
