import java.util.*;
class MyLngstCmnSubstrpro
{
	String[] st1;
	String[] st2;
	String s1,s2;
	int m,n;
	public MyLngstCmnSubstrpro(String s1,String s2)
	{
		this.s1=s1;
		this.s2=s2;
		 m=s1.length();
	n=s2.length();
		st1=new String[m];
		st2=new String[n];
		for(int i=0;i<m;i++)
		{
			st1[i]=s1.substring(i,m);
		}
		for(int i=0;i<n;i++)
		{
			st2[i]=s2.substring(i,n);
		}
		Arrays.sort(st1);
		Arrays.sort(st2);
		lcs(st1,st2);
	}
	 int lcp(String str1,String str2)
	{
		int min=Math.min(str1.length(),str2.length());
		for(int i=0;i<min;i++)
		{
			if(str1.charAt(i)!=str2.charAt(i))
			{
				return i;
			}
		}
		return min;
	}
	public void lcs(String[] st1,String st2[])
	{
		String res="";
		for(int i=0;i<st1.length;i++)
		{
			for(int j=0;j<st2.length;j++)
			{
				int l=lcp(st1[i],st2[j]);
				if(l>res.length())
				{
					res=st1[i].substring(0,l);
				}
			}
		}
		System.out.println(res+"------res");
	}
	public static void main(String[] args) {
		String s1="lllllllllllllllllllllll";
		String s2="lll";
	MyLngstCmnSubstrpro m=new  MyLngstCmnSubstrpro(s1,s2);	

	}
}