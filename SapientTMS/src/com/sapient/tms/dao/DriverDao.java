package com.sapient.tms.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.sapient.tms.bean.DriverB;

public interface DriverDao {
	DriverB search(int id) throws IOException, ClassNotFoundException, SQLException;
	void insert(DriverB d) throws IOException, ClassNotFoundException, SQLException;
	List<DriverB> displayAll()throws IOException,ClassNotFoundException, SQLException;
	void delete(int id) throws IOException, ClassNotFoundException, SQLException;

}
