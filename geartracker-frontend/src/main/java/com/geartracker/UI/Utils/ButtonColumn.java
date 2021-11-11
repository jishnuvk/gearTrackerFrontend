package com.geartracker.UI.Utils;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonColumn extends JPanel{
    
    public ButtonColumn(int height, int width, ArrayList<JButton> buttonList){

        int heightStep = height/buttonList.size();
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

        
        setLayout(layout);
        add(Box.createVerticalGlue());
        
        for(int i = 0; i < buttonList.size(); i++){

            JButton button = buttonList.get(i);
            // button.setP(width, heightStep);
            button.setPreferredSize(new Dimension(width, heightStep));
            button.setMaximumSize(new Dimension(width, heightStep));
            add(button);
        }



    }

}
