package com.geartracker.UI.Utils;

import java.util.Map;

public class ConstraintChecker {
    
    public static String checkStudent(Map<String, Object> attributes){
        
        //check name
        // Object attribute = attributes.get("Name");
        // if(! (attribute instanceof String ) )
        //     return "Name not string";
        
        // //email
        // attribute = attributes.get("Email");
        // if(! (attribute instanceof String ) )
        //     return "";
        
        Object attribute = attributes.get("email");
        String email = (String)attribute;
        if(!(email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))){
            return "Please check the email format";
        }
        
        //additional roles
        // attribute = attributes.get("Sports Committee member?:");
        // if(! (attribute instanceof String ) )
        //     return false;
        
        return "";
    }

   

}
