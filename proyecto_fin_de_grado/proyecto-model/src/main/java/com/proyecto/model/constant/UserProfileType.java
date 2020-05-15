package com.proyecto.model.constant;

public enum UserProfileType {
	USER("USER"),
	GESTOR("GESTOR"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}