package com.geartracker.UI.Utils;

public class InputFieldFactory {
    
    public InputField getInputField(String label, String inputType){

        if(inputType == "password"){
            return new PasswordInputField(label);
        }
        else if(inputType == "bool"){
            return new BoolInputField(label);
        }
        else{
            return new TextInputField(label);
        }

    }

}
