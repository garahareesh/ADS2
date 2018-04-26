import java.util.*;
public class KgramSubstring
{
	
	int count=0;
	String[] a;
	public KgramSubstring(String s1,String s2)
	{
		
		int n=s1.length();
		a=new String[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s1.substring(i,n);
		}
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for(int i=1;i<a.length;i++)
		{
			int len=lcp(a[i],a[i-1]);
			System.out.println("len:"+len);
			if(len>=s2.length())
			{
				for(int j=1;j<=len;j++)
				{
					if(a[i].substring(0,j).equals(s2))
					{
						count++;
						break;
					}
				}
			}
		}
	}
	public int frequency()
	{
		return count+1;
	}
	public int lcp(String a,String b)
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
		String s1="likkirikkilikkirikilikki";
		String s2="likki";
		KgramSubstring ks=new KgramSubstring(s1,s2);
		System.out.println(ks.frequency());
	}
}