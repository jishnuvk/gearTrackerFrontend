package com.geartracker.UI.Panels;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.util.ArrayList;

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

public class Login extends JPanel{
    
    public Login(MainFrame mainframe){
        
        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalGlue());
        
        JLabel label = new JLabel("GEARTRACKER");
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        
        add(label);
        add(Box.createVerticalGlue());

        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name");
        types.add("string");
        labels.add("Password");
        types.add("password");

        InputForm form = new InputForm(labels, types, 400, 100);
        form.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(form);
        add(Box.createVerticalGlue());

        JButton loginButton = new JButton("login");
        
        loginButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                ArrayList<Object> a = form.getResponse();

                String password = (String)a.get(1);
                if(password.equals("Student")){
                    mainframe.setStudentDashBoard();
                }
                else if(password.equals("SC")){
                    mainframe.setSCDashBoard();
                }
                else{
                    JOptionPane.showMessageDialog(mainframe, "Wrong username or password" + password);
                }
                
            }
        });

        loginButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        add(loginButton);
        add(Box.createVerticalGlue());

        setVisible(true);

    }

    public static void main( String[] args ){

        MainFrame m = new MainFrame();
        JFrame f = new JFrame();
        Login s = new Login(m);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        f.add(s);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

    }



}
