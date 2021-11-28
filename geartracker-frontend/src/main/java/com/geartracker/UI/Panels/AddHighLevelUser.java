package com.geartracker.UI.Panels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.Application.UserHttpClient;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ConstraintChecker;
import com.geartracker.UI.Utils.InputForm;

public class AddHighLevelUser extends JPanel{

    InputForm form;

    public AddHighLevelUser(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("ID"); types.add("string");
        labels.add("Name"); types.add("string");
        labels.add("Password"); types.add("string");
        labels.add("Email"); types.add("string");
        labels.add("User Type:,admin,instructor");types.add("choice");

        form = new InputForm(labels, types, 400, 200);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton addUser = new JButton("Add");
        addUser.addActionListener((e)->addUserPressed());
        buttonPanel.add(addUser);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);

    }

    private void addUserPressed(){

        Map<String, Object> response = form.getResponse();

        String err = ConstraintChecker.checkStudent(response);
        if(!err.equals("")){

            JOptionPane.showMessageDialog(this, err, "Bad Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, Object> user = new HashMap<>();
        user.put("id", response.get("ID"));
        user.put("name", response.get("Name"));
        user.put("password", response.get("Password"));
        user.put("email", response.get("Email"));
        user.put("student", 0);
        user.put("sportsStatus", false);
        user.put("fine", 0);

        ArrayList<String> role = new ArrayList<>();
        role.add((String)response.get("User Type:"));
        user.put("roles", role);

        UserHttpClient.add_user(user);        

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
        AddHighLevelUser a = new AddHighLevelUser();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}

