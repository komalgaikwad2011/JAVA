package komal1;

import java.sql.*;

public class slip13q1
{

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
			DatabaseMetaData db=con.getMetaData();
			System.out.println("pname:"+db.getDatabaseProductName());
			System.out.println("pversion:"+db.getDatabaseProductVersion());
				System.out.println("driver name:"+db.getDriverName());
				System.out.println("driver version:"+db.getDriverVersion());
				ResultSet rs=db.getTables(null, null,"%", new String[] {"TABLE"});
						while(rs.next())
						{
							System.out.println(rs.getString("table_name"));
						}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
