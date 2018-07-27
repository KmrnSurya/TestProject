package Interface;

public class C implements A,B{

	
	public static void main(String[] args) 
	{
		
		
		
		
		A n = new C();
		n.Spider();
		n.Ball();
		n.Bat();
		int c = A.power(10, 50);
		System.out.println(c);
		
	}

	@Override
	public void Ball() 
	{
		
		System.out.println("Ball_A");
	}

	@Override
	public void Ant() {
		System.out.println("InterFace B");
		
	}

	@Override
	public void Spider() {
		System.out.println("InterFace A");
		
	}
	
	
	
	
	

}
