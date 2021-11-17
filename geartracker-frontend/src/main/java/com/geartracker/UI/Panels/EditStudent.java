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

public class EditStudent extends JPanel{

    InputForm form;

    public EditStudent(){

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
        iteration();

        JPanel buttonPanel = new JPanel();

        JButton editStudent = new JButton("Commit");
        editStudent.addActionListener((e)->editStudentPressed());
        buttonPanel.add(editStudent);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener((e)->cancelPressed());
        buttonPanel.add(cancel);

        add(buttonPanel);

    }

    private void iteration(){

        String id = (String)JOptionPane.showInputDialog(this, "Enter the student ID", "ID", JOptionPane.PLAIN_MESSAGE);
        
        if(id == null)
            MainFrame.getMainFrame().returnToDashBoard();


        form.getField("Name").setField(id);
        form.getField("Password").setField("Password");
        form.getField("email").setField("Jishnu@iiitb.org");
        form.getField("Sports Team").setField(true);
        form.getField("Sports Committee member?:").setField("No");
    }

    private void editStudentPressed(){

        Map<String, Object> response = form.getResponse();

        String err = ConstraintChecker.checkStudent(response);
        if(!err.equals("")){

            JOptionPane.showMessageDialog(this, err, "Bad Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

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
