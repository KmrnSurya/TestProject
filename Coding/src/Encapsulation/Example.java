package Encapsulation;

public class Example {

	private int Age;

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}
	
	public static void main(String[] args) 
	{
		Example a = new Example();
		a.setAge(50);
		System.out.println(a.getAge());
		
	}
	
}
