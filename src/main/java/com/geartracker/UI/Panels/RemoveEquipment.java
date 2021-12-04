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

public class RemoveEquipment extends JPanel{

    InputForm form;

    public RemoveEquipment(){
        
        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("ID"); types.add("string");
        
        form = new InputForm(labels, types, 400, 50);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton removeEquipment = new JButton("Remove");
        removeEquipment.addActionListener((e)->removeEquipmentPressed());
        buttonPanel.add(removeEquipment);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);
    }

    private void removeEquipmentPressed(){
        
        Map<String, Object> response = form.getResponse();

        String code = EquipmentHttpClient.delete_equipment((String)response.get("ID"));

        if(!code.equals("success")){
            JOptionPane.showMessageDialog(this, "The equipment does not exist", "XP", JOptionPane.ERROR_MESSAGE);
        }


        int choice = JOptionPane.showConfirmDialog(this, "Do you want to remove more?", "Done",JOptionPane.YES_NO_OPTION);
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
        RemoveEquipment a = new RemoveEquipment();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }


    
}
