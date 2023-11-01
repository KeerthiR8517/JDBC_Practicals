package com.jdbc.emp.presentation;

import java.sql.SQLException;

public interface IEmpUser {
	public void inputAddEmp()throws SQLException;
	 public void inputDeleteEmp()throws SQLException;
	 public void inputUpdateEmp()throws SQLException;
	 public void InputfindEmpByID()throws SQLException; 
	 public void inputfindAllEmp()throws SQLException;
	

}
