package com.geartracker.UI.Panels;

import com.geartracker.UI.MainFrame;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ButtonColumn;

public class SCDashBoard extends DashBoard{
    
    public SCDashBoard(MainFrame mainFrame){
        
        super(mainFrame);

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton addEquipment = new JButton("Add Equipment");
        addEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addEquipmentRoute();
            }
        });
        buttonList.add(addEquipment);

        JButton removeEquipment = new JButton("Remove Equipment");
        addEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                removeEquipmentRoute();
            }
        });
        buttonList.add(removeEquipment);

        add(new ButtonColumn(150, 400, buttonList));
    }

    private void addEquipmentRoute(){

    }

    private void removeEquipmentRoute(){

    }


}
