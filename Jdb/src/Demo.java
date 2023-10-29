import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {
	public static void main(String args[])
	{
		int eno;
		String name,dept;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter emp no:");
		eno=sc.nextInt();
		System.out.println("enter emp name:");
		name=sc.next();
		System.out.println("enter emp dept:");
		dept=sc.next();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver loaded....");
		    
		    
		    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdata","root","1234");
		    System.out.println("connection established...");
		    
		   // String sql="insert into emp2 values("+eno+" ,'"+name+"','"+dept+"')";
		   // String sql="alter table emp2 add dept varchar(10) not null";
		    String sql="alter table emp2 add salary varchar(10) not null";
		    Statement statement =connection.createStatement();
		   // statement.executeUpdate("create table emp2(eno int,name varchar(20)");
		   statement.executeUpdate(sql);
		    System.out.println("record inserted..");
		    
		    connection.close();
		} 
		
		
		catch (ClassNotFoundException e) 
		{
			System.out.println("driver not found");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}

