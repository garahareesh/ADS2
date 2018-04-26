import java.util.*;
public class SuffixArrays
{
	Suffix[] suffixes;
	public SuffixArrays(String text)
	{
		this.suffixes=new Suffix[text.length()];
		for(int i=0;i<suffixes.length;i++)
		{
			suffixes[i]=new Suffix(text,i);
		}
		Arrays.sort(suffixes);
	}
	public int length()
	{
		return suffixes.length;
	}
	public int index(int i)
	{
		return suffixes[i].index;
	}
	public int lcp(int i)
	{
		return lcp(suffixes[i],suffixes[i-1]);
	}
	public int lcp(Suffix s,Suffix t)
	{
		int n=Math.min(s.length(),t.length());
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)!=t.charAt(i)) return i;
		}	
		return n;
	}
	public String select(int i)
	{
		return suffixes[i].toString();
	}
	public int rank(Suffix t)
	{
		int lo=0,hi=suffixes.length-1;
		while(hi>=lo)
		{
			int mid=lo+(hi-lo)/2;
			if(compare(suffixes[mid],t)<0)
			{
				lo=mid+1;
			} 
			else if(compare(suffixes[mid],t)>0)
			{
				hi=mid-1;
			}
			else
			{
				return mid;
			}
		}
		return lo;
	}
	public int compare(Suffix s,Suffix t)
	{
		int n=Math.min(s.length(),t.length());
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)<t.charAt(i)) return -1;
			if(s.charAt(i)>t.charAt(i)) return 1;
		}
		return s.length()-t.length();
	}
}
class Suffix implements Comparable<Suffix>{
	String s;
	int index;
	public Suffix(String s,int index)
	{
		this.s=s;
		this.index=index;
	}
	public int length()
	{
		return s.length()-index;
	}
	public int charAt(int d)
	{
		return s.charAt(index+d);
	}
	public int compareTo(Suffix t)
	{
		String s1=str();
		if(s1==t.toString()) return 0;
		int n=Math.min(s1.length(),t.length());
		for(int i=0;i<n;i++)
		{
			if(s1.charAt(i)<t.charAt(i)) return -1;
			if(s1.charAt(i)>t.charAt(i)) return 1;
		}
		return s1.length()-t.length();
	}
	public String toString()
	{
		return s.substring(index);
	}
	public String str()
	{
		return s.substring(index);	
	}
}