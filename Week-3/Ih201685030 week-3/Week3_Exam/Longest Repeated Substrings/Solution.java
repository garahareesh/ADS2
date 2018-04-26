import java.util.*;
public class Solution {
	String [] a;
	int k;
	Solution(String str, int k)
	{
		a=new String[str.length()];
		this.k=k;
		int n=str.length();
		for(int i=0;i<n;i++)
			a[i]=str.substring(i,n);
		radix(a);
		// Arrays.sort(a);
		System.out.print(longestSubstring(a,k));
		// longestSubstring(a,k);
	}
	public String longestSubstring(String [] a, int k)
	{
		int n=a.length;
		String s="";
		for(int i=1;i<n;i++)
		{
			int len=lcp(a[i],a[i-1]);
			if(len>=k)
				s+=a[i].substring(0,len)+"\n";
		}
		if(s.equals(""))
			s="-1"+"\n";

		return s;
	}
	public int lcp(String m,String n)
	{
		int min=Math.min(m.length(),n.length());
		for(int i=0;i<min;i++)
		{
			if(m.charAt(i)!=n.charAt(i)) return  i;
		}
		return min;
	}
	public void radix(String [] a)
	{
		sort(a,0,a.length-1,0);
	}
	public void sort(String[] a, int lo, int hi, int d)
	{
		if(hi<=lo) return;
		int lt=lo,gt=hi;
		int p=charAt(a[lo],d);
		int i=lo+1;
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<p) exch(a,lt++,i++);
			else if(t>p) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,d);
		if(p>=0) sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	public int charAt(String a, int d)
	{
		if(d==a.length()) return -1;
		return a.charAt(d);
	}
	public void exch(String [] a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOftestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOftestcases;i++)
		{
			String str=sc.nextLine();
			String [] ss=str.split(",");
			Solution ob=new Solution(ss[0],Integer.parseInt(ss[1]));
		}
	}
}