package com.geartracker.Application;

import java.io.*;
import java.util.*;

import org.json.JSONArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;

public class RequestHttpClient
{
	public static ArrayList<ArrayList<Object>> get_requests_student(String student_id)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			//
			//get requests made by 'id'
			//
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/requests/student/"+student_id)
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
	    	details.add(jsonObject.get("requestId").getAsString());//.getAsString();
	    	details.add(jsonObject.get("equipmentId").getAsString());
	    	details.add(jsonObject.get("userId").getAsString());
	    	details.add(jsonObject.get("status").getAsString());
	    	details.add(jsonObject.get("issueDate").getAsString());
	    	details.add(jsonObject.get("returnDate").getAsString());
	    	requests.add(details);
	    }
	    //System.out.println(Requests);
	    return requests;
	}
	public static String approve_request(String request_id)
	{
		HttpResponse<String> jsonResponse = null;
		try {
			//
			//approve request
			//
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/approve/"+request_id)
			.header("Content-Type", "application/json")
			.asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResponse.getBody().toString();
		
		/*if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Updated";
		}
		return "Error in Update. Please try again";*/
	}
	public static String close_request(String request_id)
	{
		HttpResponse<String> jsonResponse = null;
		try {
			//
			//delete the 'request'
			//
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/close/"+request_id)
			.header("Content-Type", "application/json")
			.asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResponse.getBody().toString();
		
		/*if(jsonResponse.getStatus() == 200)
		{
			return "Successfully Closed";
		}
		return "Error in closing. Please try again";*/
	}
}