package com.geartracker.UI;

import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;

import com.geartracker.UI.Panels.*;

public class MainFrame extends JFrame {

    Container container;
    CardLayout layout;
    DashBoard dashBoard;


    public MainFrame(){
        
        container = getContentPane();
        layout = new CardLayout();

        setLayout(layout);

        setSize(1000,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addCard(String cardId, JComponent card){
        container.add(cardId, card);
    }

    public void login(){
        
        addCard("login", new Login(this));
        show("login");
        setVisible(true);

    }

    public void returnToDashBoard(){

        container.removeAll();
        addCard("dashBoard", dashBoard);
        show("dashBoard");
    }

    public void show(String cardId){

        layout.show(container, cardId);
    }

    public void setDashBoard(DashBoard dashBoard){

        this.dashBoard = dashBoard;
        addCard("dashBoard",dashBoard);
        show("dashBoard");

    }

    public void setStudentDashBoard(){
        setDashBoard(new StudentDashBoard(this));
    }

    public void setSCDashBoard(){
        setDashBoard(new SCDashBoard(this));
    }

    public static void main( String[] args ){

        MainFrame mainframe = new MainFrame();

        mainframe.login();
    

    }

}


