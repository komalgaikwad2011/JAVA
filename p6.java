package komal;

import java.util.*;

public class p6 
{

	public static void main(String[] args) 
	{
		HashMap h=new HashMap();
		h.put("ccc",11);
		h.put("bbb",22);
		h.put("aaa",33);
		System.out.println(h);
		TreeMap t=new TreeMap(h);
		System.out.println(t);


	}

}
