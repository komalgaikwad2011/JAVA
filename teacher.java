package komal1;

import java.sql.*;
import java.util.*;
public class teacher 
{

	public static void main(String[] args)
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
	       PreparedStatement pmt;
			String q3="select * from teacher where sub=?";
	        pmt=con.prepareStatement(q3);
	        System.out.println("enter sub");
	       String s=sc.next();
	       pmt.setString(1, s);
	        ResultSet rs=pmt.executeQuery();
	        System.out.println("tid\tpname\tsub");
	        System.out.println("-----------------");
	          while(rs.next())
	          {
		       System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
	           }
		     }catch(Exception e)
		        {
		      	System.out.println(e);
		        }

	}

}
