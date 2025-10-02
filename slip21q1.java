package komal;

import java.util.*;

public class slip21q1 
{

	public static void main(String[] args) 
	{
		LinkedList l=new LinkedList();
		int i,n;
		String name;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		n=sc.nextInt();
		System.out.println("enter "+n+" subject name:");
		for(i=0;i<n;i++)
		{
			name=sc.next();
			l.add(name);
		}
		Iterator<String> itr=l.iterator();
		while(itr.hasNext())
		{
		System.out.println(itr.next());
		}
	}

}
