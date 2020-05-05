/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//MenuView class 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuView extends JFrame
{
    JFrame menu_frame;
    private JButton button_newgame;
    private JButton button_load;
    private JLabel menu_label;
    private JLabel bottom_label;
    private JLabel welcome_label;
    
    private MenuModel model;

    public MenuView(MenuModel mod)
    {
        this.model = mod;

        menu_frame = new JFrame();
        JPanel menu_panel = new JPanel();
        JPanel smaller_panel = new JPanel();

        button_newgame = new JButton("NEW GAME");
        button_load = new JButton("LOAD GAME");
        menu_label = new JLabel("-    -    -    Main Menu    -    -    -");
        bottom_label = new JLabel("-    -    -    -    -    -    -    -    -    -");

        welcome_label = new JLabel("Welcome to Safari Game!");

        //Set FRAME
        menu_frame.setBounds(1,1,600,500);//setBounds
        menu_frame.setTitle("Safari Game");
        menu_frame.setResizable(true);

        //Add components to panel
        menu_panel.add(Box.createRigidArea(new Dimension(0,80)));//for empty space between components
        menu_panel.add(welcome_label);
        menu_panel.add(Box.createRigidArea(new Dimension(0,20)));//for empty space between components

        smaller_panel.add(Box.createRigidArea(new Dimension(0,10)));
        smaller_panel.add(menu_label);
        smaller_panel.add(Box.createRigidArea(new Dimension(0,45)));//for empty space between components
        smaller_panel.add(button_newgame);
        smaller_panel.add(Box.createRigidArea(new Dimension(0,20)));//for empty space between components
        smaller_panel.add(button_load);
        smaller_panel.add(Box.createRigidArea(new Dimension(0,40)));//for empty space between components
        smaller_panel.add(bottom_label);
        
        menu_panel.add(Box.createRigidArea(new Dimension(0,30)));//for empty space between components
        menu_panel.add(smaller_panel);

        //set PANEL
        menu_panel.setLayout(new BoxLayout(menu_panel, BoxLayout.PAGE_AXIS));//so components are one under another
        smaller_panel.setLayout(new BoxLayout(smaller_panel, BoxLayout.PAGE_AXIS));

        menu_panel.setBackground(model.getColor());
        smaller_panel.setBackground(Color.white);

        //set alignment
        menu_label.setAlignmentX(CENTER_ALIGNMENT);
        welcome_label.setAlignmentX(CENTER_ALIGNMENT);
        button_newgame.setAlignmentX(CENTER_ALIGNMENT);
        button_load.setAlignmentX(CENTER_ALIGNMENT);
        bottom_label.setAlignmentX(CENTER_ALIGNMENT);

        //Add panels to frame
        menu_frame.add(menu_panel, BorderLayout.CENTER);

        menu_frame.setVisible(true);//set to false or true for switching between panels
        menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addMyListener(MenuController controller)
    {
        button_newgame.addActionListener(controller);
        
        button_load.addActionListener(controller);
    }
    //to hide the frame
    public void setFrameInvisible()
    {
        menu_frame.setVisible(false);
    }
}