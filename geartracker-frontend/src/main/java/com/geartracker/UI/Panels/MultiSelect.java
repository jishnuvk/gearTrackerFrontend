package com.geartracker.UI.Panels;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.*;

public class MultiSelect extends JPanel{
    
    Confirmation confirmation;

    public MultiSelect(MainFrame mainframe, Confirmation confirmation, ArrayList<String> column, ArrayList<ArrayList<Object>> data){

        this.confirmation = confirmation;
        setBounds(12, 10, 1000, 710);
        
        CheckBoxTable t = new CheckBoxTable(data, column);
        // JTable t = new ButtonTable(data, column);

        JScrollPane p = new JScrollPane(t);
        p.setPreferredSize(new Dimension(800, 600));

        JPanel leftPanel = new JPanel();

        leftPanel.add(p);
        add(leftPanel, BorderLayout.EAST);
        
        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton b1 = new JButton("Done");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ArrayList<ArrayList<Object>> a = t.getCheckedData();
                confirmation.setData(a);
                mainframe.show("confirmation");
            }
        });
        buttonList.add(b1);

        JButton b2 = new JButton("Select All");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.checkAll();
                t.repaint();
            }
        });
        buttonList.add(b2);

        JButton b3 = new JButton("Deselect All");
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.uncheckAll();
                t.repaint();

            }
        });
        buttonList.add(b3);
        // buttonList.add(new JButton("3"));

        
        

        JPanel rightPanel = new ButtonColumn(150, 150, buttonList);
        rightPanel.setBackground(Color.BLACK);
        add(rightPanel, BorderLayout.WEST);
        

        setVisible(true);
    }

    public static void main( String[] args ){

        JFrame f = new JFrame();
        // MultiSelect s = new MultiSelect();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // f.add(s);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }

}

