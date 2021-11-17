package com.geartracker.UI.Panels;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.geartracker.UI.Utils.InputForm;

public class addStudent extends JPanel{

    public addStudent(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name"); types.add("string");
        labels.add("Password"); types.add("string");
        labels.add("email"); types.add("string");
        labels.add("year"); types.add("string");
        labels.add("Sports Team"); types.add("bool");

        InputForm form = new InputForm(labels, types, 400, 200);

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
        addStudent a = new addStudent();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}