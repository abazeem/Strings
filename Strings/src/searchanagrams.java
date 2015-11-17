
public class searchanagrams {

	public static void main(String args[])
	{
		String s = "BACDGABCDA";
		String x = "ABCD";
		search(s,x);
	}
	
	public static void print(String x, int l, int r)
	{
		char[] ch = x.toCharArray();
		for(int i = l; i<= r; i++)
			System.out.print(ch[i]);
		System.out.println();
	}
	
	public static void search(String str, String ana)
	{
		int[] needtofind = new int[256];
		int[] found = new int[256];
		for(int i = 0; i< ana.length(); i++)
		{
			needtofind[str.charAt(i)]++;
		}
		int len = ana.length();
		int count = 0;
		int begin = 0;
		for(int end = 0; end< str.length(); end++)
		{
			if(needtofind[str.charAt(end)] == 0)
				continue;
			else
			{
				found[str.charAt(end)]++;
				count++;
			}
			while( count == len )
			{
				if( end - begin +1 == len)
				{
					print(str, begin, end);
					found[str.charAt(begin)]--;
					count--;
					begin++;
				}
				else
				{
					if(needtofind[str.charAt(begin)] != 0)
					{
						found[str.charAt(begin)]--;
						count--;
					}
					begin++;
				}	
			}
				
		}
	}
}
