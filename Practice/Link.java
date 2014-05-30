import java.util.Arrays;
import java.util.LinkedList;
public class Link
{
	public static void main(String[] args)
	{
		LinkedList ll1=new LinkedList();
		LinkedList<String> lls=new LinkedList<String>();
		 lls.add("Nikhil");
		 lls.add("Peter");
		 lls.addFirst("Jim");
		 lls.addLast("Sherlock");
		 System.out.println("Sherlock is at: "+ lls.indexOf("Sherlock"));
	}
}