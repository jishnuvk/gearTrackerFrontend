package com.geartracker.UI.Panels;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.Application.EquipmentHttpClient;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.InputForm;

public class AddEquipment extends JPanel{

    InputForm form;
    public AddEquipment(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("id"); types.add("string");
        labels.add("name"); types.add("string");
        labels.add("description"); types.add("string");
        labels.add("reserved"); types.add("bool");

        form = new InputForm(labels, types, 400, 150);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton addEquipment = new JButton("Add");
        addEquipment.addActionListener((e)->addEquipmentPressed());
        buttonPanel.add(addEquipment);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);
    }

    private void addEquipmentPressed(){

        Map<String, Object> response = form.getResponse();
        
        response.put("status", "available");
        String result = EquipmentHttpClient.add_equipment(response);

        if(result != "Success"){
            JOptionPane.showMessageDialog(this, result, ":o", JOptionPane.ERROR_MESSAGE);
        }

        int choice = JOptionPane.showConfirmDialog(this, "Do you want to add more?", "Done",JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            form.clear();
        }
        else{
            MainFrame.getMainFrame().returnToDashBoard();
        }

    }

    private void cancelPressed(){

        MainFrame.getMainFrame().returnToDashBoard();
    }

    public static void main(String[] args ){

        JFrame f = new JFrame();
        AddEquipment a = new AddEquipment();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
