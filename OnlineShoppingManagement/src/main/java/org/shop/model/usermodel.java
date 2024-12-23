package org.shop.model;

public class usermodel {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private int id;
	private String role;
	private String password;
	
	public usermodel()
	{
		
	}
	public usermodel(int id,String name,String role,String password)
	{
		this.id=id;
		this.role=role;
		this.name=name;
		this.password=password;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
