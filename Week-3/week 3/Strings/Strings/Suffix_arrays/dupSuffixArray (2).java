import java.util.*;
class SuffixArray{
	String[] suffixes;
	String lcp="";
	int n;
	public SuffixArray(String s)
	{
		n=s.length();
		suffixes=new String[n];
		for(int i=0;i<n;i++)
		{
			suffixes[i]=s.substring(i,n);
		}
		sort(suffixes);

	}
	public void longestrepeated(int m)
	{
		int lg=m;
		String result="" ;
		for(int i=1;i<n;i++)
		{
			int len=lcp(suffixes[i],suffixes[i-1]);
			if(len>=lg){
				result=suffixes[i].substring(0,len);
				//lg=len;
				System.out.println(result);
			}
		}
		lcp=result;
	}
	public static int lcp(String a,String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				 //return -1;
				return i;
		}
		//return 1;
		return min;
	}
	public static void sort(String[] a)
	{
		sort(a,0,a.length-1,0);
	}
	public static int charAt(String s,int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a,int lo, int hi,int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt(a[lo],d);
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<v)exch(a,i++,lt++);
			else if(t>v) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,d);
		if(v>=0) sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	public static void exch(String[] a, int i, int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void kthrepeated(int k)
	{
		String result="",result1="";
		String a[]=suffixes;
		for (int i=0;i<a.length-k;i++) {
			int len=lcp(a[i],a[i+1]);
			String m=a[i].substring(0,len);
			if (lcp(m,a[i+k])==m.length()) {
				if (m.length()>result.length()) {
					result=m;
				}
				result1+=m+" ";
			}
		}
		System.out.println("Output "+result);
		System.out.println("Output1 "+result1);
	}
	public void display()
	{
		for (int i=0;i<n ;i++ ) {
			System.out.println(i+" "+suffixes[i]);
		}
	}
	public static void main(String[] args) {
		String s="abcdbcabcdefghdefaaaabcde";
		System.out.println(s);
		SuffixArray one=new SuffixArray(s);
		// one.Suffixes(s);
		// one.display();
		System.out.println(s+" mmmmmmmmm");
		one.kthrepeated(2);
		one.longestrepeated(2);
		//System.out.println(one.lcp);
	}
}