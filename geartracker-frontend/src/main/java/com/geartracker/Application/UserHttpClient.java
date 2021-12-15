package com.geartracker.Application;

import static org.junit.Assert.assertNotEquals;

import java.util.*;
import com.mashape.unirest.http.Unirest;
import com.geartracker.Application.DTO.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UserHttpClient
{
	public static String auth_token = "";
	public static JsonObject login(String user_name, String password)
	{
		String user_cred = "{\"id\":\""+user_name+"\",\"password\":\""+password+"\"}";
		
		HttpResponse<String> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/login")
				.header("Content-Type", "application/json")
				.body(user_cred)
				.asString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			auth_token = jsonObject.get("authToken").getAsString();
			return jsonObject;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static String add_user(Map<String, Object> user)
	{
		HttpResponse<String> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user);
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/users")
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.body(json)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
        }
		
		assertNotEquals("Unauthorised to this user", jsonResponse.getStatus(), 401);
		
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Added User";
		}
		return "Error in adding user. Please try again";
	}
	public static String edit_user(User user)
	{
		HttpResponse<String> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user, User.class);
		
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/users/" + user.getId())
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.body(json)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised to this user", jsonResponse.getStatus(), 401);
		
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Edited User";
		}
		return "Error in editing user. Please try again";
	}
	public static JsonObject show_user(String user_id)
	{
		HttpResponse<String> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/users/"+user_id)
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised to this user", jsonResponse.getStatus(), 401);
		
		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch(NullPointerException npe){
			return null;
		}	
	}
}