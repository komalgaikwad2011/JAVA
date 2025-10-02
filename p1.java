package komal;

import java.util.*;

public class p1 
{

	public static void main(String[] args)
	{
		ArrayList a=new ArrayList();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		int n=sc.nextInt();
		System.out.println("enter "+n+" cities name:");
		for(int i=0;i<n;i++)
		{
			String name=sc.next();
			a.add(name);
		}
		System.out.println(a);
		a.clear();
		System.out.println(a);
	}

}
