package com.geartracker.UI.Panels;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;

public class DashBoard extends JPanel{

    public DashBoard(String s, MainFrame mainFrame, String next){

        setBounds(12, 10, 1000, 710);
        JButton b = new JButton(s);
        add(b);
        b.addActionListener( new ActionListener(){

            public void actionPerformed(ActionEvent e){
                mainFrame.show(next);
            }
        } );
    }

}
