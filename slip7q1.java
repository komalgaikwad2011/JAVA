package komal;

import java.util.*;

class th1 implements Runnable
{
	Random r;
	Thread t;
	int n;
	public th1()
	{
		t=new Thread(this);
		t.start();
	}
	public void run()
	{
		r=new Random();
		for(int i=1;i<=10;i++)
		{
			n=r.nextInt(20);
			if(n%2==0)
			{
				th2 t2=new th2(n);
				t=new Thread(t2);
				t.start();
			}
			else
			{
				th3 t3=new th3(n);
				t=new Thread(t3);
				t.start();
			}
			try
			{
				Thread.sleep(2000);
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
}
class th2 extends Thread
{
	int n;
	public th2(int n)
	{
		this.n=n;
	}
	public void run()
	{
		System.out.println("square of "+n+"="+Math.pow(n,2));
	}
}
class th3 extends Thread
{
	int n;
	public th3(int n)
	{
		this.n=n;
	}
	public void run()
	{
		System.out.println("cube of "+n+"="+Math.pow(n,3));
	}
}
public class slip7q1 
{
	public static void main(String[] args) 
	{
		th1 t=new th1();
	}

}
