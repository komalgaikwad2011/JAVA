package komal;

class abc extends Thread
{
	public void run()
	{
		for(char i='a';i<='z';i++)
		{
			try
			{
			System.out.println(i);
			Thread.sleep(2000);
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
}
public class slip1q1 
{

	public static void main(String[] args) 
	{
		abc a=new abc();
		a.start();

	}

}
