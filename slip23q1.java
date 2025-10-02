package komal;

import java.util.Scanner;

public class slip23q1 extends Thread
{
	int num;
	Scanner sc=new Scanner(System.in);
	public void run()
	{
		System.out.println("enter string:");
		String name=sc.next();
		try
		{
			for(int i=0;i<name.length();i++)
			{
				char ch=name.charAt(i);
				if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				{
					System.out.println(ch+" ");
				}
			}
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) 
	{
		slip23q1 t=new slip23q1();
		t.start();
	}

}
