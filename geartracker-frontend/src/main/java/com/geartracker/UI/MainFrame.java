package com.geartracker.UI;

import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.geartracker.UI.Panels.*;

public class MainFrame extends JFrame {

    Container container;
    CardLayout layout;


    public MainFrame(){
        
        container = getContentPane();
        layout = new CardLayout();

        setLayout(layout);

        setSize(1024,768);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addCard(String cardId, JComponent card){
        container.add(cardId, card);
    }

    public void show(String cardId){

        layout.show(container, cardId);
    }

    public static void main( String[] args ){

        MainFrame mainframe = new MainFrame();
        mainframe.addCard("a", new DashBoard("a", mainframe, "b"));
        mainframe.addCard("b", new DashBoard("b", mainframe, "a"));
        mainframe.addCard("selectEquipment", new SelectEquipment());
        
        mainframe.show("a");

    }

}
