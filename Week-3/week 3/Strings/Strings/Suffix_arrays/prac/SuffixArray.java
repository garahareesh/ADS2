import java.util.*;
class SuffixArray{
	static String[] suffixes;
	static String lcp="";
	public static void Suffixes(String s)
	{
		int n=s.length();
		suffixes=new String[n];
		for(int i=0;i<n;i++)
		{
			suffixes[i]=s.substring(i,n);
		}
		Arrays.sort(suffixes);
		int lg=2;
		String result="";
		System.out.println(Arrays.toString(suffixes));
		for(int i=1;i<n;i++)
		{
			int len=lcp(suffixes[i],suffixes[i-1]);
			if(len>=lg){
				result=suffixes[i].substring(0,len);
				lg=len;
				//System.out.println(result);
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
	// public static void sort(String[] a)
	// {
	// 	sort(a,0,a.length-1,0);
	// }
	// public static int charAt(String s,int d)
	// {
	// 	if(d>=s.length()) return -1;
	// 	return s.charAt(d);
	// }
	// public static void sort(String[] a,int lo, int hi,int d)
	// {
	// 	if(hi<=lo) return;
	// 	int lt=lo;
	// 	int gt=hi;
	// 	int i=lo+1;
	// 	int v=charAt(a[lo],d);
	// 	while(i<=gt)
	// 	{
	// 		int t=charAt(a[i],d);
	// 		if(t<v)exch(a,i++,lt++);
	// 		else if(t>v) exch(a,i,gt--);
	// 		else i++;
	// 	}
	// 	sort(a,lo,lt-1,d);
	// 	if(v>=0) sort(a,lt,gt,d+1);
	// 	sort(a,gt+1,hi,d);
	// }
	// public static void exch(String[] a, int i, int j)
	// {
	// 	String temp=a[i];
	// 	a[i]=a[j];
	// 	a[j]=temp;
	// }
	public static void main(String[] args) {
		String s="mississippi";
		SuffixArray one=new SuffixArray();
		one.Suffixes(s);
		
	}
}