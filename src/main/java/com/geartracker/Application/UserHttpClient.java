package com.geartracker.Application;

import java.io.*;
import java.util.*;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;


public class UserHttpClient
{
	public static JsonObject login(String user_name, String password)
	{
		String user_cred = "{\"id\":\""+user_name+"\",\"password\":\""+password+"\"}";
		//String user_cred = "{\"id\": \"stud1\", \"password\": \"password\"}";
			    
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			//requests made by user 'user'
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/login")
				.header("Content-Type", "application/json")
				.body(user_cred)
				.asJson();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
		return jsonObject;
	}
	public static String add_user(Map<String, Object> user)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user);
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/users")
			.header("Content-Type", "application/json")
			.body(json)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Added User";
		}
		return "Error in adding user. Please try again";
	}
	public static String edit_user(Map<String, Object> user)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(user);
		//http://localhost:8080/geartracker-backend/webapi/users/admin1
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/users/admin1")
			.header("Content-Type", "application/json")
			.body(json)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Edited User";
		}
		return "Error in editing user. Please try again";
	}
}