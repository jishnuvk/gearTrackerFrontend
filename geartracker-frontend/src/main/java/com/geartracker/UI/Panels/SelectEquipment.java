package com.geartracker.UI.Panels;

import java.awt.*;
import javax.swing.*;


import com.geartracker.UI.Utils.*;

public class SelectEquipment extends JPanel{
    
    public SelectEquipment(){

        setBounds(12, 10, 1000, 710);
        
        Object data[][] = {{"101", "Amit", "670000", "adfasdfafqwerqer", "a", "b", false}};
        String column[] = {"ID", "Name", "Salary", "Address", "a", "b", "c"};

        JTable t = new JTable(new CheckBoxTableModel(data, column));
        JScrollPane p = new JScrollPane(t);
        p.setPreferredSize(new Dimension(800, 600));
        JPanel leftPanel = new JPanel(), rightPanel = new JPanel();

        leftPanel.add(p);
        add(leftPanel, BorderLayout.EAST);
        leftPanel.setBackground(Color.RED);
        
        JLabel dstLabel = new JLabel("Right");
        rightPanel.add(dstLabel);
        add(rightPanel, BorderLayout.WEST);
        JButton button = new JButton("hello");
        rightPanel.add(button);
        rightPanel.setBackground(Color.CYAN);
        
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
