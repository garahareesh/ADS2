import java.util.*;
class SuffixArray
{
	static String[] suffixes;
	static String lcp="";
	public static void suffixes(String s)
	{
		int n=s.length();
		suffixes=new String[n];
		for(int i=0;i<n;i++){
			suffixes[i]=s.substring(i,n);
		}
		Arrays.sort(suffixes);
		int lg=2;
		String result="";
		System.out.println(Arrays.toString(suffixes));
		for(int i=1;i<n;i++)
		{
			int len=lcp(suffixes[i],suffixes[i-1]);
			if(len>=lg)
			{
				result=suffixes[i].substring(0,len);
				lg=len;
			}
		}
		System.out.println(result);
		lcp=result;
	}
	public static int lcp(String a,String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				return i;
		}
		return min;
	}
	public static void main(String[] args) {
		String s="mississippi";
		SuffixArray one=new SuffixArray();
		one.suffixes(s);
		
	}

	
}