package com.geartracker.UI.Utils;

public class InputFieldFactory {
    
    public InputField getInputField(String label, String inputType){

        if(inputType == "password"){
            return new PasswordInputField(label);
        }
        else if(inputType == "bool"){
            return new BoolInputField(label);
        }
        else if(inputType == "choice"){
            return new RadioButtonInputField(label);
        }
        else{
            return new TextInputField(label);
        }
        

    }

}
