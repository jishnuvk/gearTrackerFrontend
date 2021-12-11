package com.geartracker.UI.Panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.geartracker.Application.DTO.User;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.DisplayUser;


public abstract class DashBoard extends JPanel{

    MainFrame mainFrame;
    User user;

    public DashBoard(User user){

        this.mainFrame = MainFrame.getMainFrame(); 
        this.user = user;
        setBounds(12, 10, 1000, 710);
        setVisible(true);

        add(new DisplayUser(user), BorderLayout.WEST);

    }

    

}
