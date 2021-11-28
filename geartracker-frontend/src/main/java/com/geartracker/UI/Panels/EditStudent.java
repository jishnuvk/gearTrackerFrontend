package com.geartracker.UI.Panels;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.Application.UserHttpClient;
import com.geartracker.Application.DTO.User;
import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ConstraintChecker;
import com.geartracker.UI.Utils.InputForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EditStudent extends JPanel{

    InputForm form;
    User student;

    public EditStudent(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name"); types.add("string");
        labels.add("Password"); types.add("string");
        labels.add("Email"); types.add("string");
        labels.add("Sports Team"); types.add("bool");
        labels.add("Sports Committee member?");types.add("bool");

        form = new InputForm(labels, types, 400, 200);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton editStudent = new JButton("Commit");
        editStudent.addActionListener((e)->editStudentPressed());
        buttonPanel.add(editStudent);

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

            String id = (String)JOptionPane.showInputDialog(this, "Enter the student ID", "ID", JOptionPane.PLAIN_MESSAGE);


            if(id == null){
                MainFrame.getMainFrame().returnToDashBoard();
                return;
            }

            JsonObject result = UserHttpClient.show_user(id);

            if(result == null){
                JOptionPane.showMessageDialog(this, "The student does not exist");
                rerun = true;
                continue;
            }

            Gson gson = new Gson();
            student = gson.fromJson(result, User.class);

        }while(rerun);

        form.getField("Name").setField(student.getName());
        form.getField("Password").setField(student.getPassword());
        form.getField("Email").setField(student.getEmail());
        form.getField("Sports Team").setField(student.getSportsStatus());

        if(student.getRoles().contains("sportscomm")){
            form.getField("Sports Committee member?").setField(true);
        }
        else{
            form.getField("Sports Committee member?").setField(false);
        }
    }

    private void editStudentPressed(){

        Map<String, Object> response = form.getResponse();

        String err = ConstraintChecker.checkStudent(response);
        if(!err.equals("")){

            JOptionPane.showMessageDialog(this, err, "Bad Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        student.setName((String)response.get("Name"));
        student.resetPassword((String)response.get("Password"));
        student.setEmail((String)response.get("Email"));
        student.setSportsStatus((boolean)response.get("Sports Team"));
        
        ArrayList<String> role = new ArrayList<>();

        role.add("student");
        if((Boolean)response.get("Sports Committee member?")){
            role.add("sportscomm");
        }
        
        student.setRoles(role);

        UserHttpClient.edit_user(student);


        int choice = JOptionPane.showConfirmDialog(this, "Do you want to edit more?", "Done",JOptionPane.YES_NO_OPTION);
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
        EditStudent a = new EditStudent();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
