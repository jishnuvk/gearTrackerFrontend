package com.geartracker.UI.Panels;


import java.awt.Font;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.InputForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.geartracker.Application.UserHttpClient;
import com.geartracker.Application.DTO.User;

public class Login extends JPanel{
    
    InputForm form;

    public Login(){
        
        
        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalGlue());
        
        JLabel label = new JLabel("GEARTRACKER");
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        
        add(label);
        add(Box.createVerticalGlue());

        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("ID");
        types.add("string");
        labels.add("Password");
        types.add("password");

        form = new InputForm(labels, types, 400, 100);
        form.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(form);
        add(Box.createVerticalGlue());

        JButton loginButton = new JButton("login");
        
        loginButton.addActionListener((e)->loginButtonPressed());

        loginButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(loginButton);
        add(Box.createVerticalGlue());

        setVisible(true);

    }

    private void loginButtonPressed(){

        MainFrame mainframe = MainFrame.getMainFrame();

        Map<String,Object> a = form.getResponse();

        String id = (String)a.get("ID");
        String password = (String)a.get("Password");

        JsonObject result = UserHttpClient.login(id, password);

        if(result == null){
            JOptionPane.showMessageDialog(this, "Wrong UserName or Password", ":o", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Gson gson = new Gson();

        User user = gson.fromJson(result, User.class);

        if(user.getRoles().contains("sportscomm")){
            mainframe.setDashBoard(new SCDashBoard(user));
        }
        else if(user.getRoles().contains("student")){
            mainframe.setDashBoard(new StudentDashBoard(user));
        }
        else if(user.getRoles().contains("instructor")){
            mainframe.setDashBoard(new InstructorDashBoard(user));
        }
        else if(user.getRoles().contains("admin")){
            mainframe.setDashBoard(new AdminDashBoard(user));
        }
    }

    public static void main( String[] args ){

        JFrame f = new JFrame();
        Login s = new Login();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        f.add(s);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }



}
