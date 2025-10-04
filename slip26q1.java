package komal1;

import java.sql.*;
import java.util.*;

public class slip26q1 
{

	public static void main(String[] args)
	{
		try
		{
			int id,sal;
			String name;
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
	       PreparedStatement pmt;
	       Scanner sc=new Scanner(System.in);
	    	   			
	    	   String q1="delete from emp1 where id=?";
	    	         pmt=con.prepareStatement(q1);
	    	         System.out.println("enter id");
	    	         id=sc.nextInt();
	    	         pmt.setInt(1, id);
	    	         pmt.executeUpdate();
	    	         System.out.println("delete emp");
	    		  
	    	   String q2="select * from emp1";
	    	   		pmt=con.prepareStatement(q2);
	    	   		ResultSet rs=pmt.executeQuery();
	    	   		while(rs.next())
	    	   		{
	    	   			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
	    	   		}
	    
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
