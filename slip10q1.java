package komal;
class abc3 extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
}
public class slip10q1 
{

	public static void main(String[] args) 
	{
		abc3 t=new abc3();
		t.start();
		abc3 t1=new abc3();
		t1.start();
		abc3 t2=new abc3();
		t2.start();
	}

}
