package com.geartracker.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geartracker.Application.DTO.User;
import com.google.gson.JsonObject;

public class UserHttpClientTest
{
	public static void main(String[] args)
	{
		// Map<String, Object> user = new HashMap<String, Object>();
		// user.put("email", "stud10@iiitb.ac.in");
		// user.put("fine", 0);
		// user.put("id", "stud10");
		// user.put("name", "stud10");
		// user.put("password", "password");
		// user.put("roles", new ArrayList<String>(List.of("student")));
		// user.put("sportsStatus", false);
		// user.put("student", 1);
		// add_user_test(user);
		//JsonObject J = UserHttpClient.login("stud1", "password");
		//assert J.get("email").equals("stud1@iiitb.ac.in");
//		System.out.println(J);

		login_test("a", "b");
	}
	public static void login_test(String user_name, String password)
	{
		JsonObject J = UserHttpClient.login("stud1", "password");
		//JsonObject J = UserHttpClient.login(user_name, password);
		assert J.get("email").equals("stud1@iiitb.ac.in");
	}
	public static void add_user_test(Map<String, Object> user)
	{
		String J = UserHttpClient.add_user(user);
		//JsonObject J = UserHttpClient.login(user_name, password);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void edit_user_test(User user)
	{
		String J = UserHttpClient.edit_user( user);
		//JsonObject J = UserHttpClient.login(user_name, password);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}