package com.geartracker.UI.Panels;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ButtonColumn;
import com.geartracker.UI.Utils.RegularTable;

//for screens that only display info in a table. 
//No input can be taken in the table.
public class DisplayOnlyScreen extends JPanel{
    
    public DisplayOnlyScreen( ArrayList<String> column, ArrayList<ArrayList<Object>> data){

        MainFrame mainFrame = MainFrame.getMainFrame();
        setBounds(12, 10, 1000, 710);
        // ArrayList<String> column = new ArrayList<>();
        // // column.add("ID");
        // // column.add("name");
        // // column.add("age");

        // ArrayList<ArrayList<Object>> data = new ArrayList<>();
        // ArrayList<Object> row1 = new ArrayList<>();
        // row1.add("1");
        // row1.add("jishnu");
        // row1.add(10);
        // data.add(row1);
        
        // ArrayList<Object> row2 = new ArrayList<>();
        // row2.add("2");
        // row2.add("john");
        // row2.add(10);
        // data.add(row2);
        
        // ArrayList<Object> row3 = new ArrayList<>();
        // row3.add("3");
        // row3.add("jim");
        // row3.add(10);
        // data.add(row3);


        // datafetcher.fetch(column, data);
        RegularTable regularTable = new RegularTable(data, column);
        JScrollPane scrollPane = new JScrollPane(regularTable);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JPanel leftPanel = new JPanel();

        leftPanel.add(scrollPane);
        add(leftPanel, BorderLayout.EAST);

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton b1 = new JButton("Done");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mainFrame.returnToDashBoard();        
            }
        });
        buttonList.add(b1);

        JPanel rightPanel = new ButtonColumn(150, 100, buttonList);
        // rightPanel.setBackground(Color.BLACK);
        add(rightPanel, BorderLayout.WEST);
        leftPanel.setBackground(Color.BLACK);
        setVisible(true);
    }

    public static void main(String[] args){

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

}

@FunctionalInterface
interface DataFetcher{

    public void fetch(ArrayList<String> columns, ArrayList<ArrayList<Object>> data);
}
