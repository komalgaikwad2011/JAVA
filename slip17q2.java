package komal;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.*;

import javax.swing.*;

public class slip17q2 extends JFrame implements ActionListener,Runnable
{
	JButton b;
	int i,v;
	TextField tf;
	Thread t;
	slip17q2()
	{
		setSize(400,400);
		setVisible(true);
		
		tf=new TextField(10);
		add(tf);
		
		b=new JButton("start");
		add(b);
		b.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e)
	{
			t=new Thread(this);
			t.start();
	}
	public void run()
	{
		try
		{
			for(int i=0;i<=100;i++)
			{
			tf.setText(String.valueOf(i));
				Thread.sleep(2000);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) 
	{
		new slip17q2();
	}

}
