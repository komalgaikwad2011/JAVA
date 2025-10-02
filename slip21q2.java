package komal;

class product extends Thread
{
	boolean chance=false;
	synchronized void produce(int i)throws InterruptedException
	{
		if(chance)
		{
			wait();
		}
		chance=true;
		notify();
		System.out.println("produced "+i+" item");
	}
	synchronized void consume(int i)throws InterruptedException
	{
		if(!chance)
		{
			wait();
		}
		chance=false;
		notify();
		System.out.println("consumed "+i+" item");
	}
}
class producer extends Thread
{
	product p;
	public producer(product p)
	{
		this.p=p;
	}
	public void run()
	{
		for(int i=1;i<=5;i++)
		try
		{
			p.produce(i);
			
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
class consumer extends Thread
{
	product p;
	public consumer(product p)
	{
		this.p=p;
	}
	public void run()
	{
		for(int i=1;i<=5;i++)
		try
		{
			p.consume(i);
		}catch(InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
public class slip21q2 
{

	public static void main(String[] args) 
	{
		product p=new product();
		producer t1=new producer(p);
		consumer t2=new consumer(p);
		t1.start();
		t2.start();
	}

}
