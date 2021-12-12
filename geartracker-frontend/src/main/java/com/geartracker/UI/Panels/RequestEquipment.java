package com.geartracker.UI.Panels;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.geartracker.Application.EquipmentHttpClient;
import com.geartracker.Application.DTO.User;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.*;

public class RequestEquipment extends JPanel{
    
    Confirmation confirmation;
    User user;
    ButtonTable buttonTable;

    public RequestEquipment(User user){

        this.user = user;

        ArrayList<String> column = new ArrayList<>();
        column.add("id");
        column.add("name");
        column.add("reserved");
        column.add("status");
        column.add("description");

        ArrayList<ArrayList<Object>> data = new ArrayList<>();
        
        setBounds(12, 10, 1000, 710);
        
        
        buttonTable  = new ButtonTable(data, column, (e)->tableButtonPressed(e));
        refreshTable();

        JScrollPane p = new JScrollPane(buttonTable);
        p.setPreferredSize(new Dimension(800, 600));

        JPanel leftPanel = new JPanel();

        leftPanel.add(p);
        add(leftPanel, BorderLayout.EAST);
        
        ArrayList<JButton> buttonList = new ArrayList<>();
        
        JButton back = new JButton("Back");
        back.addActionListener((e)->MainFrame.getMainFrame().returnToDashBoard());
        buttonList.add(back);

        
        

        JPanel rightPanel = new ButtonColumn(150, 150, buttonList);
        rightPanel.setBackground(Color.BLACK);
        add(rightPanel, BorderLayout.WEST);
        

        setVisible(true);
    }

    private void refreshTable(){
        ArrayList<ArrayList<Object>> data = EquipmentHttpClient.get_available_equipment();

        if(user.getSportsStatus()){
            buttonTable.updateData(data);
        }
        else{
            ArrayList<ArrayList<Object>> filtered_data = new ArrayList<>();
            
            data.forEach((row)->{
                if((boolean)row.get(2).equals("false"))
                    filtered_data.add(row);
            });

            buttonTable.updateData(filtered_data);
        }
    }

    private void tableButtonPressed(String equipment_id){

        String response = EquipmentHttpClient.book_equipment(equipment_id, user.getId());
        
        if(response.equals("fail")){
            int choice = JOptionPane.showConfirmDialog(this, "Request Failed! Someone must have grabbed it while you were looking. Book more?", ":(", JOptionPane.YES_NO_OPTION);
            
            if(choice == 1){
                MainFrame.getMainFrame().returnToDashBoard();
                return;
            }

        }
        else{
            int choice = JOptionPane.showConfirmDialog(this, "Equipment Successfully Requested! Do you want to book more?", ":D",JOptionPane.YES_NO_OPTION);

            if(choice == 1){
                MainFrame.getMainFrame().returnToDashBoard();
                return;
            }
            else{
                refreshTable();
            }
        }

        
    }

    public static void main( String[] args ){

        JFrame f = new JFrame();
        User u = new User();
        u.setSportsStatus(false);
        RequestEquipment s = new RequestEquipment(u);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        f.add(s);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }

}


