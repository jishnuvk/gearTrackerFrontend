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

        container.setLayout(layout);

        setSize(1024,768);
        setLayout(null);
        setVisible(true);
    }

    public void addCard(String cardId, JComponent card){
        container.add(cardId, card);
    }

    public static void main( String[] args ){

        MainFrame mainframe = new MainFrame();
        mainframe.addCard("tableTest", new SelectEquipment());

    }

}
