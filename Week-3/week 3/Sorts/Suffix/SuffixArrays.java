import java.util.*;
class SuffixArrays
{
	String[] suffixArr;
	String lcp="";
	public void SuffixArray(String s)
	{
		int n=s.length();
		suffixArr=new String[n];
		for(int i=0;i<n;i++)
		{
			suffixArr[i]=s.substring(i,n);
		}
		Arrays.sort(suffixArr);
		System.out.println(Arrays.toString(suffixArr));
		int lg=2;
		String result="";
		for(int i=1;i<n;i++)
		{
			int len=lcp(suffixArr[i],suffixArr[i-1]);
			if(len>=lg)
			{
				result=suffixArr[i].substring(0,len);
				lg=len;
			}
		}
		System.out.println("result:"+result);
		lcp=result;
	}
	public int lcp(String s,String s1)
	{
		int min=Math.min(s.length(),s1.length());
		for(int i=0;i<min;i++)
		{
			if(s.charAt(i)!=s1.charAt(i))
			{
				return i;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		String a="mississippi";
		SuffixArrays al=new SuffixArrays();
		
		al.SuffixArray(a);
	}
}