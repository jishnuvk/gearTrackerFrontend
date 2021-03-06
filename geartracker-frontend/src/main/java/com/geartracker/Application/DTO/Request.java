package com.geartracker.Application.DTO;


import java.time.LocalDate;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.DAYS;

public class Request {
	private int requestId;
	private String equipmentId;
	private int equipmentSurrId;
	private String userId;
	private int userSurrId;
	private String status;
	private String issueDate;
	private String returnDate = null;
	
//	Default constructor is needed for jersey POST request.
	public Request() {
		
	}

//	This constructor is used when request id is not needed(When creating a new request). 
	public Request(String equipmentId, int equipmentSurrId, String userId, int userSurrId, String status, String issueDate, String returnDate) {
		this.equipmentSurrId = equipmentSurrId;
		this.userSurrId = userSurrId;
		this.equipmentId = equipmentId;
		this.userId = userId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	
	public Request(int requestId, String equipmentId, int equipmentSurrId, String userId, int userSurrId, String status, String issueDate, String returnDate) {
		this.requestId = requestId;
		this.equipmentSurrId = equipmentSurrId;
		this.userSurrId = userSurrId;
		this.equipmentId = equipmentId;
		this.userId = userId;
		this.status = status;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	// Getter and setter functions. Can be modified or dropped if unnecessary
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEquipmentSurrId() {
		return equipmentSurrId;
	}

	public void setEquipmentSurrId(int equipmentSurrId) {
		this.equipmentSurrId = equipmentSurrId;
	}

	public int getUserSurrId() {
		return userSurrId;
	}

	public void setUserSurrId(int userSurrId) {
		this.userSurrId = userSurrId;
	}
	
	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getIssueDate(){
		return issueDate;
	}

	public void setIssueDate(String issueDate){
		this.issueDate = issueDate;
	}

	public String getReturnDate(){
		return returnDate;
	}

	public void setReturnDate(String returnDate){
		this.returnDate = returnDate;
	}

	// public long dateDiff(){
	// 	/*if(status.equalsIgnoreCase("Issued")){
	// 		return DAYS.between(issueDate, String.now());
	// 	}
	// 	else{
		
	// 		return DAYS.between(issueDate, returnDate);
	// 	}*/
	// 	return DAYS.between(issueDate, returnDate);
	// }

	//Didn't add email class yet and will add after APIs decided and we implement for others.
//	public static void main(String[] args){
//		Request req = new Request();
//		req.setIssueDate(LocalDate.now());
//		req.setStatus
//		req.setReturnDate(req.getIssueDate().plusDays(10));
//		System.out.println(req.dateDiff());
//		//User user1 = new User("x1","Hemanth", "password", "email@gmail.com");
//		//System.out.println(user1.getName() + " " + user1.getId() + " " + user1.getPassword() + " " + user1.getEmail());
//	}
}
