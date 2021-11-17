package com.geartracker.UI.Utils;

import java.awt.Dimension;

import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public abstract class InputField extends JPanel{
    JLabel label;
    
    

    public InputField(String labelString){

        label = new JLabel(labelString);
       

        // if(inputType == "string"){
        //     input = new JTextField();
        //     input.setPreferredSize(new Dimension(300, (int)input.getPreferredSize().getHeight()));
        // }
        // else if(inputType == "bool"){
        //     input = new JCheckBox();
        // }
        // else if(inputType == "password"){
        //     input = new JPasswordField();
        //     input.setPreferredSize(new Dimension(300, (int)input.getPreferredSize().getHeight()));

        // }

        add(label);
        // add(input);
        
    }

    abstract public Object getResponse();
}


class TextInputField extends InputField{

    JTextField input;

    public TextInputField(String labelString){

        super(labelString);
        input = new JTextField();
        input.setPreferredSize(new Dimension(300 - label.getPreferredSize().width, (int)input.getPreferredSize().getHeight() ));
        add(input);
    }

    public String getResponse(){

        return input.getText();
    }

}

class BoolInputField extends InputField{

    JCheckBox input;

    public BoolInputField(String labelString){

        super(labelString);
        input = new JCheckBox();
        add(input);
    }

    public Boolean getResponse(){

        return input.isSelected();
    }

}

class PasswordInputField extends InputField{

    JPasswordField input;

    public PasswordInputField(String labelString){

        super(labelString);
        input = new JPasswordField();
        int a = label.getPreferredSize().width;
        input.setPreferredSize(new Dimension(300 - label.getPreferredSize().width, (int)input.getPreferredSize().getHeight()));
        add(input);
    }

    public String getResponse(){

        return new String(input.getPassword());
    }


}

