package com.geartracker.Application;

import java.util.ArrayList;

import com.google.gson.JsonObject;

public class RequestHttpClientTest 
{
	public static void main(String[] args)
	{
		get_requests_student_test("a");
	}
	public static void get_requests_student_test(String student_id)
	{
		ArrayList<ArrayList<Object>> J = RequestHttpClient.get_requests_student("stud1");
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void approve_request_test(int request_id)
	{
		String J = RequestHttpClient.approve_request(request_id);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void close_request_test(int request_id, String state)
	{
		String J = RequestHttpClient.close_request(request_id, state);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void report_request_count_test()
	{
		JsonObject J = RequestHttpClient.report_request_count();
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void report_fine_count_test()
	{
		String J = RequestHttpClient.report_fine_count();
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void report_requests_status_count_test(String status)
	{
		String J = RequestHttpClient.report_requests_status_count(status);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}
