package komal;

import java.util.*;

public class slip29q2
{

	public static void main(String[] args) 
	{
		LinkedList l=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int n,i,no,ch;
		System.out.println("enter limit:");
		n=sc.nextInt();
		System.out.println("enter numbers");
		for(i=0;i<n;i++)
		{
			no=sc.nextInt();
			l.add(no);
		}
		
		do {
			System.out.println("1-add element at first pos\n2-del last ele\n3-display size\nenter choice:");
			 ch=sc.nextInt();
			switch(ch)
			{
			case 1:System.out.println("enter element to add:");
					int add=sc.nextInt();
				    l.addFirst(add);
				    System.out.println(l);
				 break;
			case 2:
			       System.out.println(l.removeLast());
				break;
			case 3:System.out.println(l.size());
				break;
			}
			
		}while(ch!=4);
			
	}

}
