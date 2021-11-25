package com.geartracker.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentHttpClientTest 
{
	public static void main(String[] args)
	{
		/*Map<String, Object> equipment = new HashMap<String, Object>();
		equipment.put("reserved", false);
		equipment.put("status", "vacant");
		equipment.put("id", "e2");
		equipment.put("name", "e2");R
		
		add_equipment_test(equipment);*/
		//get_equipment_test("stud1");
		get_available_equipment_test();
		
		//add_user_test(user);
		//JsonObject J = UserHttpClient.login("stud1", "password");
		//assert J.get("email").equals("stud1@iiitb.ac.in");
//		System.out.println(J);
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
	public static void get_available_equipment_test()
	{
		ArrayList<ArrayList<Object>> J = EquipmentHttpClient.get_available_equipment();
		//assert J.get("email").equals("stud1@iiitb.ac.in");
		System.out.println(J);
	}
}
