package com.sapient.tms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.bean.DriverB;

public class DriverImpl implements DriverDao{

	private static final String INSERT_QUERY = "INSERT INTO DRIVER(ID,PASSWORD,NAME,PHONE,V_ID) VALUES(?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_QUERY = "SELECT * FROM DRIVER";	
	private static final String SELECT_QUERY = "SELECT * FROM DRIVER WHERE ID = ?";
	private static final String DELETE_QUERY = "DELETE FROM DRIVER WHERE ID = ?";
	
	@Override
	public DriverB search(int id) throws IOException, ClassNotFoundException,
			SQLException {
		
		DriverB drive=null;
		//List<Customer> cList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
			int a = rs.getInt("ID");
			String b = rs.getString("PASSWORD");
			String c = rs.getString("NAME");
			int d = rs.getInt("PHONE");
			int e = rs.getInt("V_ID");
			drive = new DriverB(a,b,c,d,e);
			
		}
		return drive;
	}

	@Override
	public void insert(DriverB drive) throws IOException, ClassNotFoundException,
			SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, drive.getID());
		preparedStatement.setString(2, drive.getPassword());
		preparedStatement.setString(3, drive.getName());
		preparedStatement.setInt(4, drive.getPhone());
		preparedStatement.setString(5, drive.getVID());
		preparedStatement.execute();
		connection.close();
		
	}

	@Override
	public List<DriverB> displayAll() throws IOException,
			ClassNotFoundException, SQLException {
		List<DriverB> driveList = new ArrayList<>();
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){
			
			int a = rs.getInt("ID");
			String b = rs.getString("PASSWORD");
			String c = rs.getString("NAME");
			int d = rs.getInt("PHONE");
			int e = rs.getInt("V_ID");
			DriverB drive= new DriverB(a,b,c,d,e);
			driveList.add(drive);
		}
		return driveList;
	}
	@Override
	public void delete(int id) throws IOException, ClassNotFoundException,
			SQLException {
		Connection connection = JDBCConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	
	
}
