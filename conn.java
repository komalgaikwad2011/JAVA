package komal1;

import java.sql.*;

public class conn {

	public static void main(String[] args) 
	{
		try
		{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu");
		
		PreparedStatement smt;
		String q="create table student1(id int,name varchar(20))";
		smt=con.prepareStatement(q);
		smt.executeUpdate();
		System.out.println("table create");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
