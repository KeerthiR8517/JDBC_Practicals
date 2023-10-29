import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Record {

	public static void main(String[] args) {
		int eno,salary;
		String ename,dept;
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter emp no");
		  eno=sc.nextInt();
		  System.out.println("Enter emp name");
		  ename=sc.next();
		  System.out.println("Enter dept");
		  dept=sc.next();
		  System.out.println("enter salary");
		  salary=sc.nextInt();
		  
		  try
		  {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","1234");
		 
			  String sql="insert into emp2 values(?,?,?,?)";
			  PreparedStatement pst = connection.prepareStatement(sql);
			  pst.setInt(1, eno);
			  pst.setString(4, ename);
			  pst.setString(3, dept);
			  System.out.println("Record added..");
			  connection.close();
		  
		  }
		  catch(ClassNotFoundException e)
		  {
			  System.out.println("Driver not found..");
			  
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }

	 }

}




//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//class Delete_Record{
//	
//	
//	public static void main(String[] args) {
//		int eno,salary;
//		String ename,dept;
//		Scanner sc=new Scanner(System.in);
//	
//		System.out.println("Enter emp no");
//		  eno=sc.nextInt();
//		  System.out.println("Enter emp name");
//		  ename=sc.next();
//		  System.out.println("Enter dept");
//		  dept=sc.next();
//		  System.out.println("enter salary");
//		  salary=sc.nextInt();
//		  
//		  try
//		  {
//			  Class.forName("com.mysql.cj.jdbc.Driver");
//			  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","1234");
//		 
//			  String sql="update emp2 set salary=? where eno=?";
//			  PreparedStatement pst = connection.prepareStatement(sql);
//			  pst.setInt(1, salary);
//			  pst.setInt(2,eno);
//			  pst.executeUpdate();
//			  System.out.println("Record updated..");
//			  connection.close();
//		  
//		  }
//		  catch(ClassNotFoundException e)
//		  {
//			  System.out.println("Driver not found..");
//			  
//		  }
//		  catch(SQLException e)
//		  {
//			  System.out.println(e);
//		  }
//
//}
//}

