package packageTwo;
import packageOne.parent;	
public class child extends parent
{
	public void testMethod()
	{
		System.out.println("name is : " + name);
	}
	
	public static void main(String[] args)
	{
		child n = new child();
		n.testMethod();
	}
}