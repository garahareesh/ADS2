import java.util.*;
class Lcs{
	String x,y;
	String[] a,b;
	Lcs(String s1, String s2)
	{
		 x=s1;
		 y=s1;
		a=new String[s1.length()];
		b=new String[s2.length()];
		for(int i=0;i<a.length;i++)
			a[i]=s1.substring(i,s1.length());
		for(int i=0;i<b.length;i++)
			b[i]=s2.substring(i,s2.length());
		Arrays.sort(a);
		Arrays.sort(b);
	}
	public int lcp(String a, String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				return i;
		}
		return min;
	}
	public String longestCommmonSubStirng()
	{
		String result="";
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				int len=lcp(a[i],b[j]);
				//System.out.println(len);
				if(len>result.length())
				{
					result=a[i].substring(0,len);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		String a="sony";
		 String b="sonyso";
		//String a="mandalivamshikrishna";
		// String b="mvamshiakrishanaaaaa";
		//String b="mvamshikrishnaaa";

		Lcs q=new Lcs(a,b);
		System.out.println(q.longestCommmonSubStirng());
	}
}