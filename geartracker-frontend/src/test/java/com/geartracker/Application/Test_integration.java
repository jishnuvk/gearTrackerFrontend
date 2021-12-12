package com.geartracker.Application;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

import com.geartracker.Application.DTO.User;
import com.google.gson.JsonObject;

public class Test_integration
{
	@Test
	public void login_test()
	{
		JsonObject J = UserHttpClient.login("admin1", "admin1");
		assertEquals(J.get("authToken").getAsString(), "PpASbLPIcMWxtwST4gvFCQ==");
	}
	@Test
	public void add_user_test()
	{
		UserHttpClient.login("admin1", "admin1");
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("email", "stud10@iiitb.ac.in");
		user.put("fine", "0");
		user.put("id", "stud10");
		user.put("name", "stud10");
		user.put("password", "stud10");
		user.put("roles", new ArrayList<String>(Arrays.asList("student")));
		user.put("sportsStatus", "false");
		user.put("student", "1");
		String J = UserHttpClient.add_user(user);
		assertEquals(J, "Successfully Added User");
	}
	@Test
	public void edit_user_test()
	{
		UserHttpClient.login("admin1", "admin1");
		User user = new User();
		user.setId("stud10");
		user.setEmail("stud10@iiitb.ac.in");
		user.setName("stud10");
		user.setStudent(1);
		user.add_roles("student");
		user.resetPassword("password");
		String J = UserHttpClient.edit_user(user);
		assertEquals(J, "Successfully Edited User");
	}
	@Test
	public void show_user_test()
	{
		UserHttpClient.login("admin1", "admin1");
		JsonObject J = UserHttpClient.show_user("admin1");
		assertEquals(J.get("id").getAsString(), "admin1");
	}
	@Test
	public void get_requests_student_test()
	{
		UserHttpClient.login("admin1", "admin1");
		ArrayList<ArrayList<Object>> J = RequestHttpClient.get_requests_student("stud1");
		assertEquals(Arrays.asList(J.get(0).toArray()), Arrays.asList(1, "CBT1", "open", "", ""));
		assertEquals(Arrays.asList(J.get(1).toArray()), Arrays.asList(2, "CBA1", "approved", "2021-11-01", ""));
	}
	@Test
	public void approve_request_test()
	{
		UserHttpClient.login("admin1", "admin1");
		String J = RequestHttpClient.approve_request(1);
		assertEquals(J, "success");
	}
	@Test
	public void close_request_test()
	{
		UserHttpClient.login("admin1", "admin1");
		String J = RequestHttpClient.close_request(1, "available");
		assertEquals(J, "success");
	}
	@Test
	public void get_request_test()
	{
		UserHttpClient.login("admin1", "admin1");
		JsonObject J = RequestHttpClient.get_request("1");
		assertEquals(J.get("equipmentId").getAsString(), "CBT1");
		assertEquals(J.get("userId").getAsString(), "stud1");
	}
	@Test
	public void report_request_count_test()
	{
		UserHttpClient.login("admin1", "admin1");
		JsonObject J = RequestHttpClient.report_request_count();
		assertEquals(J.get("Cricket").getAsString(), "1");
		assertEquals(J.get("Table_Tennis").getAsString(), "1");
		assertEquals(J.get("Badminton").getAsString(), "3");
		assertEquals(J.get("Football").getAsString(), "2");
	}
	@Test
	public void report_request_count_test2()
	{
		UserHttpClient.login("admin1", "admin1");
		Map<String, Object> dates = new HashMap<String, Object>();
		dates.put("startDate", "2021-12-08");
		dates.put("endDate", "2021-12-10");
		JsonObject J = RequestHttpClient.report_request_count(dates);
		assertEquals(J, new JsonObject());
	}
	@Test
	public void report_requests_status_count_test()
	{
		UserHttpClient.login("admin1", "admin1");
		String J = RequestHttpClient.report_requests_status_count("approved");
		assertEquals(J, "3");
	}
	@Test
	public void book_equipment_test()
	{
		UserHttpClient.login("admin1", "admin1");
		String J = EquipmentHttpClient.book_equipment("F1", "stud1");
		assertEquals(J, "success");
	}
	@Test
	public void get_equipment_test()
	{
		UserHttpClient.login("admin1", "admin1");
		ArrayList<ArrayList<Object>> J = EquipmentHttpClient.get_equipment("stud1");
		assertEquals(Arrays.asList(J.get(0).toArray()), Arrays.asList("CBA1", "Cricket", false, "issued", "Cricket is a very Popular game"));
	}
	@Test
	public void add_equipment_test()
	{
		UserHttpClient.login("admin1", "admin1");
		Map<String, Object> equipment = new HashMap<String, Object>();
		equipment.put("id", "S1");
		equipment.put("name", "ShuttleCock");
		equipment.put("reserved", false);
		equipment.put("status", "available");
		equipment.put("description", "ShuttleCock is a very Popular game");
		String J = EquipmentHttpClient.add_equipment(equipment);
		assertEquals(J, "Success");
	}
	@Test
	public void delete_eqipment_test()
	{
		UserHttpClient.login("admin1", "admin1");
		String J = EquipmentHttpClient.delete_equipment("S1");
		assertEquals(J, "success");
	}
	@Test
	public void show_equipment_acc_to_status_test()
	{
		UserHttpClient.login("admin1", "admin1");
		JsonObject J = EquipmentHttpClient.report_equipment_acc_to_status("lost");
		assertEquals(J.get("Table_Tennis").getAsString(), "1");
	}
	@Test
	public void show_equipment_acc_to_status_test2()
	{
		UserHttpClient.login("admin1", "admin1");
		Map<String, Object> dates = new HashMap<String, Object>();
		dates.put("startDate", "2021-12-09");
		dates.put("endDate", "2021-12-13");
		JsonObject J = EquipmentHttpClient.report_equipment_acc_to_status("lost", dates);
		assertEquals(J.get("Table_Tennis").getAsString(), "1");
	}
}