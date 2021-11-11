package com.geartracker.UI.Panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;


import com.geartracker.UI.Utils.*;

public class SelectEquipment extends JPanel{
    
    public SelectEquipment(){

        setBounds(12, 10, 1000, 710);
        
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

       

        
        CheckBoxTable t = new CheckBoxTable(data, column);
        // JTable t = new ButtonTable(data, column);

        JScrollPane p = new JScrollPane(t);
        p.setPreferredSize(new Dimension(800, 600));

        JPanel leftPanel = new JPanel();

        leftPanel.add(p);
        add(leftPanel, BorderLayout.EAST);
        
        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton b1 = new JButton("1");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayList<String> s = t.getCheckedIDs();
                s.forEach((str) -> System.out.println(str));
            }
        });
        buttonList.add(b1);
        buttonList.add(new JButton("2"));
        buttonList.add(new JButton("3"));
        

        JPanel rightPanel = new ButtonColumn(150, 150, buttonList);
        rightPanel.setBackground(Color.BLACK);
        add(rightPanel, BorderLayout.WEST);
        

        setVisible(true);
    }

    public static void main( String[] args ){

        JFrame f = new JFrame();
        SelectEquipment s = new SelectEquipment();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        f.add(s);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }

}
