package Hashset;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class Example {
	
			public static void main(String[] args) {
			
			Set<Object> set = new HashSet<Object>();
			set.add("test1");
			set.add("test2");
			set.add(45);
			set.add(true);
			set.add(18.19);
			
			Iterator<Object> itr = set.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		}


}


