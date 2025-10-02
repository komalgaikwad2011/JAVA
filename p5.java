package komal;

import java.util.*;

public class p5 
{

	public static void main(String[] args) 
	{
		TreeSet t=new TreeSet();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter limit:");
		int n=sc.nextInt();
		System.out.println("enter "+n+" numbers:");
		for(int i=0;i<n;i++)
		{
			int no=sc.nextInt();
			t.add(no);
		}
		System.out.println(t);

	}

}
