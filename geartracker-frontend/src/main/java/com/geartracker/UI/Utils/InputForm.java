package com.geartracker.UI.Utils;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InputForm extends JPanel{
    
    public InputForm(ArrayList<String> labels, ArrayList<String> types){


        for(int i = 0; i < labels.size(); i++){
            add(new InputField(labels.get(i), types.get(i)));
        }

    }

}

class InputField extends JPanel{

    JLabel label;
    JComponent input;

    public InputField(String labelString, String inputType){

        label = new JLabel(labelString);
        
        if(inputType == "string"){
            input = new JTextField();
            input.setPreferredSize(new Dimension(300, (int)input.getPreferredSize().getHeight()));
        }
        else if(inputType == "bool"){
            input = new JCheckBox();
        }
        else if(inputType == "password"){
            input = new JPasswordField();
            input.setPreferredSize(new Dimension(300, (int)input.getPreferredSize().getHeight()));

        }

        add(label);
        add(input);
        
    }


}


