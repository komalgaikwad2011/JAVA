package komal;

import java.util.*;

public class slip5q1 
{

	public static void main(String[] args) 
	{
		Hashtable<Integer,String> h=new Hashtable<>();
		h.put(111, "bbb");
		h.put(444, "aaa");
		h.put(222, "ccc");
		System.out.println(h);

		Enumeration<Integer> ee=h.keys();
		System.out.println("details:");
		while(ee.hasMoreElements())
		{
			Integer key=ee.nextElement();
			String value=h.get(key);
			System.out.println("key:"+key+"\tvalue:"+value);
		}
	}

}
