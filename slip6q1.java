package komal;

import java.util.*;

public class slip6q1 
{

	public static void main(String[] args)
	{
		int no,n,number;
		TreeSet t=new TreeSet();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		n=sc.nextInt();
		System.out.println("enter "+n+" numbers");
		for(int i=0;i<n;i++)
		{
			no=sc.nextInt();
			t.add(no);
		}
		System.out.println(t);
		System.out.println("enter number to search:");
		number=sc.nextInt();
		if(t.contains(number))
		{
			System.out.println("found:"+number);
		}
		else
		{
			System.out.println("not found");
		}

	}

}
