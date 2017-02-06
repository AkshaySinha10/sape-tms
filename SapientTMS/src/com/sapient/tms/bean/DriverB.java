package com.sapient.tms.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

//import java.io.Serializable;

public class DriverB extends Vehicle//implements Serializable
{
	private int id;
	private String name;
	private int phone;
	public DriverB(int id,String password,String name,int phone,int v_id)
	{	super(password,v_id);
		id=this.id;
		name=this.name;
		phone=this.phone;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}Connection connection = JDBCConnection.getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
	preparedStatement.setString(1, username);
	preparedStatement.execute();
	updateCount = preparedStatement.getUpdateCount();
	preparedStatement.close();
	connection.close();
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPhone()
	{
		return phone;
	}

}
