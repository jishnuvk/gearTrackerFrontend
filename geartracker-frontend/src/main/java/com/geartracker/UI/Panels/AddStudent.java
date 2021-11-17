package com.geartracker.UI.Panels;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.geartracker.UI.MainFrame;
import com.geartracker.UI.Utils.ConstraintChecker;
import com.geartracker.UI.Utils.InputForm;

public class AddStudent extends JPanel{

    InputForm form;

    public AddStudent(){

        setBounds(12, 10, 1000, 600);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        
        ArrayList<String> labels = new ArrayList<>(), types = new ArrayList<>();
        labels.add("Name"); types.add("string");
        labels.add("Password"); types.add("string");
        labels.add("email"); types.add("string");
        labels.add("Sports Team"); types.add("bool");
        labels.add("Sports Committee member?:");types.add("choice");

        form = new InputForm(labels, types, 400, 200);

        add(form);

        JPanel buttonPanel = new JPanel();

        JButton addStudent = new JButton("Add");
        addStudent.addActionListener((e)->addStudentPressed());
        buttonPanel.add(addStudent);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);

    }

    private void addStudentPressed(){

        Map<String, Object> response = form.getResponse();

        String err = ConstraintChecker.checkStudent(response);
        if(!err.equals("")){

            JOptionPane.showMessageDialog(this, err, "Bad Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
        AddStudent a = new AddStudent();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(a);
        f.setSize(1024, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
    
}
