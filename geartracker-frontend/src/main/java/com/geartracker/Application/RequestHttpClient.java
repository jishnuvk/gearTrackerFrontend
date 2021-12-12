package com.geartracker.Application;

import static org.junit.Assert.assertNotEquals;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RequestHttpClient
{
	public static ArrayList<ArrayList<Object>> get_requests_student(String student_id)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/requests/student/"+student_id)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		JsonParser parser = new JsonParser();
		JSONArray arr = new JSONArray(jsonResponse.getBody());

		ArrayList<ArrayList<Object>> requests = new ArrayList<>();
		for(int i = 0; i < arr.length(); i++){

			JsonObject jsonObject = parser.parse(arr.getJSONObject(i).toString()).getAsJsonObject();
			ArrayList<Object> details = new ArrayList<Object>();
			details.add(jsonObject.get("requestId").getAsString());
			details.add(jsonObject.get("equipmentId").getAsString());
			details.add(jsonObject.get("status").getAsString());
			
			if(jsonObject.has("issueDate")){
				details.add(jsonObject.get("issueDate").getAsString());
			}
			else{
				details.add("");
			}

			if(jsonObject.has("returnDate")){
				details.add(jsonObject.get("returnDate").getAsString());
			}
			else{
				details.add("");
			}

			requests.add(details);
		}
	    return requests;
	}
	public static String approve_request(int request_id)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/approve/"+String.valueOf(request_id))
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		return jsonResponse.getBody().toString();
	}
	public static String close_request(int request_id, String state)
	{	

		JSONObject obj = new JSONObject();
		obj.put("status", state);
		
		HttpResponse<String> jsonResponse = null;
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/close/"+String.valueOf(request_id))
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.body(obj)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		return jsonResponse.getBody().toString();
	}
	public static JsonObject get_request(String request_id)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/requests/"+String.valueOf(request_id))
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static JsonObject report_request_count()
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report/requests")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static JsonObject report_request_count(Map<String, Object> dates)
	{
		HttpResponse<String> jsonResponse = null;
		Gson gson = new Gson(); 
		String json = gson.toJson(dates);
		
		try {
			jsonResponse = Unirest.post("http://localhost:8080/geartracker-backend/webapi/report/requests")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.body(json)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		try{
			JsonObject jsonObject = new JsonParser().parse(jsonResponse.getBody().toString()).getAsJsonObject();
			return jsonObject;
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static String report_total_requests_count()
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report/requests/aggregate")
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		try{
			return jsonResponse.getBody().toString();
		}
		catch (NullPointerException e){
			return null;
		}
	}
	public static String report_requests_status_count(String status)
	{
		HttpResponse<String> jsonResponse = null;
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/report/requests/"+status)
			.header("Content-Type", "application/json")
			.header("auth-token", UserHttpClient.auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		assertNotEquals("Unauthorised Error", jsonResponse.getStatus(), 401);
		
		try{
			return jsonResponse.getBody().toString();
		}
		catch (NullPointerException e){
			return null;
		}
	}
}