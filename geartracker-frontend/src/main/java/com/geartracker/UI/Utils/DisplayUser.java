package com.geartracker.UI.Utils;


import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.geartracker.Application.DTO.User;

public class DisplayUser extends JPanel{

    public DisplayUser(User user){


        setBounds(12, 10, 1000, 710);
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);
        textArea.setFont(new Font("Sans", Font.PLAIN, 20));

        textArea.append("ID: " + user.getId());
        textArea.append("\nName: " + user.getName());
        textArea.append("\nEmail: " + user.getEmail());
        
        if(user.getRoles().contains("student")){
            textArea.append("\nFine: " + String.valueOf(user.getFine()));
        }

        textArea.setBackground(getBackground());
        add(textArea);
        

    }

    public static void main(String[] args) {
        

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        User u = new User("IMT2018033", "Jishnu", "a", "jishnu@iiitb.org");
        ArrayList<String> r = new ArrayList<String>();
        r.add("Student");
        u.setRoles(r);
        u.addFine(100);
        DisplayUser v = new DisplayUser(u);
        f.add(v);

        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);

        
    }
    
}
