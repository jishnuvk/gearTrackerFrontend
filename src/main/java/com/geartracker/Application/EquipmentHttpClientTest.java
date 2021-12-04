package com.geartracker.Application;

import java.util.ArrayList;
import java.util.Map;

public class EquipmentHttpClientTest 
{
	public static void main(String[] args)
	{
		book_equipment_test("F1", "stud1");
	}
	public static void book_equipment_test(String equipment_id, String user_id)
	{
		String J = EquipmentHttpClient.book_equipment(equipment_id, user_id);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void get_equipment_test(String student_id)
	{
		ArrayList<ArrayList<Object>> J = EquipmentHttpClient.get_equipment(student_id);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void equipment_report_test()
	{
		ArrayList<Object> J = EquipmentHttpClient.equipment_report();
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
	public static void add_equipment_test(Map<String, Object> equipment)
	{
		String J = EquipmentHttpClient.add_equipment(equipment);
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}