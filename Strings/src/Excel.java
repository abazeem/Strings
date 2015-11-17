
public class Excel {

	public static void main(String args[])
	{
		System.out.print(calc("BA"));
	}
	
	public static int calc(String str)
	{
		int n = str.length();
		double prod = 1;
		int sum = 0;
		for(int i = 0; i< n; i++)
		{
			int rev = n-1-i;
			int ch = str.charAt(i) - 64;
			prod = Math.pow(26,rev) * ch;
			sum += prod;
			prod = 1;
		}
		return sum;
	}
}
