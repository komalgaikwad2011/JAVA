package komal1;

import java.sql.*;

public class donar
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
	        DatabaseMetaData db=con.getMetaData();
	        PreparedStatement pmt = null;
	        String q="select * from donar";
	        ResultSet rs=pmt.executeQuery(q);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
