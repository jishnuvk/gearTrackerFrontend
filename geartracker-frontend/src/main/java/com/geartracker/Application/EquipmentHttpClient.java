package com.geartracker.Application;

import static org.junit.Assert.assertNotEquals;

import java.util.*;

import org.json.JSONArray;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EquipmentHttpClient
{
	public static String book_equipment(String equipment_id, String user_id)
	{
		HttpResponse<String> jsonResponse = null;
		String s = "{\"user_id\":" + "\""+ user_id + "\"}";
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/equipments/book/"+equipment_id)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.body(s)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		return jsonResponse.getBody().toString();
	}
	public static ArrayList<ArrayList<Object>> get_equipment(String student_id)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/equipments/student/"+student_id)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		ArrayList<Object> stringArray = new ArrayList<Object>();
	    JSONArray jsonArray = new JSONArray(jsonResponse.getBody().toString());

	    for (int i = 0; i < jsonArray.length(); i++) 
	    {
	        stringArray.add(jsonArray.get(i));
	    }
	    
	    ArrayList<ArrayList<Object>> requests = new ArrayList<ArrayList<Object>>();
	    for(int i=0;i<stringArray.size();i++)
	    {
	    	JsonObject jsonObject = new JsonParser().parse(stringArray.get(i).toString()).getAsJsonObject();
	    	ArrayList<Object> details = new ArrayList<Object>();
	    	details.add(jsonObject.get("id").getAsString());
	    	details.add(jsonObject.get("name").getAsString());
	    	details.add(jsonObject.get("reserved").getAsString());
	    	details.add(jsonObject.get("status").getAsString());
	    	details.add(jsonObject.get("description").getAsString());
	    	requests.add(details);
	    }
	    return requests;
	}
	public static ArrayList<Object> equipment_report()
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
    	ArrayList<Object> Details = new ArrayList<Object>();
    	Details.add(jsonObject.get("id"));
    	Details.add(jsonObject.get("name"));
    	Details.add(jsonObject.get("description"));
    	Details.add(jsonObject.get("reserved"));
    	Details.add(jsonObject.get("status"));
    	return Details;
	}
	//not completed
	public static String add_equipment(Map<String, Object> equipment)
	{
		HttpResponse<String> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(equipment);
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/equipments")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.body(json)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		if(jsonResponse.getStatus() == 200)
		{
			return "Success";
		}
		return "Failed to add the equipment";
	}
	public static ArrayList<ArrayList<Object>> get_available_equipment()
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/equipments/available")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		ArrayList<Object> stringArray = new ArrayList<Object>();
	    JSONArray jsonArray = new JSONArray(jsonResponse.getBody().toString());

	    for (int i = 0; i < jsonArray.length(); i++) 
	    {
	        stringArray.add(jsonArray.get(i));
	    }
	    
	    ArrayList<ArrayList<Object>> requests = new ArrayList<ArrayList<Object>>();
	    for(int i=0;i<stringArray.size();i++)
	    {
	    	JsonObject jsonObject = new JsonParser().parse(stringArray.get(i).toString()).getAsJsonObject();
	    	ArrayList<Object> details = new ArrayList<Object>();
	    	details.add(jsonObject.get("id").getAsString());
	    	details.add(jsonObject.get("name").getAsString());
	    	details.add(jsonObject.get("reserved").getAsString());
	    	details.add(jsonObject.get("status").getAsString());
	    	details.add(jsonObject.get("description").getAsString());
	    	requests.add(details);
	    }
	    return requests;
	}
	public static String delete_equipment(String equipment_id)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.delete("http://localhost:8080/geartracker-backend/webapi/equipments/"+equipment_id)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		return jsonResponse.getBody().toString();
	}
	public static JsonObject report_equipment_acc_to_status(String status)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report/equipment/"+status)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
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