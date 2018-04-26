import java.util.*;
class LongestCommonSubString
{
	String[] a,b;
	LongestCommonSubString(String x,String y)
	{
		int x1=x.length();
		int y1=y.length();
		a=new String[x1];
		b=new String[y1];
		for(int i=0;i<x1;i++)
		{
			a[i]=x.substring(i,x1);
		}
		for(int i=0;i<y1;i++)
		{
			b[i]=y.substring(i,y1);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}
	public int lcp(String a,String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
			{
				return i;
			}
		}
		return min;
	}
	public String LongestCommonSubString()
	{
		String result="";
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				int len=lcp(a[i],b[j]);
				if(len>=result.length())
				{
					result=a[i].substring(0,len);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String a="sony";
		String b="sonysonyyyyy";
		LongestCommonSubString al=new LongestCommonSubString(a,b);
		
		 System.out.println(al.LongestCommonSubString());
	}
	
}