package com.geartracker.UI.Panels;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.geartracker.UI.Utils.InputForm;

public class Login extends JPanel{
    
    public Login(){
        setBounds(12, 10, 1000, 710);

        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name");
        types.add("string");
        labels.add("Password");
        types.add("bool");

        InputForm form = new InputForm(labels, types);
        add(form);

        JButton loginButton = new JButton();
        loginButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                ArrayList<Object> a = form.getResponse();

                a.forEach((o)-> System.out.println(o));
                
            }
        });

        add(loginButton);

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
