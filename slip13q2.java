package komal;

import java.util.*;

public class slip13q2 extends Thread
{
	Random r;
	int a[],sum=0;
	Thread t;
	String name;
	static double total=0;
	slip13q2(String name)throws InterruptedException
	{
		t=new Thread(this);
		this.name=name;
		a=new int[10];
		r=new Random();
		for(int i=0;i<10;i++)
		{
			a[i]=r.nextInt(100);
		}
		t.start();
		t.join();
	}
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(name+" "+a[i]);
		}
		for(int i=0;i<10;i++)
		{
			sum=sum+a[i];
		}
		System.out.println(name+"sum:"+sum);
		total=total+sum;
	}
	public static void avg()
	{
		double avg=total/10;
		System.out.println("total:"+total);
		System.out.println("avg:"+avg);
	}
	public static void main(String[] args) throws InterruptedException
	{
		slip13q2 t1=new slip13q2("thread 1:");
		slip13q2 t2=new slip13q2("thread 2:");
		slip13q2 t3=new slip13q2("thread 3:");
		slip13q2 t4=new slip13q2("thread 4:");
		slip13q2 t5=new slip13q2("thread 5:");
		slip13q2 t6=new slip13q2("thread 6:");
		slip13q2 t7=new slip13q2("thread 7:");
		slip13q2 t8=new slip13q2("thread 8:");
		slip13q2 t9=new slip13q2("thread 9:");
		slip13q2 t10=new slip13q2("thread 10:");
		avg();
	}

}
