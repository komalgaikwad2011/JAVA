package komal;

import java.util.*;

public class slip4q2 
{

	public static void main(String[] args) 
	{
		Hashtable h=new Hashtable();
		h.put("bbb",11);
		h.put("aaa",33);
		h.put("ccc",22);
		System.out.println(h);
		h.remove("bbb");
		System.out.println(h);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter city to search:");
		String city=sc.next();
		if(h.containsKey(city))
		{
			System.out.println(h.get(city));
		}
		else
		{
			System.out.println("not found");
		}
		
	}

}
