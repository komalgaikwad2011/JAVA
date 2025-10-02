package komal;

class abc1 extends Thread
{
	String name;
	int n;
	abc1(String name,int n)
	{
		this.name=name;
		this.n=n;
	}
	public void run()
	{
		for(int i=0;i<n;i++)
		{
		System.out.println(name);
		}
	}
}
public class slip8q1
{

	public static void main(String[] args)
	{
		abc1 t1=new abc1("covid 19",10);
		abc1 t2=new abc1("lockdown",20);
		abc1 t3=new abc1("vaccination",30);
		t1.start();
		t2.start();
		t3.start();
	}

}
