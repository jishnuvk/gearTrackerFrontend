package com.geartracker.UI.Utils;

import java.util.ArrayList;

import javax.swing.JPanel;


public class InputForm extends JPanel{
    
    ArrayList<InputField> inputs;

    public InputForm(ArrayList<String> labels, ArrayList<String> types){

        InputFieldFactory factory = new InputFieldFactory();
        inputs = new ArrayList<>();
        for(int i = 0; i < labels.size(); i++){
            InputField curr = factory.getInputField(labels.get(i), types.get(i));
            inputs.add(curr);
            add(curr);
        }

    }

    public ArrayList<Object> getResponse(){

        ArrayList<Object> responses = new ArrayList<>();

        inputs.forEach((input)->responses.add(input.getResponse()));
        return responses;
    }

}






