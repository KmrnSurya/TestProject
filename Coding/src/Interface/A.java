package Interface;

public interface A {
	
	void Ball() ;
	
    void Spider();
    
    default void Bat()
    {
    	System.out.println("Bat is unimplemented");
    }
    
    
    static int power(int a, int b)
    {
    	return (a*b)/100;
    }
}
