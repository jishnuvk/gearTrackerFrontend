package com.geartracker.Application;

import java.util.*;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.geartracker.Application.DTO.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;


public class UserHttpClient
{
	public static String get_auth_token(String user_name, String password)
	{
		String user_cred = "{\"id\":\""+user_name+"\",\"password\":\""+password+"\"}";
		String auth_token = "";
		
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/login")
				.header("Content-Type", "application/json")
				.body(user_cred)
				.asJson();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			auth_token = jsonObject.get("authToken").getAsString();
			return auth_token;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static JsonObject login(String user_name, String password)
	{
		String user_cred = "{\"id\":\""+user_name+"\",\"password\":\""+password+"\"}";
		
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/login")
				.header("Content-Type", "application/json")
				.body(user_cred)
				.asJson();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static String add_user(Map<String, Object> user)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user);
		String auth_token = get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/users")
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.body(json)
			.asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
        }
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Added User";
		}
		return "Error in adding user. Please try again";
	}
	public static String edit_user(User user)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user, User.class);
		String auth_token = get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/users/" + user.getId())
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.body(json)
			.asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Edited User";
		}
		return "Error in editing user. Please try again";
	}
	public static JsonObject show_user(String user_id)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		String auth_token = get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/users/"+user_id)
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch(NullPointerException npe){
			return null;
		}	
	}

}