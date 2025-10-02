package komal;

class abc4 extends Thread
{
	 synchronized public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
}
public class slip30q1 
{

	public static void main(String[] args) 
	{
		abc4 t=new abc4();
		t.start();
		abc4 t1=new abc4();
		t1.start();
		abc4 t2=new abc4();
		t2.start();
	}

}
