package com.geartracker.Application;

import java.io.*;
import java.util.*;

import org.json.JSONArray;
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

public class EquipmentHttpClient
{
	public static String book_equipment(String equipment_id, String user_id)
	{
		HttpResponse<String> jsonResponse = null;
		String s = "{\"user_id\":" + "\""+ user_id + "\"}";
		//System.out.println(s);
		try {
			//
			//get equipment by equipment 'id'
			//
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/equipments/book/"+equipment_id)
			.header("Content-Type", "application/json")
			.body(s)
			.asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResponse.getBody().toString();
		
		/*if(jsonResponse.getStatus() == 200)
		{
			return "Success";
		}
		return "Failed to fetch the equipment";*/
	}
	public static ArrayList<ArrayList<Object>> get_equipment(String student_id)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			//
			//get equipment of a student by student 'id'
			//
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/equipments/student/"+student_id)
			.header("Content-Type", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Object> stringArray = new ArrayList<Object>();
	    JSONArray jsonArray = new JSONArray(jsonResponse.getBody().toString());
	    
	    //System.out.println(jsonArray);

	    for (int i = 0; i < jsonArray.length(); i++) 
	    {
	        stringArray.add(jsonArray.get(i));
	        //System.out.println(stringArray.get(i).getClass());
	    }
	    
	    ArrayList<ArrayList<Object>> requests = new ArrayList<ArrayList<Object>>();
	    for(int i=0;i<stringArray.size();i++)
	    {
	    	JsonObject jsonObject = new JsonParser().parse(stringArray.get(i).toString()).getAsJsonObject();
	    	ArrayList<Object> details = new ArrayList<Object>();
	    	details.add(jsonObject.get("id").getAsString());//.getAsString();
	    	details.add(jsonObject.get("name").getAsString());
	    	details.add(jsonObject.get("reserved").getAsString());
	    	details.add(jsonObject.get("status").getAsString());
	    	details.add(jsonObject.get("description").getAsString());
	    	requests.add(details);
	    }
	    //System.out.println(Requests);
	    return requests;
	}
	public static ArrayList<Object> equipment_report()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			//
			//get equipment report
			//
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report")
			.header("Content-Type", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
    	ArrayList<Object> Details = new ArrayList<Object>();
    	//values to the keys are added. Needed to be changed
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
		HttpResponse<JsonNode> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(equipment);
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/equipments")
			.header("Content-Type", "application/json")
			.body(json)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(jsonResponse.getStatus() == 200)
		{
			return "Success";
		}
		return "Failed to add the equipment";
	}
	public static ArrayList<ArrayList<Object>> get_available_equipment()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			//
			//get equipment of a student by student 'id'
			//
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/equipments/available")
			.header("Content-Type", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Object> stringArray = new ArrayList<Object>();
	    JSONArray jsonArray = new JSONArray(jsonResponse.getBody().toString());
	    
	    //System.out.println(jsonArray);

	    for (int i = 0; i < jsonArray.length(); i++) 
	    {
	        stringArray.add(jsonArray.get(i));
	        //System.out.println(stringArray.get(i).getClass());
	    }
	    
	    ArrayList<ArrayList<Object>> requests = new ArrayList<ArrayList<Object>>();
	    for(int i=0;i<stringArray.size();i++)
	    {
	    	JsonObject jsonObject = new JsonParser().parse(stringArray.get(i).toString()).getAsJsonObject();
	    	ArrayList<Object> details = new ArrayList<Object>();
	    	details.add(jsonObject.get("id").getAsString());//.getAsString();
	    	details.add(jsonObject.get("name").getAsString());
	    	details.add(jsonObject.get("reserved").getAsString());
	    	details.add(jsonObject.get("status").getAsString());
	    	details.add(jsonObject.get("description").getAsString());
	    	requests.add(details);
	    }
	    //System.out.println(Requests);
	    return requests;
	}
}