import java.util.*;
class Linkedsort{
	public static void sort(String[] a)
	{
		LinkedList<String>list=new LinkedList<String>();
		for(String s:a) list.add(s);
		int n=a.length;
		sort(list,0,n-1,0);
	}
	public static int charAt(String s,int d)
	{
		if(d<s.length) return s.charAt(d);
		return -1;
	}
	public static void sort(LinkedList<String> list,int lo, int hi,int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt(list.get(lo),d);
		while(i<=gt)
		{
			int t=charAt(list.get(i),d);
			if(t<v) exch(list,lt++,i++);
			else if(t>v) exch(list,i,gt--);
			else i++;
		}
		sort(list,i,lt-1,d);
		if(v>=0) sort(list,lt,gt,d+1);
		sort(list,gt+1,hi,d);
	}
}