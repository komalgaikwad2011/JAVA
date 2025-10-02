package komal;

public class slip14q1 extends Thread
{ 
	public void run()
	{
	System.out.println("name:"+Thread.currentThread().getName());
	System.out.println("priority:"+Thread.currentThread().getPriority());
	}

	public static void main(String[] args) 
	{
		slip14q1 t1=new slip14q1();
		t1.start();
	}

}
