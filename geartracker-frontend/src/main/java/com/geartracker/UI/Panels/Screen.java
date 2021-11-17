package com.geartracker.UI.Panels;

import javax.swing.JPanel;



public abstract class Screen extends JPanel{

    protected Screen(){

        setBounds(12, 10, 1000, 710);

    }


    public abstract void prepareForDisplay();

} 
