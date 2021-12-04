package com.geartracker.UI.Panels;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.Application.RequestHttpClient;
import com.geartracker.Application.DTO.Request;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.InputForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CloseRequest extends JPanel{

    InputForm form;
    Request request;

    public CloseRequest(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Request ID"); types.add("string");
        labels.add("Student ID"); types.add("string");
        labels.add("Equipment ID"); types.add("string");
        labels.add("State:,available,lost,damaged"); types.add("choice");


        form = new InputForm(labels, types, 400, 200);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton closeRequest = new JButton("Close");
        closeRequest.addActionListener((e)->closeButtonPressed());
        buttonPanel.add(closeRequest);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);

    }

    public void run(){
        iteration();
    }

    private void iteration(){

        boolean rerun = false;

        do{
            rerun = false;
            String id = (String)JOptionPane.showInputDialog(this, "Enter the request ID", "ID", JOptionPane.PLAIN_MESSAGE);
            
            if(id == null){
                MainFrame.getMainFrame().returnToDashBoard();
                return;
            }

            JsonObject result = RequestHttpClient.get_request(id);

            if(result == null){
                JOptionPane.showMessageDialog(this, "The request does not exist");
                rerun = true;
                continue;
            }

            Gson gson = new Gson();

            request = gson.fromJson(result, Request.class);

            String status = request.getStatus();

            if(!status.equals("approved")){
                JOptionPane.showMessageDialog(this, "The given request is in" + status
                + " state, not in approved state");
                rerun = true;
                continue;
            }

            

        }while(rerun);

        form.getField("Request ID").setField(String.valueOf(request.getRequestId()));
        form.getField("Student ID").setField(String.valueOf(request.getUserId()));
        form.getField("Equipment ID").setField(String.valueOf(request.getEquipmentId()));
    }

    private void closeButtonPressed(){

        RequestHttpClient.close_request(request.getRequestId(), (String)form.getResponse().get("State:"));


        int choice = JOptionPane.showConfirmDialog(this, "Do you want to close more?", "Done",JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            iteration();
        }
        else
            MainFrame.getMainFrame().returnToDashBoard();
    }

    private void cancelPressed(){

        MainFrame.getMainFrame().returnToDashBoard();
    }

    public static void main(String[] args ){

        JFrame f = new JFrame();
        CloseRequest a = new CloseRequest();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}



