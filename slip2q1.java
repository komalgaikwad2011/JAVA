package komal;

import java.util.*;

public class slip2q1 
{

	public static void main(String[] args) 
	{
		HashSet h=new HashSet();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		int n=sc.nextInt();
		System.out.println("enter "+n+" friends name:");
		for(int i=0;i<n;i++)
		{
			String name=sc.next();
			h.add(name);
		}
		System.out.println(h);

	}

}
