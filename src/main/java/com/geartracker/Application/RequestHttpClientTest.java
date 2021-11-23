package com.geartracker.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;

public class RequestHttpClientTest 
{
	public static void main(String[] args)
	{
		/*Map<String, Object> user = new HashMap<String, Object>();
		user.put("email", "stud10@iiitb.ac.in");
		user.put("fine", 0);
		user.put("id", "stud10");
		user.put("name", "stud10");
		user.put("password", "password");
		user.put("roles", new ArrayList<String>(List.of("student")));
		user.put("sportsStatus", false);
		user.put("student", 1);*/
		close_request_test("3");
		//add_user_test(user);
		//JsonObject J = UserHttpClient.login("stud1", "password");
		//assert J.get("email").equals("stud1@iiitb.ac.in");
//		System.out.println(J);
	}
	public static void get_requests_student_test(String student_id)
	{
		ArrayList<ArrayList<Object>> J = RequestHttpClient.get_requests_student("stud1");
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void approve_request_test(String request_id)
	{
		String J = RequestHttpClient.approve_request(request_id);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void close_request_test(String request_id)
	{
		String J = RequestHttpClient.close_request(request_id);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}
