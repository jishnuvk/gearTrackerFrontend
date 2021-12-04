package com.geartracker.Application;

import java.util.ArrayList;

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
}
