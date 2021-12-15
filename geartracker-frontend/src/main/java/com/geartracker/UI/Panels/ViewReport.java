package com.geartracker.UI.Panels;


import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import com.geartracker.Application.EquipmentHttpClient;
import com.geartracker.Application.RequestHttpClient;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ButtonColumn;
import com.geartracker.UI.Utils.RegularTable;

import org.json.JSONObject;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class ViewReport extends JPanel{

    RegularTable regularTable;
    JComboBox<String> reportPicker;

    JDatePickerImpl fromDatePicker;
    JDatePickerImpl toDatePicker;


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


        JPanel reportTypePanel = new JPanel();
        reportTypePanel.add(new JLabel("Report Type"));

        reportPicker = new JComboBox<>();
        reportPicker.addItem("lost");
        reportPicker.addItem("broken");
        reportPicker.addItem("discarded");
        reportPicker.addItem("requests");
        // reportPicker.addItem("Requested");

        // reportPicker.addActionListener((e)->iteration());
        reportTypePanel.add(reportPicker);

        rightPanel.add(reportTypePanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel fromPanel = new JPanel();

        fromPanel.add(new JLabel("From"));
        UtilDateModel fromModel = new UtilDateModel();
        JDatePanelImpl fromDatePanel = new JDatePanelImpl(fromModel);
        fromDatePicker = new JDatePickerImpl(fromDatePanel);
        // datePicker.setBounds(220,350,120,30);
        fromPanel.add(fromDatePicker);

        rightPanel.add(fromPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel toPanel = new JPanel();

        toPanel.add(new JLabel("To    "));
        UtilDateModel toModel = new UtilDateModel();
        JDatePanelImpl toDatePanel = new JDatePanelImpl(toModel);
        toDatePicker = new JDatePickerImpl(toDatePanel);
        
        toPanel.add(toDatePicker);

        rightPanel.add(toPanel);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        ArrayList<JButton> buttonList = new ArrayList<>();

        JButton fetch = new JButton("Fetch");
        fetch.addActionListener((e)->iteration());
        buttonList.add(fetch);
        // rightPanel.add(fetch);

        rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        JButton back = new JButton("Back");
        back.addActionListener((e)->MainFrame.getMainFrame().returnToDashBoard());
        buttonList.add(back);

        // rightPanel.add(back);
        ButtonColumn buttonColumn = new ButtonColumn(200, 200, buttonList);
        rightPanel.add(buttonColumn);
        buttonColumn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        

    }

    private String dateToString(Date date){
        
        LocalDate d = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return d.toString();

    }

    private void iteration(){

        // System.out.println( reportPicker.getSelectedItem());
        // System.out.println( fromDatePicker.getModel().getValue());

        JSONObject response = new JSONObject();

        Date fromDate = (Date)fromDatePicker.getModel().getValue();
        Date toDate = (Date)toDatePicker.getModel().getValue();

        
        if(fromDate == null){

            Calendar c = Calendar.getInstance();
            c.set(2000, 1, 1, 1, 1, 1);
            fromDate = c.getTime();
        }
        if(toDate == null){
            toDate = Calendar.getInstance().getTime();
        }
        if(fromDate.after(toDate)){
            JOptionPane.showMessageDialog(this, "The dates are incompatible");
        }   
        else{
            // System.out.println(dateToString(fromDate) + " " + dateToString(toDate));
            Map<String, Object> dates = new HashMap<>();
            System.out.println(dateToString(fromDate));
            System.out.println(dateToString(toDate));
            dates.put("startDate", dateToString(fromDate));
            dates.put("endDate", dateToString(toDate));

            String type = (String)reportPicker.getSelectedItem();

            if(type == "requests"){
                
                response = new JSONObject(RequestHttpClient.report_request_count_date(dates).toString());
            }
            else{
                response = new JSONObject(EquipmentHttpClient.report_equipment_acc_to_status(type, dates).toString());
            }

        }
        
        
        

        // JSONObject j = new JSONObject("{\"basketball\": 1,\"badminton Racket\": 1,\"Badminton Racket\": 1}");

        Iterator<String> keys = response.keys();

        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        
        while(keys.hasNext()){

            String key = keys.next();

            ArrayList<Object> row = new ArrayList<>();
            row.add(key);
            row.add(response.get(key));

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
