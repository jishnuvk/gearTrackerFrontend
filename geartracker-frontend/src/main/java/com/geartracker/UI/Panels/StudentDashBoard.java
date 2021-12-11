package com.geartracker.UI.Panels;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.geartracker.Application.EquipmentHttpClient;
import com.geartracker.Application.RequestHttpClient;
import com.geartracker.Application.DTO.User;
import com.geartracker.UI.Utils.ButtonColumn;
import com.geartracker.UI.Utils.DisplayUser;

public class StudentDashBoard extends DashBoard{

    public StudentDashBoard(User user){

        super(user);
        
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
        
        add(new ButtonColumn(400, 625, buttonList), BorderLayout.EAST);
        

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

    public static void main(String[] args) {
        
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        User u = new User("IMT2018033", "Jishnu", "a", "jishnu@iiitb.org");
        ArrayList<String> r = new ArrayList<String>();
        r.add("Student");
        u.setRoles(r);
        u.addFine(100);
        StudentDashBoard v = new StudentDashBoard(u);
        f.add(v);

        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }
}
