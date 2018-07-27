package Hashset;

import java.util.HashSet;
import java.util.Set;

public class Example1 {

	public static void main(String[] args) {
		
	HashSet<Customer> set = new HashSet<Customer>();
	Customer obj1 = new Customer("Kumaran",28,50000,"Area1");
	Customer obj2 = new Customer("Arya",28,50000,"Area1");
	Customer obj3 = new Customer("Surya",28,50000,"Area1");
	Customer obj4 = new Customer("Raja",8,50000,"Area1");
	
	set.add(obj1);
	set.add(obj2);
	set.add(obj3);
	set.add(obj4);
	
	for(Customer c:set)
	{
		System.out.println(c.name+" "+c.age+" "+c.money+" "+c.area);
	}
	
	}
	
}
