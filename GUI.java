/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;
//GUI class for the game

public class GUI extends JFrame implements ActionListener, KeyListener//GUI
{
    private JTextField tf1;
    private JTextArea ta;
    private JTextArea ta2;
    private Gameplay2 gamePlay;
    private boolean buttonClicked;
    private int kill_message_displayed;

    //constructor
    public GUI(Gameplay2 gpl)
    {
        gamePlay = gpl;

        //FRAME and PANELS
        JFrame f = new JFrame();//create a fram
        JPanel bottomPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        //Create CONTENT
        tf1 = new JTextField(30);
        ta = new JTextArea("MESSAGES SHOWN HERE");
        ta2 = new JTextArea(15,10);
        JButton bt = new JButton("Save and quit");
        JLabel right_label = new JLabel("Objects");

        //Set FRAME
        f.setBounds(1,1,973,600);//setBounds
        f.setTitle("Safari Game");
        f.setResizable(true);

        //Set CONTENT
        tf1.setText("CHARACTER DETAILS HERE");
        tf1.setEditable(false);
        tf1.setBackground(Color.LIGHT_GRAY);

        //tf2.setText("Hello on the RIGHT");
        //tf2.setEditable(false);

        ta.setEditable(false);
        ta.setBackground(Color.yellow);

        ta2.setEditable(false);
        ta2.setBackground(Color.LIGHT_GRAY);
        ta2.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        bt.addActionListener(this);
        gamePlay.addKeyListener(this);

        //Add components to panel
        bottomPanel.add(tf1);
        bottomPanel.add(ta);
        //rightPanel.add(tf2);
        rightPanel.add(Box.createRigidArea(new Dimension(0,50)));//for empty space between components
        rightPanel.add(bt);
        rightPanel.add(Box.createRigidArea(new Dimension(0,60)));//for empty space between components
        rightPanel.add(right_label);
        rightPanel.add(Box.createRigidArea(new Dimension(0,10)));//for empty space between components
        rightPanel.add(ta2);
        rightPanel.add(Box.createRigidArea(new Dimension(0,50)));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        //rightPanel.setBackground(Color.DARK_GRAY);

        bt.setAlignmentX(CENTER_ALIGNMENT);
        right_label.setAlignmentX(CENTER_ALIGNMENT);
        ta2.setAlignmentX(CENTER_ALIGNMENT);

        bottomPanel.setLayout(new GridLayout(1,2));

        f.add(bottomPanel, BorderLayout.SOUTH);
        f.add(gamePlay, BorderLayout.CENTER);
        f.add(rightPanel, BorderLayout.EAST);

        //f.setLayout(new GridLayout(1,1));
        buttonClicked = false;
        kill_message_displayed = 0;

        f.setVisible(true);//set to false or true for switching between panels
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
    }
    //when sth happens
    public void actionPerformed(ActionEvent ev)
    {
        //SAVE BUTTON
        if(ev.getActionCommand().equals("Save and quit") & !buttonClicked)//save button
        {
            tf1.setText(gamePlay.getProtagonist().toString());
            buttonClicked = true;
            try
            {
                PrintWriter outputStream = new PrintWriter(new FileWriter("gameStateHere.txt"));
                SaveLoad.save(outputStream, gamePlay);
            }
            catch(IOException e)
            {
                System.out.println("Problem when saving the game");
            }   
            System.exit(0);
        }
    }
    //when key is pressed
    public void keyPressed(KeyEvent e)
    {
        //GAME OVER!
        if(gamePlay.getProtagonist().getLife()<=0)
        {
            ta.setText("GAME OVER!");
            gamePlay.getProtagonist().setPositionX(310);
            gamePlay.getProtagonist().setLife(0);
            tf1.setText(gamePlay.getProtagonist().toString());
        }
        else
        {
            tf1.setText(gamePlay.getProtagonist().toString());
            ta.setText(gamePlay.getAnimalsDanger().getWhoAttacked());

            if(!(gamePlay.getProtagonist().getKilledMessage().equals("")) & kill_message_displayed<3)
            {
                ta.setText(gamePlay.getProtagonist().getKilledMessage());
                kill_message_displayed++;//set to true
            }
            ta2.setText("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n\n" + gamePlay.getProtagonist().getCurrentObject());
        }
    }
    public void keyTyped(KeyEvent e)
    {}
    public void keyReleased(KeyEvent e)
    {}

}//end GUI