package komal;

import java.util.*;

public class p2 
{

	public static void main(String[] args) 
	{
		LinkedList l=new LinkedList();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		int n=sc.nextInt();
		System.out.println("enter "+n+" names:");
		for(int i=0;i<n;i++)
		{
			String name=sc.next();
			l.add(name);
		}
		System.out.println(l);

	}

}
