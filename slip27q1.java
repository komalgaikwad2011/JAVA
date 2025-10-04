package komal1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class slip27q1 extends JFrame
{
	slip27q1()
	{
		setSize(400,400);
		setVisible(true);
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con;
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/komal","postgres","tanu123");
	       PreparedStatement pmt;
	      String q="select * from college";
	      pmt=con.prepareStatement(q);
	      ResultSet rs=pmt.executeQuery();
	      String[] names= {"id","name","addr","year"};
	      DefaultTableModel model=new DefaultTableModel(names,0);
	      while(rs.next())
	      {
	    	  model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)});
	      }
	      JTable table=new JTable(model);
	      JScrollPane pane=new JScrollPane(table);
	      add(pane);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
	new slip27q1();
	}

}
