import java.util.*;
class Quick3way{
	public static String[] sort(String[] a)
	{
		int n=a.length;
		sort(a,0,n-1,0);
		return a;
	}
	public static int charAt(String s,int d)
	{
		assert d>=0&&d<=s.length();
		if(d==s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a, int lo, int hi, int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt(a[lo],d);
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<v)exch(a,lt++,i++);
			else if(t>v)exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,d);
		if(v>=0)sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	public static void exch(String[] a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		String[] a={"xxdfhbhihl","lkhlkhlfkuu","hkhkatu","l","asd","uuuu","opdf","zbwf","dfdf","bcdf"};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(sort(a)));
	}
}