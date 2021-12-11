package com.geartracker.UI.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.RegularTable;

import org.json.JSONObject;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.JDatePicker;

public class ViewReport extends JPanel{

    RegularTable regularTable;
    JComboBox<String> reportPicker;

    JDatePickerImpl datePicker;

    public ViewReport(){

        setBounds(12, 10, 1000, 710);
        
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Category");
        columns.add("Count");

        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        regularTable = new RegularTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(regularTable);
        scrollPane.setPreferredSize(new Dimension(600, 600));

        JPanel leftPanel = new JPanel();

        leftPanel.add(scrollPane);
        add(leftPanel, BorderLayout.EAST);


        JPanel rightPanel = new JPanel();

        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        add(rightPanel, BorderLayout.WEST);

        reportPicker = new JComboBox<>();
        reportPicker.addItem("Available");
        reportPicker.addItem("Damaged");
        reportPicker.addItem("Lost");
        reportPicker.addItem("Issued");
        reportPicker.addItem("Requested");

        reportPicker.addActionListener((e)->iteration());
        rightPanel.add(Box.createVerticalGlue());

        rightPanel.add(reportPicker);

        UtilDateModel model=new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        // datePicker.setBounds(220,350,120,30);
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(datePicker);

        JButton back = new JButton("Back");
        back.addActionListener((e)->MainFrame.getMainFrame().returnToDashBoard());

        rightPanel.add(back);

        rightPanel.add(Box.createVerticalGlue());
        

    }

    private void iteration(){

        System.out.println( reportPicker.getSelectedItem());
        JSONObject j = new JSONObject("{\"basketball\": 1,\"badminton Racket\": 1,\"Badminton Racket\": 1}");

        Iterator<String> keys=  j.keys();

        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        
        while(keys.hasNext()){

            String key = keys.next();

            ArrayList<Object> row = new ArrayList<>();
            row.add(key);
            row.add(j.get(key));

            data.add(row);

        }

        regularTable.setData(data);
        

    }

    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ViewReport v = new ViewReport();
        f.add(v);

        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

        v.iteration();

    }
    
}
