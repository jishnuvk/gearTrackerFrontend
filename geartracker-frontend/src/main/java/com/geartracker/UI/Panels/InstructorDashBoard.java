package com.geartracker.UI.Panels;

import com.geartracker.Application.DTO.User;


import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;

import com.geartracker.UI.Utils.ButtonColumn;

public class InstructorDashBoard extends DashBoard{
    
    public InstructorDashBoard(User user){
        
        super(user);
       

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

        JButton approveRequest = new JButton("Approve Requests");
        approveRequest.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                approveRequestRoute();
            }
        });
        buttonList.add(approveRequest);

        JButton closeRequest = new JButton("Close Requests");
        closeRequest.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                closeRequestRoute();
            }
        });
        buttonList.add(closeRequest);

        JButton viewReport = new JButton("View Report");
        viewReport.addActionListener((e)->viewReportRoute());
        buttonList.add(viewReport);


        add(new ButtonColumn(400, 625, buttonList));
    }

    private void addEquipmentRoute(){

        mainFrame.addCard("addEquipment", new AddEquipment());
        mainFrame.show("addEquipment");

    }

    private void removeEquipmentRoute(){

        mainFrame.addCard("removeEquipment", new RemoveEquipment());
        mainFrame.show("removeEquipment");

    }

    private void approveRequestRoute(){

        ApproveRequest approveRequest = new ApproveRequest();
        mainFrame.addCard("approveRequest", approveRequest);
        mainFrame.show("approveRequest");
        approveRequest.run();

    }

    private void closeRequestRoute(){

        CloseRequest closeRequest = new CloseRequest();
        mainFrame.addCard("closeRequest", closeRequest );
        mainFrame.show("closeRequest");
        closeRequest.run();

    }

    private void viewReportRoute(){

        mainFrame.addCard("ViewReport", new ViewReport());
        mainFrame.show("ViewReport");

    }


}
