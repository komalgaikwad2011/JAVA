package komal1;

import java.sql.*;
import java.util.*;

public class proj 
{
	public static void main(String[] args) 
	{
		int ch,pid,price;
		String name;
		Scanner sc=new Scanner(System.in);
		PreparedStatement pmt;
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
			do
			{
				System.out.println("1-create table\n2-insert\n3-display\nenter choice:");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:String q1="create table project(pid int,name varchar(20),price int)";
					Statement st=con.createStatement();
					st.executeUpdate(q1);
					System.out.println("table created");
					break;
				case 2:String q2="insert into project values(?,?,?)";
				      pmt=con.prepareStatement(q2);
				      System.out.println("enter pid,name and price:");
				      for(int i=0;i<5;i++)
				      {
				      pid=sc.nextInt();
				      name=sc.next();
				      price=sc.nextInt();
				      
				      pmt.setInt(1,pid);
				      pmt.setString(2,name);
				      pmt.setInt(3,price);
				      pmt.executeUpdate();
				      }
				      System.out.println("record inserted");
					break;
				case 3:String q3="select * from project";
					pmt=con.prepareStatement(q3);
					ResultSet rs=pmt.executeQuery();
					System.out.println("pid\tpname\tprice");
					System.out.println("-----------------");
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
