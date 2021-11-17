package com.geartracker.UI.Panels;


import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;


public abstract class DashBoard extends JPanel{

    MainFrame mainFrame;

    public DashBoard( MainFrame mainFrame){

        this.mainFrame = mainFrame; 
        setBounds(12, 10, 1000, 710);
        setVisible(true);
    }

}
