
public class WordBreak {

	public static void main(String args[])
	{
		System.out.println(DPapproach("ilike"));
		System.out.println(DPapproach("iicecream"));
		System.out.println(DPapproach("ilikelikeimangoiii"));
		System.out.println(DPapproach("sams"));
	}
	
	public static boolean dictcontains(String word)
	{
		String[] dic = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
		for( int i  = 0 ; i< dic.length; i++)
		{
			if(dic[i].compareTo(word) == 0)
				return true;
		}
		return false;
	}
	
	public static boolean check(String word)
	{
		if( word.length() == 0)
			return true;
		for ( int i = 1; i<= word.length(); i++)
		{
			if(dictcontains(word.substring(0, i)) && check(word.substring(i, word.length()))) 
				return true;
		}
		return false;
	}
	
	public static boolean DPapproach(String word)
	{
		if(word.length() == 0)
			return true;
		boolean[] wb = new boolean[word.length() + 1];
		int size = word.length();
		for( int i = 1; i <= word.length(); i++)
		{
			if( wb[i] == false && dictcontains(word.substring(0,i)))
				wb[i] = true;
			if(wb[i] == true)
			{
				if( i == size)
					return true;
				for( int j = i +1; j<= size; j++)
				{
					if(wb[j] == false && dictcontains(word.substring(i,j)))
						wb[j] = true;
					if( j == size && wb[j])
						return true;
				}
			}
		}
		return false;
	}
	
}
