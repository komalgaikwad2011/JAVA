package komal1;

import java.sql.*;
import java.util.*;

public class slip22q1 
{

	public static void main(String[] args)
	{
		try
		{
			int ch,id,sal;
			String name;
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
	       PreparedStatement pmt;
	       Scanner sc=new Scanner(System.in);
	       do {
	    	   System.out.println("1-insert\n2-update\n3-display\nenter choice:");
	    	    ch=sc.nextInt();
	    	   switch(ch)
	    	   {
	    	   case 1:String q="insert into emp1 values(?,?,?)";
	    	   			pmt=con.prepareStatement(q);
	    	   			System.out.println("enter id,name and sal");
	    	   			id=sc.nextInt();
	    	   			name=sc.next();
	    	   			sal=sc.nextInt();
	    	   			pmt.setInt(1,id);
	    	   			pmt.setString(2,name);
	    	   			pmt.setInt(3, sal);
	    	   			pmt.executeUpdate();
	    	   			System.out.println("record inserted");
	    	   			break;
	    	   case 2:String q1="update emp1 set sal=? where id=?";
	    	         pmt=con.prepareStatement(q1);
	    	         System.out.println("enter sal and id");
	    	         sal=sc.nextInt();
	    	         id=sc.nextInt();
	    	         pmt.setInt(1,sal);
	    	         pmt.setInt(2, id);
	    	         pmt.executeUpdate();
	    	         System.out.println("table update");
	    		   break;
	    	   case 3:String q2="select * from emp1";
	    	   		pmt=con.prepareStatement(q2);
	    	   		ResultSet rs=pmt.executeQuery();
	    	   		while(rs.next())
	    	   		{
	    	   			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
	    	   		}
	    		   break;
	    	   }
	       }while(ch!=4);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
