package com.jdbc.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.emp.entity.Emp;

public class EmpDao implements IEmpDao 
{
 Connection connection;
 PreparedStatement preparedStatement;
 String sql;
 ResultSet resultSet;
 public EmpDao()
 {
	 connection = MyConnection.getConnection();
	 
 }
 public String addEmp(Emp emp)throws SQLException
 {
	 sql="insert into emp2 values(?,?,?,?)";
	 preparedStatement=connection.prepareStatement(sql);
	 preparedStatement.setInt(1,emp.getEno());
	 preparedStatement.setString(2,emp.getEname());
	 preparedStatement.setString(3, emp.getDept());
	 preparedStatement.setInt(4, emp.getSalary());
	 preparedStatement.executeUpdate();
	 return "Record Added....";
	 
 }
 
 public String deleteEmp(Integer eno)throws SQLException
 {
	 sql="delete from emp2 where eno=?";
	 preparedStatement=connection.prepareStatement(sql);
	 preparedStatement.setInt(1,eno);
	 
	 if(preparedStatement.executeUpdate()>0)
	 {
		 return"record Deleted..";
	 }
	 else
	 {
		 return"Record not found";
		 
	 }
 }
 public String updateEmp(Emp emp)throws SQLException
 {
	 sql="update emp2 set salary=? where eno=?";
	 preparedStatement=connection.prepareStatement(sql);
	 preparedStatement.setInt(1,emp.getSalary());
	 preparedStatement.setInt(2,emp.getEno());
	 
	 if(preparedStatement.executeUpdate()>0)
	 {
		 return"Record Updated";
	 }
	 else
	 {
		 return "Record Not Found..";
		 
	 }	 
	 }
  public Emp findEmpByID(Integer eno)throws SQLException
  {
	  sql="select * from emp2 where eno=?";
	  preparedStatement=connection.prepareStatement(sql);
	  preparedStatement.setInt(1,eno);
	  resultSet=preparedStatement.executeQuery();
	   Emp emp=null;
	   if(resultSet.next())
	   {
		   emp=new Emp();
		   emp.setEno(resultSet.getInt(1));
		   emp.setEname(resultSet.getString(2));
		   emp.setDept(resultSet.getString(3));
		   emp.setEno(resultSet.getInt(4));
	   }
	   return emp;
	   
  }
  public List<Emp>findAllEmp()throws SQLException
  {
	  sql="select*from emp2";
	  preparedStatement=connection.prepareStatement(sql);
	  resultSet=preparedStatement.executeQuery();
	  Emp emp=null;
	  List<Emp>list=new ArrayList<Emp>();
	  while(resultSet.next())
	  {
		  emp=new Emp();
		  emp.setEno(resultSet.getInt(1));
		  emp.setEname(resultSet.getString(2));
		  emp.setDept(resultSet.getString(3));
		  emp.setSalary(resultSet.getInt(4));
		  list.add(emp);
		   
	  }
	  return list;
  }
}
 
 

