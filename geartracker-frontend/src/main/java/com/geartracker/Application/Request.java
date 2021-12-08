package com.geartracker.Application;

import java.io.*;
import java.util.*;

// import org.junit.Test;

// import static org.junit.Assert.assertEquals;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;

public class Request
{
	//@Test
	public static void main( String[] args )
	{
		Get_Post g = new Get_Post();
		String s = g.shouldReturnStatusOkay();
		//ObjectMapper objmap = new ObjectMapper();
		/*try {
	         JsonNode node = objmap.readValue(s, JsonNode.class);
	         JsonNode nameNode = node.get("hello");
	         String name = nameNode.asText();
	         System.out.println(name);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }*/
		System.out.println(s);
	}
}

//Get_Post is for testing purpose
class Get_Post
{
	public String shouldReturnStatusOkay()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://localhost:8080/geartracker-backend/webapi/equipments/F1")
			.header("Content-Type", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			jsonResponse = Unirest.put("http://localhost:8080/geartracker-backend/webapi/equipments/F1")
			  .header("Content-Type","application/json")
		      .body("{\n"
		      		+ "    \"description\": \"ShuttleCock is a very Popular game\",\n"
		      		+ "    \"id\": \"S1\",\n"
		      		+ "    \"name\": \"ShuttleCock\",\n"
		      		+ "    \"reserved\": false,\n"
		      		+ "    \"status\": \"available\"\n"
		      		+ "}")
		      .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//assertEquals(200, jsonResponse.getStatus());
		System.out.println(jsonResponse.getBody());
		//return jsonResponse.getBody().toString();
		return "string";
	}
}

class Login
{
	public void Send_credentials(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json").queryString("apikey", "123")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Issue_Equipment
{
	public void Send_list_of_available_equipments(ArrayList<String> s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json").queryString("apikey", "123")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Returning_Equipment
{
	public void Send_list_of_issued_equipments(ArrayList<String> s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_issued_equipments()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
	public void Send_equipment_to_delete_issued_list(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_delete_equipment()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Remove_Equipment_Application
{
	public void Send_list_of_equipments(ArrayList<String> s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_list_equipments()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
	public void Send_requested_equipment(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_requested_equipment()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
	public void Send_remove_request_equipment(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_remove_request_equipment()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Report_on_Equipment_Usage
{
	public void Send_equipment_usage_report(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_report()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Monitoring_Request
{
	public void Send_equipment_request(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_equipment_request()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Adding_Equipment_to_Application
{
	public void Send_add_equipment(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_add_equipment()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}

class Register_new_user
{
	public void Send_add_user(String s)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.post("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("Content-Type", "application/json")
			.body(s)
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(201, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
	}
	public String Send_status_add_user()
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
			.header("accept", "application/json")
			.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertEquals(200, jsonResponse.getStatus());
		//System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();
	}
}