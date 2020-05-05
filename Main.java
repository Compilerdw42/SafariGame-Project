/*******************************
AUTHOR: DENIS GRIGORYEV
DATE: 14.04.2020
*******************************/
//Main class with main() method

public class Main
{
    public static void main(String[] param)
    {
        //menu 
        MenuModel mm = new MenuModel();//create model

        MenuView mv = new MenuView(mm);//create view

        MenuController mc = new MenuController(mm, mv);//create controller

        mv.addMyListener(mc);//assign controller
        
    }//end main


}