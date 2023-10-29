import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpApplication 
{
Connection connection;
PreparedStatement pst;
Statement statements;
ResultSet resultSet;
String ename,dept,sql;
Integer eno,salary;
static Scanner sc=new Scanner(System.in);
public EmpApplication() throws ClassNotFoundException,SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","1234");
}
  public void addRecord() throws SQLException
  {
	  System.out.println("Enter emp no");
	  eno=sc.nextInt();
	  System.out.println("Enter emp name");
	  ename=sc.next();
	  System.out.println("Enter dept");
	  dept=sc.next();
	  System.out.println("enter salary");
	  salary=sc.nextInt();
	  
	  sql="insert into emp2 values(?,?,?,?)";
	  pst=connection.prepareStatement(sql);
	  pst.setInt(1, eno);
	  pst.setString(2, ename);
	  pst.setString(3, dept);
	  pst.setInt(4,salary);
	  pst.executeUpdate();
	   
	  System.out.println("record added...");
  }
  public void deleteRecord() throws SQLException
  {
	  System.out.println("enter emp no:");
	  eno=sc.nextInt();
	  sql="delete from emp2 where eno=?";
	  pst=connection.prepareStatement(sql);
	  pst.setInt(1,eno);
	  if(pst.executeUpdate()>0)
	  {
		  System.out.println("record updated....");
	  }
	  else
	  {
		  System.out.println("emp do not exist...");
	  }
	  
  }
	  public void updateRecord() throws SQLException
	  {
		  System.out.println("enter emp no:");
		  eno=sc.nextInt();  
		  System.out.println("enter updated salary:");
		  salary=sc.nextInt();
		  sql="update emp2 set salary=? where eno=?";
		  pst=connection.prepareStatement(sql);
		  pst.setInt(1,salary);
		  pst.setInt(2,eno);
		  if(pst.executeUpdate()>0)
		  {
			  System.out.println("record updated....");
		  }
		  else
		  {
			  System.out.println("emp do not exist...");
		  }
	  }
	  public void findRecordById() throws SQLException
	  {
		  System.out.println("enter emp no:");
		  eno=sc.nextInt();
		  sql="select * from emp2 where eno=?";
		  pst=connection.prepareStatement(sql);
		  pst.setInt(1,eno);
		  resultSet=pst.executeQuery(); 
	  
	  if(resultSet.next())
	 {
		  System.out.println("eno\tname\tDept\t\tsalary");
		  System.out.println(".................................................");
		  System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t\t"+resultSet.getInt(4));
	 }
	  else
	  {
		  System.out.println("emp do not exist...");
		  
     }
  }
public static void main(String a[])
  {
	  int choice=0;
	  System.out.println("-----------Employee operation-------------");
	  System.out.println("------------------------------------------");
	  System.out.println("1.Add Record");
	  System.out.println("2.Delete Record");
	  System.out.println("3.update Record");
	  System.out.println("4.find Record By Emp id");
	  System.out.println("5.Exit application");
	  while (choice!=5)
	  {
		  System.out.println("enter operation no:");
		  choice=sc.nextInt();
		  try
		  {
			  EmpApplication empApp=new EmpApplication();
			  switch(choice)
			  {
			  case 1: empApp.addRecord();
			          break;
			  case 2: empApp.deleteRecord();
			          break;
			 case 3: empApp.updateRecord();
			         break;
			 case 4: empApp.findRecordById();
			         break;
			  case 5: System.out.println("user quit application...\n");
			          System.exit(0);
			     default: System.out.println("invalid operation....Try again");
			     
			  }
		  }
		  catch(ClassNotFoundException e)
		  {
			  System.out.println(e);
			  
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }
	  }
  }
}
	  
			  

	  
	  
	  
	  
 
