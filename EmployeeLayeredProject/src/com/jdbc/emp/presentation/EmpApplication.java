package com.jdbc.emp.presentation;

import java.sql.SQLException;
import java.util.Scanner;

public class EmpApplication {
	public static void main(String a[])
	{
		Scanner Sc=new Scanner(System.in);
		EmpUser empuser=new EmpUser();
		int choice=0;
		System.out.println("--------------------Employee Operations-------------------");
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Add Record");
		System.out.println("2.Delete Record");
		System.out.println("3.Update Record");
		System.out.println("4.Find Record by Emp id");
		System.out.println("5.Find all records");
		System.out.println("6.Exit Application");
		
		while(choice!=6)
		{
			System.out.println("Enter operation no:");
			choice= Sc.nextInt();
			try
			{
				switch(choice)
				{
				case 1: empuser.inputAddEmp();
				        break;
				case 2: empuser.inputDeleteEmp();
				        break;
				case 3: empuser.inputUpdateEmp();
				        break;
				case 4: empuser.InputfindEmpByID();
				        break;
				case 5: empuser.inputfindAllEmp();
				        break;
				case 6:System.out.println("User Quit Apllication...\n");
				       System.exit(0);
				       default:System.out.println("invalid operation..Try again");
				       
				}
			}
			catch(SQLException e)
			{
				System.out.println(e);
				
			}
			
		}
	}

}
