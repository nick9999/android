import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
public class Array
{
	public static void main(String[] args)
	{
		ArrayList one;
		one= new ArrayList();
		ArrayList two;
		two= new ArrayList();
		ArrayList<String> names=new ArrayList<String>();
		names.add("james");
		names.add("zoe"); 
		names.add(2,"nikhil");
		for(int i=0;i<names.size();i++)
		{
			System.out.println(names.get(i));
		}
		Iterator i=names.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		
		
	}
}