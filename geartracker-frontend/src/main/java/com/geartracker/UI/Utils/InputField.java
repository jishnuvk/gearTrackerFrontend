package com.geartracker.UI.Utils;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public abstract class InputField extends JPanel{
    
    JLabel label;
    String labelString;


    public InputField(String labelString){

        this.labelString = labelString;
        label = new JLabel(labelString);
        add(label);        
    }

    public String getLabel(){
        return labelString;
    }

    abstract public Object getResponse();
    abstract public void setField(Object set);
    abstract public void clear();
}


class TextInputField extends InputField{

    JTextField input;

    public TextInputField(String labelString){

        super(labelString);
        input = new JTextField();
        input.setPreferredSize(new Dimension(300 - label.getPreferredSize().width, (int)input.getPreferredSize().getHeight() ));
        add(input);
    }

    @Override
    public String getResponse(){

        return input.getText();
    }

    @Override
    public void setField(Object set){
        if(set instanceof String){
            input.setText((String)set);
        }
    }

    @Override
    public void clear(){
        input.setText("");
    }
}

class BoolInputField extends InputField{

    JCheckBox input;

    public BoolInputField(String labelString){

        super(labelString);
        input = new JCheckBox();
        add(input);
    }

    @Override
    public Boolean getResponse(){

        return input.isSelected();
    }

    @Override
    public void setField(Object set){
        if(set instanceof Boolean){
            input.setSelected((Boolean)set);
        }
    }

    @Override
    public void clear(){

        input.setSelected(false);
    }


}

class PasswordInputField extends InputField{

    JPasswordField input;

    public PasswordInputField(String labelString){

        super(labelString);
        input = new JPasswordField();
        input.setPreferredSize(new Dimension(300 - label.getPreferredSize().width, (int)input.getPreferredSize().getHeight()));
        add(input);
    }

    @Override
    public String getResponse(){

        return new String(input.getPassword());
    }

    @Override
    public void setField(Object set){
        if(set instanceof String){
            input.setText((String)set);
        }
    }

    @Override
    public void clear(){
        input.setText("");
    }

}

class RadioButtonInputField extends InputField{

    ButtonGroup group = new ButtonGroup();
    ArrayList<JRadioButton> buttons = new ArrayList<>();

    public RadioButtonInputField(String labelString){

        super(labelString.split(",")[0]);

        String[] choices = labelString.split(",");

        if(choices.length >= 3){
            for(int i = 1; i < choices.length; i++){

                JRadioButton button = new JRadioButton(choices[i]);
                group.add(button);
                buttons.add(button);
                add(button);
            }
        }
        else{
                JRadioButton yesButton = new JRadioButton("yes");
                group.add(yesButton);
                buttons.add(yesButton);
                add(yesButton);

                JRadioButton noButton = new JRadioButton("no");
                group.add(noButton);
                buttons.add(noButton);
                add(noButton);
        }

        buttons.get(0).setSelected(true);
    }

    @Override
    public String getResponse(){

        for(int i = 0; i < buttons.size(); i++){
            if(buttons.get(i).isSelected()){
                return buttons.get(i).getText();
            }

        }

        return null;
    }

    @Override
    public void setField(Object set){
        if(set instanceof String){
            for(int i = 0; i < buttons.size(); i++){
                if(buttons.get(i).getText().equals(set)){
                    buttons.get(i).setSelected(true);
                    return;
                }
    
            }
        }
    }

    @Override
    public void clear(){
        buttons.get(0).setSelected(true);
    }


}

