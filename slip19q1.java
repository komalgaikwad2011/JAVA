package komal;

import java.util.*;

public class slip19q1
{

	public static void main(String[] args) 
	{
		LinkedList l1=new LinkedList();
		int n,i,no;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		n=sc.nextInt();
		System.out.println("enter values:");
		for(i=0;i<n;i++)
		{
			no=sc.nextInt();
			l1.add(no);
		}
		for(i=0;i<n;i++)
		{
			int val=(int) l1.get(i);
		if(val<0)
		{
		System.out.println(val);
		}
		}
	}

}
