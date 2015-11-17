public class Checkstrings {

	public static void main(String args[])
	{
		String s = "acbbaca";
		String t = "aba";
		System.out.print(check(s,t,new Node(0), new Node(0)));
	}
	
	public static int check(String s, String txt, Node min, Node max)
	{
		int[] needtofind = new int[256];
		int[] hasfound = new int[256];
		int len = 0;
		for(int i = 0; i< txt.length(); i++)
			needtofind[txt.charAt(i)]++;
		int count = 0;
		int minlen = 1000;
		for(int begin = 0, end = 0; end< s.length(); end++)
		{
			if(needtofind[s.charAt(end)] == 0)
				continue;
			else
			{
				if(hasfound[s.charAt(end)] < needtofind[s.charAt(end)])
					count++;
				hasfound[s.charAt(end)]++;
			}
			if(count == txt.length())
			{
				while(needtofind[s.charAt(begin)] == 0 || hasfound[s.charAt(begin)] > needtofind[s.charAt(begin)])
				{
					if(hasfound[s.charAt(begin)] > needtofind[s.charAt(begin)])
						hasfound[s.charAt(begin)]--;
					begin++;
				}
				len = end - begin +1;
				if( len < minlen)
				{
					min.val = begin;
					max.val = end;
					minlen = len;
				}
			}
		}
		return (minlen);
	}
	
}
