package com.geartracker.Application;

import java.util.Map;

import com.geartracker.Application.DTO.User;
import com.google.gson.JsonObject;

public class UserHttpClientTest
{
	public static void main(String[] args)
	{
		login_test("admin1", "admin1");
		// show_user_test("admin1");
	}
	public static void login_test(String user_name, String password)
	{
		JsonObject J = UserHttpClient.login(user_name, password);
		//JsonObject J = UserHttpClient.login(user_name, password);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
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
		String J = UserHttpClient.edit_user(user);
		//JsonObject J = UserHttpClient.login(user_name, password);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void show_user_test(String user_id)
	{
		JsonObject J = UserHttpClient.show_user(user_id);
		//JsonObject J = UserHttpClient.login(user_name, password);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}