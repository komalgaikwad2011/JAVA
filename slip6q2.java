package komal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;

public class slip6q2 extends JFrame implements ActionListener,Runnable
{
	JLabel l1,l2;
	Thread t;
	JRadioButton b1,b2,b3;
	JButton start;
	ButtonGroup group;
	JPanel panel;
	boolean running=true;
	 slip6q2()
	{
		 t=new Thread(this);
		setSize(400,400);
		setVisible(true);
		l1=new JLabel("traffic light",SwingConstants.CENTER);
		l1.setFont(new Font("Arial",Font.BOLD,40));
		add(l1,BorderLayout.NORTH);
		l2=new JLabel(" ",SwingConstants.CENTER);
		l1.setFont(new Font("Arial",Font.BOLD,40));
		add(l2);
		
		b1=new JRadioButton("red");
		b1.setForeground(Color.red);
		b2=new JRadioButton("yellow");
		b2.setForeground(Color.yellow);
		b3=new JRadioButton("green");
		b3.setForeground(Color.green);
		group=new ButtonGroup();
		group.add(b1);
		group.add(b2);
		group.add(b3);
		start=new JButton("start");
		panel=new JPanel();
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(start);
		add(panel,BorderLayout.SOUTH);
		start.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ee)
	{
		if(ee.getSource()==start)
		{
			t.start();
		}
	}
	public void run()
	{
		try
		{
			while(running)
			{
				b1.setSelected(true);
				if(b1.isSelected())
				{
					l2.setText("stop");
					l2.setForeground(Color.red);
				}
				Thread.sleep(1000);
				b2.setSelected(true);
				if(b2.isSelected())
				{
					l2.setText("ready");
					l2.setForeground(Color.yellow);
				}
				Thread.sleep(1000);
				b3.setSelected(true);
				if(b3.isSelected())
				{
					l2.setText("go");
					l2.setForeground(Color.green);
				}
				Thread.sleep(1000);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		new slip6q2();

	}

}
