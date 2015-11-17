public class Permutations {

	public static void main(String args[])
	{
		char[] x = {'a', 'b', 'c'};
		permutate(x, 0, x.length-1);
	}
	
	public static void permutate(char[] x, int l, int r)
	{
		int i;
		if( l == r)
			System.out.println(x);
		else
		{
			for(i = l; i<= r; i++)
			{
				char temp = x[l];
				x[l] = x[i];
				x[i] = temp;
				permutate(x, l+1, r);
				temp = x[l];
				x[l] = x[i];
				x[i] = temp;		
			}
		}
	}	
}
