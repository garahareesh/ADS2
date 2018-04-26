//implement longest common substring
import java.util.*;
public class LCS
{
	String []a;
	String []b;
	int n;
	public LCS(String c, String d)
	{
		lcs(c,d);
	}
	public String[] suffix(String a)
	{
		String [] k=new String[a.length()];
		for(int i=0;i<a.length();i++)
		{
			k[i]=a.substring(i,a.length());
		}
		return k;
	}
	public int index(String[] k,int len,int i)
	{
		return (len-k[i].length());
	}
	public void lcs(String c, String d)
	{
		a=new String[c.length()];
		b=new String[d.length()];
		a=suffix(c);
		b=suffix(d);
		Arrays.sort(a);
		Arrays.sort(b);
		int len_c=c.length();
		int len_d=d.length();
		int i=0;
		int j=0;
		String res="";
		while(i<len_c && j<len_d)
		{
			int p=index(a,len_c,i);
			int q=index(b,len_d,j);
			String lcp=lcp(c,p,d,q);
			if(lcp.length()>res.length()) res=lcp;
			if(compare(c,p,d,q)<0) i++;
			else j++;
		}
		System.out.println("longest common substring..+"+ res);
	}
	public int compare(String a, int p, String b, int q)
	{
		int min=Math.min(a.length()-p,b.length()-q);
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i+p)!=b.charAt(i+q))
				return a.charAt(i+p)-b.charAt(i+q);
		}	
		if(a.length()-p<b.length()-q) return -1;
		else if(a.length()-p > b.length()-q) return 1;
		else return 0; 
	}
	public String lcp(String a, int p, String b, int q)
	{
		int min=Math.min(a.length()-p,b.length()-q);
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i+p)!=b.charAt(i+q)) return a.substring(p,i+p);
		}
		return a.substring(p,p+min);
	}
	public static void main(String[] args) {
		String a="hareeshmsithyd";
		String b="hareeshgara";
		LCS ob=new LCS(a,b);
	}
}