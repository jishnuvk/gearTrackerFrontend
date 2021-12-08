package com.geartracker.Application;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RequestHttpClient
{
	public static ArrayList<ArrayList<Object>> get_requests_student(String student_id)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		String auth_token = UserHttpClient.get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/requests/student/"+student_id)
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		JsonParser parser = new JsonParser();

		JSONArray arr = jsonResponse.getBody().getArray();

		ArrayList<ArrayList<Object>> requests = new ArrayList<>();
		for(int i = 0; i < arr.length(); i++){

			JsonObject jsonObject = parser.parse(arr.getJSONObject(i).toString()).getAsJsonObject();
			ArrayList<Object> details = new ArrayList<Object>();
			details.add(jsonObject.get("requestId").getAsString());
			details.add(jsonObject.get("equipmentId").getAsString());
			details.add(jsonObject.get("status").getAsString());
			details.add(jsonObject.get("issueDate").getAsString());

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
		String auth_token = UserHttpClient.get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/approve/"+String.valueOf(request_id))
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return jsonResponse.getBody().toString();
	}
	public static String close_request(int request_id, String state)
	{	

		JSONObject obj = new JSONObject();
		obj.put("status", state);
		String auth_token = UserHttpClient.get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		HttpResponse<String> jsonResponse = null;
		try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/requests/close/"+String.valueOf(request_id))
			.header("Content-Type", "application/json")
			.header("auth-token", auth_token)
			.body(obj)
			.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return jsonResponse.getBody().toString();
	}
	public static JsonObject get_request(String request_id)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		String auth_token = UserHttpClient.get_auth_token("admin1","admin1");
		
		if(auth_token != "PpASbLPIcMWxtwST4gvFCQ==")
		{
			System.out.println("Unauthorised access!");
			return null;
		}
		
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/requests/"+String.valueOf(request_id))
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
		catch (NullPointerException e){
			return null;
		}
	}
}