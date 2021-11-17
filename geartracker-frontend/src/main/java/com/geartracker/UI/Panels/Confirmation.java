package com.geartracker.UI.Panels;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ButtonColumn;
import com.geartracker.UI.Utils.RegularTable;

public class Confirmation extends JPanel{
    
    ArrayList<ArrayList<Object>> data = new ArrayList<>();
    ArrayList<String> column;
    RegularTable regularTable;
    
    public Confirmation(ArrayList<String> column){
        
        MainFrame mainFrame = MainFrame.getMainFrame();
        setBounds(12, 10, 1000, 710);
        this.column = column; 

        regularTable = new RegularTable(this.data, this.column);
        JScrollPane scrollPane = new JScrollPane(regularTable);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JPanel leftPanel = new JPanel();

        leftPanel.add(scrollPane);
        add(leftPanel, BorderLayout.EAST);

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.show("multiSelect");        
            }
        });
        buttonList.add(b1);

        JButton b2 = new JButton("Back to DashBoard");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                mainFrame.returnToDashBoard();        
            }
        });
        buttonList.add(b2);

        JPanel rightPanel = new ButtonColumn(100, 150, buttonList);
        
        add(rightPanel, BorderLayout.WEST);
        
        setVisible(true);

    }

    public void setData(ArrayList<ArrayList<Object>> data) {
        
        regularTable.setData(data);
        
    }

    public static void main(String[] args){

        // MainFrame mainFrame = new MainFrame();
        
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        columns.add("ID");
        columns.add("name");
        columns.add("age");

        ArrayList<Object> row1 = new ArrayList<>();
        row1.add("1");
        row1.add("jishnu");
        row1.add(10);
        data.add(row1);
        
        ArrayList<Object> row2 = new ArrayList<>();
        row2.add("2");
        row2.add("john");
        row2.add(10);
        data.add(row2);
        
        ArrayList<Object> row3 = new ArrayList<>();
        row3.add("3");
        row3.add("jim");
        row3.add(10);
        data.add(row3);

        // // Confirmation c = new Confirmation(columns);

        // JFrame f = new JFrame();
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // f.add(c);
        // f.setSize(1024, 700);
        // f.setLayout(null);
        // f.setVisible(true);

        // // c.setData(data);
    }

}
