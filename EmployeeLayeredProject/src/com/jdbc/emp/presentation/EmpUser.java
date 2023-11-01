package com.jdbc.emp.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jdbc.emp.dao.EmpDao;
import com.jdbc.emp.entity.Emp;

public  class EmpUser implements IEmpUser
{
Integer eno;
int salary;
String ename,dept;
Scanner sc=new Scanner(System.in);
EmpDao empDao=new EmpDao();

public void inputAddEmp()throws SQLException
{
	System.out.println("Enter emp no :");
	eno=sc.nextInt();
	System.out.println("Enter Ename");
	ename=sc.next();
	System.out.println("Enter Dept");
	dept=sc.next();
	System.out.println("Enter salary");
	salary=sc.nextInt();
	Emp emp=new Emp();
	emp.setEno(eno);
	emp.setSalary(salary);
	System.out.println(empDao.updateEmp(emp));
	 
}
public void inputDeleteEmp()throws SQLException
{
	System.out.println("Enter emp no :");
	eno=sc.nextInt();
	System.out.println(empDao.deleteEmp(eno));
	
}
public void inputUpdateEmp()throws SQLException
{
	System.out.println("enter emp no :");
	eno=sc.nextInt();
	Emp emp=empDao.findEmpByID(eno);
	if(emp==null) 
	{
	System.out.println("Employee with eno "+ eno +"not found");
	}
	else
	{
	System.out.println("Enter salary:");
	salary=sc.nextInt();
//	Emp emp=new Emp();
	emp.setEno(eno);
	emp.setEname(ename);
	emp.setDept(dept);
	emp.setSalary(salary);
	
	System.out.println(empDao.updateEmp(emp));	
}
}
public void InputfindEmpByID()throws SQLException
{
	System.out.println("Enter emp no :");
	eno=sc.nextInt();
	Emp emp=empDao.findEmpByID(eno);
	if(emp!=null)
	{
		System.out.println("eno\tEname\tDept\tSalary");
		System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDept()+"\t"+emp.getSalary());
	}
	else
	{
		System.out.println("  no record found..");
		
	}
	}
public void inputfindAllEmp()throws SQLException
{
	List<Emp>list=empDao.findAllEmp();
	if(list.size()>0)
	{
		System.out.println("Eno\tEname\tDept\tSalary");
		for(Emp emp:list)
		{
			System.out.println(emp.getEno()+"\t"+emp.getEname()+"\t"+emp.getDept()+"\t"+emp.getSalary());
			
		}
	}
	else
	{
		System.out.println("no record found...");
	}
  }
}
