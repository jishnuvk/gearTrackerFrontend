package com.geartracker.UI.Panels;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.geartracker.UI.Utils.InputForm;

public class addEquipment extends JPanel{

    public addEquipment(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name"); types.add("string");
        labels.add("Reserved"); types.add("bool");

        InputForm form = new InputForm(labels, types, 400, 100);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton addStudent = new JButton("Add");
        buttonPanel.add(addStudent);

        JButton cancel = new JButton("Cancel");
        buttonPanel.add(cancel);

        add(buttonPanel);
    }

    public static void main(String[] args ){

        JFrame f = new JFrame();
        addEquipment a = new addEquipment();

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
