
public class Palindromesub {

	public static void main(String args[])
	{
		String x = "forgeeksskeegfor";
		Node start = new Node(0);
		int len = max(x, start );
		for(int i = start.val; i< start.val + len; i++ )
			System.out.print(x.charAt(i));
	}
	
	public static int max(String x, Node start)
	{
		int maxlength = 0;
		int low, high;
		for(int i  = 1; i< x.length(); i++)
		{
			low = i -1;
			high = i;
			while(low >= 0 && high < x.length() && x.charAt(low) == x.charAt(high))
			{
				if(high - low + 1 > maxlength)
				{
					start.val = low;
					maxlength = high-low+1;
				}
				low--;
				high++;
			}
			
			low = i - 1;
			high = i + 1;
			while(low >= 0 && high < x.length() && x.charAt(low) == x.charAt(high))
			{
				if(high - low + 1 > maxlength)
				{
					start.val = low;
					maxlength = high-low+1;
				}
				low--;
				high++;
			}
		}
		return maxlength;
	}
}
