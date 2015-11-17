
public class Permutations2 {

	public static void main(String args[])
	{
		String x = "ABCD";
		print(x);
	}
	
	public static void print( String str )
	{
		char[] S = str.toCharArray();
		qsort(S,0,S.length-1);
		int n = S.length;
		boolean done = false;
		while(!done)
		{
			str = String.valueOf(S);
			System.out.println(str);
			int i;
			for( i = n-1; i>0; i--)
			{
				if(S[i-1] < S[i])
					break;
			}
			if( i-1 < 0)
				done = true;
			else
			{
				int c = ceil(S,i-1);
				char temp = S[i-1];
				S[i-1] = S[c];
				S[c] = temp;
				reverse(S, i, n-1);
			}
			
				
		}
	}
	
	public static void reverse(char[] S, int l, int r)
	{
		while(l<r)
		{
			char temp = S[l];
			S[l] = S[r];
			S[r] = temp;
			l++;
			r--;
		}
	}
	
	public static int ceil(char[] S, int i)
	{
		int index = -1;
		char min = 'Z';
		for(int j = i+1; j<S.length; j++)
		{
			if(S[j] > S[i] && S[j] < min) 
			{
				min = S[j];
				index = j;
			}
		}
		return index;
	}
	
	public static void qsort(char[] S, int l, int r)
	{
		if(l<r)
		{
			int pivot = getpivot(S, l ,r);
			qsort(S,l,pivot-1);
			qsort(S,pivot+1,r);
		}
	}
	
	public static int getpivot(char[] S, int l , int r)
	{
		int x = S[r];
		int i = l;
		for(int j = l; j<r; j++)
		{
			if(S[j] < x)
			{
				char temp = S[i];
				S[i] = S[j];
				S[j] = temp;
				i++;
			}
		}
		char temp2 = S[i];
		S[i] = S[r];
		S[r] = temp2;
		return i;
	}
}
