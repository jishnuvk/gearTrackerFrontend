package com.geartracker.UI.Panels;

import com.geartracker.Application.DTO.User;

import java.util.ArrayList;

import javax.swing.JButton;

import com.geartracker.UI.Utils.ButtonColumn;

public class AdminDashBoard extends DashBoard{
    
    public AdminDashBoard(User user){
        
        super(user);
        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton addEquipment = new JButton("Add Equipment");
        addEquipment.addActionListener((e)->addEquipmentRoute());
        buttonList.add(addEquipment);

        JButton removeEquipment = new JButton("Remove Equipment");
        removeEquipment.addActionListener((e)->removeEquipmentRoute());
        buttonList.add(removeEquipment);

        JButton addStudent = new JButton("Add Student");
        addStudent.addActionListener((e)->addStudentRoute());
        buttonList.add(addStudent);

        JButton editStudent = new JButton("Edit Student");
        editStudent.addActionListener((e)->editStudentRoute());
        buttonList.add(editStudent);

        JButton addHighLevelUser = new JButton("Add High Level User");
        addHighLevelUser.addActionListener((e)->addHighLevelUserRoute());
        buttonList.add(addHighLevelUser);

        add(new ButtonColumn(400, 400, buttonList));
    }

    private void addEquipmentRoute(){

        mainFrame.addCard("addEquipment", new AddEquipment());
        mainFrame.show("addEquipment");

    }

    private void removeEquipmentRoute(){

        mainFrame.addCard("removeEquipment", new RemoveEquipment());
        mainFrame.show("removeEquipment");

    }

    private void addStudentRoute(){

        mainFrame.addCard("addStudent", new AddStudent());
        mainFrame.show("addStudent");

    }

    private void editStudentRoute(){

        EditStudent e = new EditStudent();
        mainFrame.addCard("editStudent", e);
        mainFrame.show("editStudent");
        e.run();


    }

    private void addHighLevelUserRoute(){

        mainFrame.addCard("addHighLevelUser", new AddHighLevelUser());
        mainFrame.show("addHighLevelUser");

    }


}
