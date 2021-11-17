package com.geartracker.UI.Panels;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ButtonColumn;

public class StudentDashBoard extends DashBoard{

    public StudentDashBoard(MainFrame mainFrame){
        super(mainFrame);

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton selectEquipment = new JButton("Request Equipment");
        selectEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectEquipmentRoute();
            }
        });
        buttonList.add(selectEquipment);

        JButton heldEquipment = new JButton("View Held Equipment");
        heldEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                heldEquipmentRoute();
            }
        });
        buttonList.add(heldEquipment);

        JButton viewRequests = new JButton("View Requests");
        viewRequests.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                viewRequestsRoute();
            }
        });
        buttonList.add(viewRequests);
        
        add(new ButtonColumn(150, 400, buttonList));

    }

    private void selectEquipmentRoute(){

        ArrayList<String> column = new ArrayList<>();
        column.add("ID");
        column.add("name");

        Confirmation confirmation = new Confirmation(mainFrame, column);

        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("jishnu");
        data.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("2");
        row2.add("john");
        data.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("3");
        row3.add("jim");
        data.add(row3);
        mainFrame.addCard("multiSelect", new MultiSelect(mainFrame, confirmation, column, data));
        mainFrame.show("multiSelect");

        mainFrame.addCard("confirmation", confirmation);
    }
    
    private void heldEquipmentRoute(){

        ArrayList<String> column = new ArrayList<>();
        column.add("ID");
        column.add("name");


        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("jishnu");
        data.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("2");
        row2.add("john");
        data.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("3");
        row3.add("jim");
        data.add(row3);

        mainFrame.addCard("DisplayOnly", new DisplayOnlyScreen( mainFrame, column, data));
        mainFrame.show("DisplayOnly");
    }

    private void viewRequestsRoute(){
        ArrayList<String> column = new ArrayList<>();
        column.add("ID");
        column.add("name");


        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("jishnu");
        data.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("2");
        row2.add("john");
        data.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("3");
        row3.add("jim");
        data.add(row3);

        mainFrame.addCard("DisplayOnly", new DisplayOnlyScreen( mainFrame, column, data));
        mainFrame.show("DisplayOnly");
    }
}
