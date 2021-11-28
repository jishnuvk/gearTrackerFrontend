package com.geartracker.UI.Panels;

import com.geartracker.Application.EquipmentHttpClient;
import com.geartracker.Application.RequestHttpClient;
import com.geartracker.Application.DTO.User;
import com.geartracker.UI.MainFrame;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;

import com.geartracker.UI.Utils.ButtonColumn;

public class SCDashBoard extends DashBoard{
    
    public SCDashBoard(User user){
        
        super(user);
        MainFrame mainFrame = MainFrame.getMainFrame();

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton addEquipment = new JButton("Add Equipment");
        addEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                addEquipmentRoute();
            }
        });
        buttonList.add(addEquipment);

        JButton removeEquipment = new JButton("Remove Equipment");
        removeEquipment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                removeEquipmentRoute();
            }
        });
        buttonList.add(removeEquipment);

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

        add(new ButtonColumn(400, 600, buttonList));
    }

    private void addEquipmentRoute(){

        mainFrame.addCard("addEquipment", new AddEquipment());
        mainFrame.show("addEquipment");
    }

    private void removeEquipmentRoute(){

        mainFrame.addCard("removeEquipment", new RemoveEquipment());
        mainFrame.show("removeEquipment");
    }

    private void selectEquipmentRoute(){

        mainFrame.addCard("RequestEquipment", new RequestEquipment(user));
        mainFrame.show("RequestEquipment");
    }
    
    private void heldEquipmentRoute(){

        ArrayList<String> column = new ArrayList<>();
        column.add("ID");
        column.add("name");
        column.add("reserved");
        column.add("status");
        column.add("description");

        ArrayList<ArrayList<Object>> data = EquipmentHttpClient.get_equipment(user.getId());

        mainFrame.addCard("DisplayOnly", new DisplayOnlyScreen( column, data));
        mainFrame.show("DisplayOnly");
    }

    private void viewRequestsRoute(){
        
        ArrayList<String> column = new ArrayList<>();
        column.add("requestId");
        column.add("equipmentId");
        column.add("status");
        column.add("issueDate");
        column.add("returnDate");


        ArrayList<ArrayList<Object>> data = RequestHttpClient.get_requests_student(user.getId());
        

        mainFrame.addCard("DisplayOnly", new DisplayOnlyScreen( column, data));
        mainFrame.show("DisplayOnly");
    }


}
