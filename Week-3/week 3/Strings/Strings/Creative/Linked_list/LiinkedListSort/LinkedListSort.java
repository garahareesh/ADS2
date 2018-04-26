import java.util.*;
class LinkedListSort{
	static LinkedList<String> list;
	public static void sort(String[] a)
	{
		list=new LinkedList();
		for(String e:a)list.add(e);
		sort(list,0,list.size()-1,0);
		System.out.println(list);
	}
	public static int charAt(String s,int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(LinkedList list,int lo, int hi, int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt((String)list.get(lo),d);
		while(i<=gt)
		{
			int t=charAt((String)list.get(i),d);
			if(t<v) exch(list,i++,lt++);
			else if(t>v) exch(list,i,gt--);
			else i++;
		}
		sort(list,lo,lt-1,d);
		if(v>=0)sort(list,lt,gt,d+1);
		sort(list,gt+1,hi,d);
	}
	public static void exch(LinkedList list,int i,int j)
	{
		Object temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}
	public static void main(String[] args) {
		String[] a={"she","sells","sea","shells","on","sea","shore"};
		sort(a);
	}
}