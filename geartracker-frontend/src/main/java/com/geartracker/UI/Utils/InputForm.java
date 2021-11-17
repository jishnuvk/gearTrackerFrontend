package com.geartracker.UI.Utils;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;


public class InputForm extends JPanel{
    
    private ArrayList<InputField> inputs;

    public InputForm(ArrayList<String> labels, ArrayList<String> types, int width, int height){

        
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        InputFieldFactory factory = new InputFieldFactory();
        inputs = new ArrayList<>();
        for(int i = 0; i < labels.size(); i++){
            InputField curr = factory.getInputField(labels.get(i), types.get(i));
            inputs.add(curr);
            add(curr);
        }

    }

    public InputField getField(String label){

        for(int i=0; i < inputs.size(); i++){
            if(inputs.get(i).getLabel().equals(label)){
                return inputs.get(i);
            }
        }

        return null;

    }


    public Map<String,Object> getResponse(){

        Map<String,Object> responses = new HashMap<>();

        inputs.forEach((input)->responses.put(input.getLabel(), input.getResponse()));
        return responses;
    }

    public void clear(){

        inputs.forEach((i)->i.clear());
    }

}






